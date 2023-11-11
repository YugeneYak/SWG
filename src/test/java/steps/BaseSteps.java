package steps;

import hooks.Hooks;
import utils.Properties;
import  java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.logging.Logger;

public class BaseSteps {
//    private static final Logger LOGGER = Logger.getLogger(Hooks.class.getName());

    private  WebDriver driver;

    // задаем параметры открытия браузера
    public void setupDriver() {

        final Random random = new Random();

        System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/workspace/chromedriver/chromedriver");
//        System.setProperty("webdriver.chrome.logfile", "/var/lib/jenkins/workspace/chromedriver/chromedriver" + random + ".log");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("/chrome/linux-119.0.6045.105/chrome-linux64/chrome");
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--headless");
        options.addArguments("--disable-extensions"); // disabling extensions
        options.setCapability("acceptInsecureCerts", true);
        options.setCapability("pageLoadStrategy", "eager");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("window-size="+Properties.getBrowserSize());
        options.addArguments("--remote-debugging-pipe");
        options.addArguments("--enable-logging --v=1"); // Bypass OS security model
        options.addArguments("--disable-infobars"); // disabling infobars

        driver = new ChromeDriver(options); // присваиваем значение driver
    }

    // метод для получения значения driver
    public WebDriver getDriver() {
        return driver;
    }

}