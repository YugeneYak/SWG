package steps;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
//import org.apache.xpath.operations.String;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import cucumber.api.java.Before;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;


public class TestsSteps {

    private static WebDriver driver; //добавляем поле driver и используем  static, чтобы driver не был переинициализирован

    @Before
    public void setup() {
        // Создание экземпляра класса BaseSteps
        BaseSteps baseSteps = new BaseSteps();

        // Инициализация драйвера
        baseSteps.setupDriver();

        // Задание значения драйвера
        driver = baseSteps.getDriver();
    }

    @Дано("Открыта страница сайта {string}")
    public  void открыта_страница_сайта(String text) {
        driver.get("http://"+Properties.getBaseUrl()+text);
    }

    @И ("Приняты куки")
    public  void приняты_куки() {

//        Assert.assertTrue(driver.findElement(byCssSelector(".cookie_button")).isDisplayed());
        driver.findElement(byCssSelector(".cookie_button")).click(); //кликаем кнопку

    }

    @Тогда("Открываем меню каталога")
    public  void Открываем_меню_каталога() {

        driver.findElement(byId("cat_menu")).sendKeys(Keys.RETURN);

    }

    @И("Находим пункты меню")
    public  void Находим_пункты_меню(List<String> menuItems) {
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
            Assert.fail("Не найдены пункты меню: " + notFoundItems);
        }
//            driver.quit();

    }

    @Тогда("Находим фильтр {string}")
    public  void находим_фильтр(String text) {

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

    @Тогда ("Выбираем раздел {string}")
    public void выбираем_раздел(String sectionName) {
        Actions actions = new Actions(driver);
        WebElement section = driver.findElement(byXpath("//*[contains(text(),'" + sectionName + "')]"));
        actions.moveToElement(section).build().perform();
    }
    @И("Находим фильтры")
    public  void Находим_фильтры(List<String> menuItems) {
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
            Assert.fail("Не найдены пункты меню: " + notFoundItems);
        }
//            driver.quit();

    }
}