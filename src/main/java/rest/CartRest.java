package rest;

import assertion.AssertCode;
import builder.FieldsBuilder;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import io.restassured.response.Response;
import mapper.JsonMapper;
import model.basket.ButBasketRabbit;
import org.junit.Assert;
import validator.FieldsValidator;
import validator.SchemaValidator;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static helper.AttachHelper.attachResponse;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;

public class CartRest extends TestBase {

    public void checkAdd() {
        Response resp = given()
                .queryParam("add", "{287}")
                .queryParam("id_contact_check", email)
                .queryParam("token_admin", token)
                .when()
                .log().all()
                .get(category)
                .then()
                .extract().response();
        String jsonResponse = resp.getBody().prettyPrint();
        attachResponse(jsonResponse);
        AssertCode.assertStatusCode(resp, "Проверка статус кодов ответа", SC_OK, SC_CREATED, SC_ACCEPTED);
    }

    public void checkRemove() {
        Response resp = given()
                .queryParam("remove", "{287}")
                .queryParam("id_contact_check", email)
                .queryParam("token_admin", token)
                .when()
                .log().all()
                .get(category)
                .then()
                .extract().response();
        String jsonResponse = resp.getBody().prettyPrint();
        attachResponse(jsonResponse);
        AssertCode.assertStatusCode(resp, "Проверка статус кодов ответа", SC_OK, SC_CREATED, SC_ACCEPTED);
    }

    public void checkCrm(String price) throws IOException, ProcessingException, InvocationTargetException, IllegalAccessException {
        File equip = new File("src/main/resources/schemas/ButBasketRabbit.json");
        Response resp = given()
                .queryParam("email", email)
                .when()
                .log().all()
                .get(crm)
                .then()
                .extract().response();
        AssertCode.assertStatusCode(resp, "Проверка статус кодов ответа", SC_OK, SC_CREATED, SC_ACCEPTED);
        String jsonResponse = resp.getBody().prettyPrint();
        attachResponse(jsonResponse);
        Assert.assertTrue("Валидация полей ответа", SchemaValidator.isJsonValid(equip, resp.getBody().asString()));
        FieldsBuilder builder = new FieldsBuilder.Builder()
                .addParam("success.price", price)
                .build();
        ButBasketRabbit butBasketRabbit = JsonMapper.jsonToObject(resp.getBody().asString(), ButBasketRabbit.class);
        Assert.assertTrue("Проверка полей ответа", new FieldsValidator().isEqual(builder, butBasketRabbit));

    }
}
