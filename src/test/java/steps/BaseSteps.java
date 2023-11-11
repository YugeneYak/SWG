package steps;

import hooks.Hooks;
import utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.logging.Logger;

public class BaseSteps {

    private  WebDriver driver;

    // задаем параметры открытия браузера
    public void setupDriver() {

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {

            ChromeOptions options = new ChromeOptions();
            // настройки для операционной системы Windows
//            System.setProperty("webdriver.chrome.driver", "D:\\Users\\yugene\\Documents\\test\\src\\test\\resources\\chromedriver\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "C:\\SWG_Tests\\src\\test\\resources\\chromedriver\\chromedriver.exe");
            options.setCapability("acceptInsecureCerts", true);
            options.setCapability("pageLoadStrategy", "eager");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("window-size="+Properties.getBrowserSize());
            driver = new ChromeDriver(options); // присваиваем значение driver

        } else if (os.contains("nix") || os.contains("nux") || os.contains("sol")) {
            System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/workspace/chromedriver/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("/chrome/linux-119.0.6045.105/chrome-linux64/chrome");
            options.addArguments("--no-sandbox"); // Bypass OS security model
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--headless");
            options.addArguments("--disable-extensions"); // disabling extensions
            options.setCapability("acceptInsecureCerts", true);
            options.setCapability("pageLoadStrategy", "eager");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("window-size=" + Properties.getBrowserSize());
            options.addArguments("--remote-debugging-pipe");
            options.addArguments("--enable-logging --v=1"); // Bypass OS security model
            options.addArguments("--disable-infobars"); // disabling infobars
            driver = new ChromeDriver(options); // присваиваем значение driver
        }

    }

    // метод для получения значения driver
    public WebDriver getDriver() {
        return driver;
    }

}