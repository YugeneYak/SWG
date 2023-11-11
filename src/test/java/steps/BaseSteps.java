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

         String os = System.getProperty("os.name").toLowerCase();

        System.out.println("1111111111");
System.out.println(os);
        System.out.println("2222222222");

        ChromeOptions options = new ChromeOptions();

        if (os.contains("win")) {
            System.out.println("55555555");
            System.out.println(os);
            System.out.println("66666666");
            // настройки для операционной системы Windows
//            System.setProperty("webdriver.chrome.driver", "D:\\Users\\yugene\\Documents\\test\\src\\test\\resources\\chromedriver\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "C:\\SWG_Tests\\src\\test\\resources\\chromedriver\\chromedriver.exe");

        } else if (os.contains("mac")) {
            // настройки для операционной системы macOS
            System.setProperty("webdriver.chrome.driver", "путь_к_драйверу_для_macOS");
        } else if (os.contains("nix") || os.contains("nux") || os.contains("sol")) {
            // настройки для операционных систем на основе Unix
            System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/workspace/chromedriver/chromedriver");

            options.addArguments("--no-sandbox"); // Bypass OS security model
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--headless");
            options.addArguments("--disable-extensions"); // disabling extensions
            options.addArguments("--remote-debugging-pipe");
            options.addArguments("--enable-logging --v=1"); // Bypass OS security model
            options.addArguments("--disable-infobars"); // disabling infobars
        } else {
            // настройки по умолчанию для других операционных систем
            System.setProperty("webdriver.chrome.driver", "путь_к_драйверу_по_умолчанию");
        }

        options.setCapability("acceptInsecureCerts", true);
        options.setCapability("pageLoadStrategy", "eager");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("window-size="+Properties.getBrowserSize());


        driver = new ChromeDriver(options); // присваиваем значение driver
    }

    // метод для получения значения driver
    public WebDriver getDriver() {
        return driver;
    }

}