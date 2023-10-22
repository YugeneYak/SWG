package steps;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import pages.MainPage;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class UserLoginSteps {

    private MainPage mainPage = new MainPage();

    @Когда("пользователь нажал на кнопку Вход")
    public void пользователь_нажал_на_кнопку_Вход() {
        $(byXpath("//a[@data-test-button='login']")).scrollTo().click();
    }

    @Когда("пользователь нажал на кнопку Войти")
    public void пользователь_нажал_на_кнопку_Войти() {
        mainPage.clickOnEnter();
    }

    public static String user_fio="";

}