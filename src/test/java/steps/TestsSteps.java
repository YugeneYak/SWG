package steps;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
//import org.apache.xpath.operations.String;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Properties;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;



public class TestsSteps {

    private WebDriver driver; //добавляем поле driver

//    private ElementsCollection filterButtons = $$(byXpath("//input[@name='color-temp']"));

    @Дано("Открыта страница сайта {string}")

    public  void открыта_страница_сайта(String text) {

        BaseSteps baseSteps = new BaseSteps();
        baseSteps.setupDriver(); // Вызов метода setupDriver() из класса BaseSteps
        driver = baseSteps.getDriver(); // присваиваем driver значение из BaseSteps

        driver.get("http://"+Properties.getBaseUrl()+text);


    }

    @И ("Приняты куки")
    public  void приняты_куки() {

        Assert.assertTrue(driver.findElement(byCssSelector(".cookie_button")).isDisplayed());
        driver.findElement(byCssSelector(".cookie_button")).click(); //кликаем кнопку

//        driver.quit();
    }

    @Тогда("Открываем меню каталога")
    public  void Открываем_меню_каталога() {

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
}