package assertion;

import io.restassured.response.Response;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public final class AssertCode {

    private AssertCode(){}

    /**
     * Метод для проверки кода ответа сервера
     * @param response Ответ сервера
     * @param operation Описание операции
     * @param code Ожидаемый код ответа сервера
     */
    public static void assertStatusCode(Response response, String operation, int code) {
        assertThat(String.format("На вызов %s получили ответ с неверным кодом",
                    operation), response.getStatusCode(), equalTo(code)
        );
    }

    /**
     * Метод для проверки кодов ответа сервера
     * @param response Ответ сервера
     * @param operation Описание операции
     * @param codes Ожидаемые коды ответа сервера
     */
    public static void assertStatusCode(Response response, String operation, int... codes) {
        int code = response.getStatusCode();
        boolean contains = IntStream.of(codes).anyMatch(x -> x == code);
        assertThat(String.format(
                "На вызов %s получили ответ с неверным кодом, ответ не содержит коды %s. Status code %s",
                operation, Arrays.toString(codes), code), contains);
    }
}