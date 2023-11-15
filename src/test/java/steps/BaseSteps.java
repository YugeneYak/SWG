package steps;

import hooks.Hooks;
import org.json.JSONObject;
import utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.logging.Logger;

import static steps.ApiSteps.apiPropertyFieldsJson;

public class BaseSteps {

    private static WebDriver driver;

    // задаем параметры открытия браузера
    public void setupDriver() {

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {

            ChromeOptions options = new ChromeOptions();
            // настройки для операционной системы Windows
            System.setProperty("webdriver.chrome.driver", "C:\\SWG_Tests\\src\\test\\resources\\chromedriver\\chromedriver.exe");
            options.setCapability("acceptInsecureCerts", true);
            options.setCapability("pageLoadStrategy", "eager");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("window-size="+Properties.getBrowserSize());
            driver = new ChromeDriver(options); // присваиваем значение driver

        } else if (os.contains("nix") || os.contains("nux") || os.contains("sol")) {
            // настройки для операционной системы linux
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

    //отправка ошибок в телегу
    public static void processException(String scenarioName, String method, String errorMessage) {

        driver.get("https://api.telegram.org/bot6844886669:AAEqljCTJI3Ddo_5mzBmPFd3oTnYgpyf4VE/sendMessage?chat_id=-1001812186034&text=" +
                "Сценарий: " + scenarioName + "" + System.lineSeparator() +
                "%0AШаг: " + method + " " + System.lineSeparator() +
                "%0AСтатус: " + errorMessage);
        driver.quit();
    }

    //отлов ошибок типов данных в обмене сайта с конфигуратором по API
    public static void checkType(String propCode) {

        if (apiPropertyFieldsJson.has(propCode)) {
            JSONObject xmlOut = apiPropertyFieldsJson.getJSONObject(propCode);
            String type = xmlOut.getString("TYPE");
            String name = xmlOut.getString("NAME");
//            System.out.println("Значение TYPE для ключа " + propCode + ": " + type);
//            System.out.println("Значение NAME для ключа " + propCode + ": " + name);
        } else {
            System.out.println("Ключ " + propCode + " не найден");
        }
    }

    // Функция для получения значения по ключу
    public static String getValueByKey(HashMap<String, String> data, String key) {
        System.out.println("data " + data + " не найден");
        // Используем метод get для получения значения по ключу
        return data.get(key);
    }

}