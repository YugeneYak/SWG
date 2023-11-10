package steps;

import hooks.Hooks;
import utils.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Collections;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.UserPrincipal;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
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


        System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/workspace/chromedriver/chromedriver");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
////        options.addArguments("--no-sandbox"); // Bypass OS security model
//        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//        options.addArguments("--disable-extensions"); // disabling extensions
//        options.addArguments("--disable-gpu"); // applicable to windows os only
////        System.setProperty("webdriver.chrome.whitelistedIps", "");
////        options.setCapability("acceptInsecureCerts", true);
////        options.setCapability("pageLoadStrategy", "eager");
////        options.addArguments("--ignore-certificate-errors");
////        options.addArguments("--allowed-ips=''");
////        options.addArguments("window-size="+Properties.getBrowserSize());
//        System.setProperty("webdriver.chrome.logfile", "/var/lib/jenkins/workspace/chromedriver/chromedriver.log");
////        options.addArguments("--remote-debugging-pipe");
////        options.addArguments("--enable-logging --v=1"); // Bypass OS security model
////
////        options.addArguments("--headless"); // open Browser headless
////        options.addArguments("--disable-infobars"); // disabling infobars
////        options.addArguments("--disable-extensions"); // disabling extensions
////        options.addArguments("--disable-gpu"); // applicable to windows os only

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--headless");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-features=VizDisplayCompositor");
        options.addArguments("--disable-features=VizHitTestSurfaceLayer");
        options.addArguments("--disable-features=IgnoreGpuBlacklist");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--remote-debugging-port=9222");

        System.out.println("000000");

        System.out.println("9999999");
        open("https://yandex.ru");
        System.out.println("888888");

//        try {
//            driver = new ChromeDriver(options); // присваиваем значение driver

        System.out.println("1111111");
//        }catch (RuntimeException e) {
//            System.out.println("ошибки11=" + e.toString() + "=11ошибки");
//            System.out.println("trass11=====================");
//            e.printStackTrace();
//            System.out.println("====================11trass");
//        }

//        driver = new ChromeDriver(options); // присваиваем значение driver
    }

    // метод для получения значения driver
//    public WebDriver getDriver() {
//        System.out.println("222222");
//        return driver;
//
//    }

}