package steps;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import cucumber.api.java.ru.Когда;
import rest.CartRest;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class RestSteps {

    private CartRest cartRest = new CartRest();

    @Когда("выполнен метод add category")
    public void выполнен_метод_add_category() {
        cartRest.checkAdd();
    }


    @Когда("выполнен метод remove category")
    public void выполнен_метод_remove_category() {
        cartRest.checkRemove();
    }
}