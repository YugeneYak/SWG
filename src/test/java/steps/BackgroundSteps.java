package steps;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class BackgroundSteps {

    private MainPage mainPage = new MainPage();
    private UserLoginSteps userLoginSteps = new UserLoginSteps();
    private SelenideElement basketNotEmpty = $(byXpath("//a[@class='js-ow-ab-basket-button rm_goorder btn']"));

}