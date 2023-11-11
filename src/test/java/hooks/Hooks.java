package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import utils.Properties;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;
import static io.restassured.config.HttpClientConfig.httpClientConfig;
//import static utils.Properties.getRemoteUrl;

public class Hooks {

    private static final Logger LOGGER = Logger.getLogger(Hooks.class.getName());

    private static int to = 90000;
    @Before
    public void before(Scenario scenario) {
        System.out.println("The name of the scenario is: " + scenario.getName());
    }
    /**
     * Настройка вебдрайвера, выполняется перед каждым тестом
     */
    @Before
    public void setup() {
        browserSize = Properties.getBrowserSize();
        baseUrl = Properties.getBaseUrl();
        timeout = to;
        fastSetValue = true;

        browserCapabilities.setCapability("enableVNC", true);
        browserCapabilities.setCapability("enableVideo", true);
//        try {
//            remote = getRemoteUrl();
//        } catch (RuntimeException e) {
//            LOGGER.log(Level.SEVERE, e.toString(), e);
//        }
//        open("http://yandex.ru");
    }

    @Before
    public static void configureRestAssured() {
        RestAssured.baseURI = Properties.getBaseUrl();
        RestAssured.config().httpClient(httpClientConfig().setParam("CONNECTION_TIMEOUT", to));
        RestAssured.config().httpClient(httpClientConfig().setParam("SO_TIMEOUT", to));
        RestAssured.config().httpClient(httpClientConfig().setParam("CONNECTION_MANAGER_TIMEOUT", to));
        RestAssured.registerParser("text/html", Parser.JSON);
    }

    /**
     * Сброс кеша, куков браузера, выполняется после каждого теста
     */
    @After
    public void clearCache() {
        clearBrowserCache();
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }
}