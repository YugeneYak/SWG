package utils;

/**
 * Класс содержит статичные поля для данных из application.properties
 */
public class Properties {

    private Properties() {
        throw new IllegalStateException("Properties class");
    }

    /** Поле размер окна браузера*/
    private static String browserSize = "1720,880";

    /** Поле бзаовый url адрес */
    private static String baseUrl = "test.swgshop.ru";

    private static String remoteUrl = null;

    /**
     * Метод загружает и присваивает переменной размер окна браузера
     * значение из application.properties
     * @return Возвращает размер окна браузера
     */
    public static String getBrowserSize() {
        if (browserSize == null) {
            browserSize = PropertyLoader.loadProperty("browser.size");
        }
        return browserSize;
    }

    /**
     * Метод загружает и присваивает переменной базовый url адрес
     * значение из application.properties
     * @return Возвращает базовый url адрес
     */
    public static String getBaseUrl() {
        if (baseUrl == null) {
            baseUrl = PropertyLoader.loadProperty("test.swgshop.ru");
        }
        return baseUrl;
    }

    public static String getRemoteUrl() {
        if (remoteUrl == null) {
            remoteUrl = PropertyLoader.loadProperty("remote.url");
        }
        return remoteUrl;
    }
}