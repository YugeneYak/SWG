package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static utils.Properties.getBaseUrl;

public class MainPage extends BasePage {

    private SelenideElement H2Title = $(byXpath("//h2"));
    private SelenideElement delivery = $(byXpath("//p[@class='dilivery_price dilivery_price_red']"));
    private ElementsCollection toCart = $$(byXpath("//*[@data-test-item='order']"));
    private SelenideElement productInCart = $(byXpath("//*[@data-test-basket='widget']/a"));
    private SelenideElement Authorize = $(byXpath("//button[@class='btn authorize unlocked']"));
    private SelenideElement AuthorizeConfirm = $(byXpath("//button[@class='btn modal-btn auth authorize button']"));
    private SelenideElement AuthorizeClose = $(byXpath("//button[@class='btn modal-btn auth btn-done button']"));
    private SelenideElement login = $(byXpath("//a[@data-test-button='login']"));
    private SelenideElement enter = $(byXpath("//button[@data-test-button='enter']"));
    private SelenideElement catalog = $(byXpath("//*[@data-test-catalog='section']"));
    private SelenideElement orderbyself = $(byXpath("//div[@class='button_self_order']/button"));
  //  private ElementsCollection orderedItem = $$(byXpath("//div[@class='item_goods']/span(1)"));

    private static String productName = "";
    private static int productPrice = 0;

    public String getProductName() {
        return productName;
    }
    public int getProductPrice() {
        return productPrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    private static String productURL = "";
    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }

    private static int productNumber = 1;
    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }
    public int getProductNumber() {
        return productNumber;
    }

//    public void checkUrl() {
//        Assert.assertEquals('/', url());
//    }

    public void checkMenu() {
      //  H2Title.forEach(menu -> shouldBeConditions(menu, exist, visible));
//        category.shouldHave(texts("Каталог", "Категории", "От А до Я", "Распродажа"));
    }

    public void checkPageLoaded() {

        H2Title.shouldHave(text("VITAMIN.TRADE API Documentation"));
        click(Authorize);
        sleep(100);
        switchTo().activeElement();
        $(byXpath("//div[@class='auth-container']/form/div/div/div[4]/section/input")).setValue("hGHhgv34bH");
        click(AuthorizeConfirm);
        click(AuthorizeClose);
//        sleep(10500);
    }
    public void checkOrderPageDelivery() {
        //delivery.forEach(delivery -> shouldBeConditions(delivery, exist, visible));
        delivery.shouldHave(text("Скидка: 99%"));
        sleep(500);
    }


    public void addToCart(int index) {

        $(byXpath("//a[@data-test-item='order']")).scrollTo();
        setProductName($(byXpath("//a[@data-test-item='order']")).getAttribute("outerHTML").split("'")[13]);
        setProductURL($(byXpath("//a[@data-test-item='order']")).getAttribute("data-test-item-url"));
        productPrice = Integer.parseInt($(byXpath("//a[@data-test-item='order']")).getAttribute("outerHTML").split(":")[7].replaceAll("[^0-9]", ""));

        System.out.println("productPrice="+productPrice);

        for (int  i = 1; i < index; i++) {
            $(byXpath("//div[@data-test-order='number']/span[@class='plus js-ow-product-quantity-inc']")).scrollTo().click();
            sleep(100);
        }
        setProductNumber(index);
       // if ($(byXpath("//div[@data-test-order='number']/input[@class='js-ow-product-quantity']")).getAttribute("data-test-item-url")=index)
        $(byXpath("//a[@data-test-item='order']")).click();
        //sleep(50000);

    }
    public void dellFromCart(int index) {

        $(byXpath("//input[@class='basket-item-amount-filed']")).scrollTo();
        for (int  i = 1; i <= index; i++) {
            $(byXpath("//div[@class='basket-item-block-amount']/span[@data-entity='basket-item-quantity-minus']")).click();
//            sleep(100);
        }
        sleep(5000);
//        refresh();
        setProductNumber(getProductNumber()-index);
        System.out.println("Теперь товаров");
        System.out.println("Теперь товаров "+getProductNumber());


    }

    public void OpenProductURL() {
        open("http://protein.company"+productURL);
    }

    public void checkText(String text) {

        $$(byText(text)).filter(visible).shouldHaveSize(1);
    }

    public void checkProductInCart() {

        for (int i=0;i<10;i++) {
            if ($(byXpath("//*[@data-test-basket='widget']/a")).exists()) {
                $(byXpath("//*[@data-test-basket='widget']/a")).scrollTo();
                checkText(productInCart, getProductName());
                break;
            }
            else {
                sleep(500);
                refresh();
            }
        }

    }

    public void clickOnButton(String buttonName) {
        sleep(500);
        click($$(byText(buttonName)).filterBy(visible).first());
    }

//    public void clickOnLogo() {
//        click(logo);
//    }
    public void clickOnLogin() {
        click(login);
    }
    public void clickOnEnter() {
        click(enter);
    }
//    public void clickOnAuthorize() {
//        click(logo);
//    }
    public void clickOnCatalog() {
//        click(catalog);
        //catalog.click();
        open("https://protein.company/alphabet/?key=C");
    }
    public void clickOnOrderbyself() {
        shouldBeConditions(orderbyself, enabled, visible);
        click(orderbyself);
     //   orderbyself.shouldBe(visible).doubleClick();
    }

    public void clickOnSection(String sectionName) {
        click($(byXpath("//nav/a[text()='" + sectionName + "']")));
    }

    public void checkOrderPage() {$(byXpath("//*[@data-test-page='order_page']")).exists(); }

    public void BackToBasket() {$(byXpath("//a[@id='js-ow-small-basket-block']")).click();}



}