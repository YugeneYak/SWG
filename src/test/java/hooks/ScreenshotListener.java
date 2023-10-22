package hooks;

import com.codeborne.selenide.logevents.SelenideLogger;
import cucumber.api.java.Before;
import io.qameta.allure.selenide.AllureSelenide;

/**
 * Класс для работы с скриншотами в allure
 */
public class ScreenshotListener {

    @Before
    public void listener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
}