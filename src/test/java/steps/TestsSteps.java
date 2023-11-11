package steps;

import cucumber.api.Scenario;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Properties;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.Before;

import static com.codeborne.selenide.Selectors.*;

public class TestsSteps {

    private static WebDriver driver; //добавляем поле driver и используем  static, чтобы driver не был переинициализирован

    private static String scenarioName;

    private static String method;

    @Before
    public void setup() {
        // Создание экземпляра класса BaseSteps
        BaseSteps baseSteps = new BaseSteps();
        // Инициализация драйвера
        baseSteps.setupDriver();
        // Задание значения драйвера
        driver = baseSteps.getDriver();
    }

    @Before
    public void before(Scenario scenario) {
        scenarioName = scenario.getName();
    }

    @Дано("Открыта страница сайта {string}")
    public void открыта_страница_сайта(String text) {
        try {
            driver.get("http://" + Properties.getBaseUrl() + text);
        } catch (Exception e) {
            method = Thread.currentThread().getStackTrace()[1].getMethodName();

            processException(scenarioName, method, "Не удалось открыть " + Properties.getBaseUrl() + text);
            Assert.fail("Не удалось открыть " + Properties.getBaseUrl() + text);
        }
    }

    @И("Приняты куки")
    public void приняты_куки() {

        try {
            Assert.assertTrue(driver.findElement(byCssSelector(".cookie_button")).isDisplayed());
            driver.findElement(byCssSelector(".cookie_button")).click(); //кликаем кнопку
        } catch (Exception e) {
            method = Thread.currentThread().getStackTrace()[1].getMethodName();

            String requiredMessage = e.getMessage().split("\\(Session info:")[0];
            processException(scenarioName, method, requiredMessage);
            Assert.fail(e.getMessage());
        }
    }

    @Тогда("Открываем меню каталога")
    public void Открываем_меню_каталога() {
        try {
            Assert.assertTrue(driver.findElement(byId("cat_menu")).isDisplayed());
            driver.findElement(byId("cat_menu")).sendKeys(Keys.RETURN);
        } catch (Exception e) {
            method = Thread.currentThread().getStackTrace()[1].getMethodName();

            String requiredMessage = e.getMessage().split("\\(Session info:")[0];
            processException(scenarioName, method, requiredMessage);
            Assert.fail(e.getMessage());
        }

    }

    @И("Находим пункты меню")
    public void Находим_пункты_меню(List<String> menuItems) {
        WebElement element = driver.findElement(byId("cat_menu_block"));
        List<WebElement> menuLinks = element.findElements(byClassName("section_name"));
        List<String> notFoundItems = new ArrayList<>();

        for (String menuItem : menuItems) {
            boolean found = false;
            for (WebElement menuLink : menuLinks) {
                if (menuLink.getText().equals(menuItem)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                notFoundItems.add(menuItem);
            }
        }

        if (notFoundItems.isEmpty()) {
            Assert.assertTrue("Все пункты меню найдены", true);
        } else {
            method = Thread.currentThread().getStackTrace()[1].getMethodName();

            processException(scenarioName, method, "Не найдены пункты меню: " + notFoundItems);
            Assert.fail("Не найдены пункты меню: " + notFoundItems);
        }
        driver.quit();

    }

    @Тогда("Находим фильтр {string}")
    public void находим_фильтр(String text) {

        List<WebElement> elements = driver.findElements(byXpath(java.lang.String.valueOf(text)));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        ArrayList<String> collectedTags = new ArrayList<String>(); // Собираем коллекцию тэгов здесь
//        ArrayList<String> collectedText = new ArrayList<String>(); // Собираем коллекцию текста здесь

        for (WebElement element : elements) {

            WebElement parentElement = (WebElement) js.executeScript("return arguments[0].parentNode;", element);
            java.lang.String outerHTML = parentElement.getAttribute("outerHTML");

            Document doc = Jsoup.parse(outerHTML);
            Elements nestedElements = doc.getAllElements();

            System.out.println("ParentElement HTML=" + nestedElements);
        }
    }

    @Тогда("Выбираем раздел {string}")
    public void выбираем_раздел(String sectionName) {
        try {
            Actions actions = new Actions(driver);
            WebElement section = driver.findElement(byXpath("//*[contains(text(),'" + sectionName + "')]"));
            actions.moveToElement(section).build().perform();
            return;
        } catch (Exception e) {
            method = Thread.currentThread().getStackTrace()[1].getMethodName();
            String requiredMessage = e.getMessage().split("\\(Session info:")[0];
            processException(scenarioName, method, requiredMessage);
            Assert.fail(e.getMessage());
        }
    }

    @И("Находим фильтры")
    public void Находим_фильтры(List<String> menuItems) {
        WebElement element = driver.findElement(byId("cat_menu_block"));
        List<WebElement> menuLinks = element.findElements(byClassName("catalog-menu__label"));
        List<String> notFoundItems = new ArrayList<>();

        for (String menuItem : menuItems) {
            boolean found = false;
            for (WebElement menuLink : menuLinks) {
                if (menuLink.getText().equals(menuItem)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                notFoundItems.add(menuItem);
            }
        }

        if (notFoundItems.isEmpty()) {
            Assert.assertTrue("Все пункты меню найдены", true);
        } else {
            method = Thread.currentThread().getStackTrace()[1].getMethodName();

            processException(scenarioName, method, "Не найден фильтр: " + notFoundItems);
            Assert.fail("Не найден фильтр: " + notFoundItems);
        }
        driver.quit();

    }

    //отлов ошибок в телегу
    public void processException(String scenarioName, String method, String errorMessage) {

        driver.get("https://api.telegram.org/bot6844886669:AAEqljCTJI3Ddo_5mzBmPFd3oTnYgpyf4VE/sendMessage?chat_id=-1001812186034&text=" +
                "Сценарий: " + scenarioName + "" + System.lineSeparator() +
                "%0AШаг: " + method + " " + System.lineSeparator() +
                "%0AОшибка: " + errorMessage);
        driver.quit();
    }
}