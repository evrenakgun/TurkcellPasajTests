package pages;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstProductOfBestSellersListPage extends BasePage {
    public FirstProductOfBestSellersListPage(WebDriver driver) {
        super(driver);
    }

    // ***** Web Elements *****
    @Description("Ürün adı")
    @FindBy(css = "[class='product-detail__title-property'] h1")
    public WebElement productName;

    @Description("Ürün fiyatı")
    @FindBy(css = "[class='a-price-radio-b price-radio-cash a-price-radio-b--advantage '] [class='a-price-val']")
    public WebElement productPrice;

    @Description("Ürünün para birimi")
    @FindBy(css = "[class='a-price-radio-b price-radio-cash a-price-radio-b--advantage '] [class='a-price__currency']")
    public WebElement productCurrency;


    // ***** Methods *****
    @Description("Ürünün adını getir.")
    public void getProductName() {
        getText(productName);
    }

    @Description("Ürünün fiyatını getir.")
    public void getProductPrice() {
        getText(productPrice);
    }

    @Description("Ürünlerin adını karşılaştır.")
    public void verifyBestSellersProductName(String name) {
        isTextsEquals(name, getText(productName));
    }

    @Description("Ürünlerin fiyatını karşılaştır.")
    public void verifyBestSellersProductPrice(String price) {
        isTextsEquals(price, getText(productPrice) + " " + getText(productCurrency));
    }

    @Description("Ürünün fiyatını görene kadar sayfayı aşağı kaydır.")
    public void scrollDownUntilProductPriceVisible() {
        scrollDownUntilElementVisible(productPrice);
    }
}
