package pages;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyBasketPage extends BasePage {
    public MyBasketPage(WebDriver driver) {
        super(driver);
    }

    // ***** Web Elements *****
    @Description("Sepetim yazısı")
    @FindBy(css = "[class='o-basket'] h1:nth-child(1)")
    public WebElement myBasketText;

    @Description("Sepetteki ürün sınıfı")
    @FindBy(css = "[class='m-basket-card basket-line-item '] [class='m-basket-card__title']")
    public WebElement myBasketClass;

    @Description("Ürün adı")
    @FindBy(css = "[class='m-basket-card basket-line-item '] [class='m-basket-card__col m-basket-card__col--product'] :nth-child(2)")
    public WebElement productNameInBasket;

    @Description("Ürün sayısı")
    @FindBy(css = "[class='m-basket-summary__head '] [class='js-summary-amount']")
    public WebElement productQuantity;


    // ***** Methods *****
    @Description("Sepetim sayfası görünür olana kadar bekle.")
    public void waitUntilMyBasketPageVisible() {
        isElementVisible(myBasketClass);
    }

    @Description("Sepetim sayfasında olduğunu kontrol et.")
    public void isCurrentPageBasketPage() {
        isTextsEquals(getText(myBasketText).trim(), "Sepetim");
    }

    @Description("Ürün isminin doğruluğunu kontrol et.")
    public void verifyProductNameInBasket(String name) {
        isTextsContains(getText(productNameInBasket), name);
    }

    @Description("Ürün sayısının doğruluğunu kontrol et.")
    public void verifyProductQuantityInBasket() {
        isTextsEquals(getText(productQuantity), "1");
    }

}
