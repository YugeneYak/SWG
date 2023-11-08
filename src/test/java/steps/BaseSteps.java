package steps;

import utils.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

public class BaseSteps {

    private WebDriver driver;

    // задаем параметры открытия браузера
    public void setupDriver() {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver");
//        ChromeOptions options = new ChromeOptions();
//        System.setProperty("webdriver.chrome.whitelistedIps", "");
//        options.setCapability("acceptInsecureCerts", true);
//        options.setCapability("pageLoadStrategy", "eager");
//        options.addArguments("--ignore-certificate-errors");
////        options.addArguments("--allowed-ips=''");
//        options.addArguments("window-size="+Properties.getBrowserSize());
//        driver = new ChromeDriver(options); // присваиваем значение driver
    }

    // метод для получения значения driver
    public WebDriver getDriver() {
        return driver;
    }

}