package pages;

import base.BasePage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyBasketPage extends BasePage {
    public MyBasketPage(WebDriver driver) {
        super(driver);
    }

    // ***** Web Elements *****
    @FindBy(css = "[class='o-basket'] h1:nth-child(1)")
    public WebElement myBasketText;

    @FindBy(css = "[class='m-basket-card basket-line-item '] [class='m-basket-card__title']")
    public WebElement myBasketClass;

    @FindBy(css = "[class='m-basket-card basket-line-item '] [class='m-basket-card__col m-basket-card__col--product'] :nth-child(2)")
    public WebElement productNameInBasket;

    @FindBy(css = "[class='m-basket-summary__head '] [class='js-summary-amount']")
    public WebElement productQuantity;


    // ***** Methods *****
    @Description("Sepetim sayfası görünür olana kadar bekle.")
    @Step("Wait until 'My Basket' page is visible Step...")
    public void waitUntilMyBasketPageVisible() {
        isElementVisible(myBasketClass);
    }

    @Description("Sepetim sayfasında olduğunu kontrol et.")
    @Step("Check for 'My Basket' text Step...")
    public void isCurrentPageBasketPage() {
        isTextsEquals(getText(myBasketText).trim(), "Sepetim");
    }

    @Description("Ürün isminin doğruluğunu kontrol et.")
    @Step("Verify product name in basket Step...")
    public void verifyProductNameInBasket(String name) {
        isTextsContains(getText(productNameInBasket), name);
    }

    @Description("Ürün sayısının doğruluğunu kontrol et.")
    @Step("Verify product quantity in basket Step...")
    public void verifyProductQuantityInBasket() {
        isTextsEquals(getText(productQuantity), "1");
    }

}
