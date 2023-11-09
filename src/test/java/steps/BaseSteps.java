package steps;

import hooks.Hooks;
import utils.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Logger;
import java.util.logging.Level;

import static com.codeborne.selenide.Configuration.*;
public class BaseSteps {
    private static final Logger LOGGER = Logger.getLogger(Hooks.class.getName());








//            try {
//            remote = getRemoteUrl();
//        } catch (RuntimeException e) {
//            LOGGER.log(Level.SEVERE, e.toString(), e);
//        }

    private  WebDriver driver;

    // задаем параметры открытия браузера
    public void setupDriver() {

        try {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            WebDriver d = new ChromeDriver(chromeOptions);
            d.get("https://www.google.nl/"); 
        }catch (RuntimeException e) {
            System.out.println("ошибки=" + e.toString() + "=ошибки");
            System.out.println("trass=====================");
            e.printStackTrace();
            System.out.println("====================trass");
        }

//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromium-browser");
        ChromeOptions options = new ChromeOptions();
//        System.setProperty("webdriver.chrome.whitelistedIps", "");
        options.setCapability("acceptInsecureCerts", true);
        options.setCapability("pageLoadStrategy", "eager");
        options.addArguments("--ignore-certificate-errors");
//        options.addArguments("--allowed-ips=''");
//        options.addArguments("window-size="+Properties.getBrowserSize());

        options.addArguments("--enable-logging --v=1"); // Bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--headless"); // open Browser headless
        options.addArguments("--disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--no-sandbox"); // Bypass OS security model

        try {
            driver = new ChromeDriver(options); // присваиваем значение driver
        }catch (RuntimeException e) {
            System.out.println("ошибки11=" + e.toString() + "=11ошибки");
            System.out.println("trass11=====================");
            e.printStackTrace();
            System.out.println("====================11trass");
        }

//        driver = new ChromeDriver(options); // присваиваем значение driver
    }

    // метод для получения значения driver
    public WebDriver getDriver() {
        return driver;
    }

}