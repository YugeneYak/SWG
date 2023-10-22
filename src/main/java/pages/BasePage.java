package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;

/**
 *  Класс описывает общие методы, для работы с веб элементами
 */
public abstract class BasePage {

    /**
     * Метод для клика по веб-элементу
     * @param element веб-элемент для клика
     */
    public void click(SelenideElement element){
        element.waitUntil(visible, 30000);
        element.shouldBe(enabled);
        element.click();
    }

    /**
     * Метод для ввода текста в веб-элемент
     * @param element элемент для ввода текста
     * @param text строка с текстом
     */
    public void typeText(SelenideElement element, String text){
        element.shouldBe(visible, enabled).val(text);
    }

    /**
     * Метод для проверки состояния элмента
     * @param element элемент для проверки
     * @param conditions состояние для проверки
     */
    public void shouldBeConditions(SelenideElement element, Condition... conditions){
        for(Condition condition: conditions){
            element.shouldBe(condition);
        }
    }

    /**
     * Метод для проверки состояния элмента
     * @param element элемент для проверки
     * @param conditions состояние для проверки
     */
    public void shouldNotBeConditions(SelenideElement element, Condition... conditions){
        for(Condition condition: conditions){
            element.shouldNotBe(condition);
        }
    }

    /**
     * Метод проверяет текст/часть текста в элементе
     * @param element элемент с текстом
     * @param text текст/часть текста для проверки
     */
    public void checkText(SelenideElement element, String text) {
        element.scrollTo().shouldBe(visible).shouldHave(text(text));
    }
}