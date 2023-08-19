package pages;

import base.BasePage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstProductOfBestSellersListPage extends BasePage {
    public FirstProductOfBestSellersListPage(WebDriver driver) {
        super(driver);
    }

    // ***** Web Elements *****
    @FindBy(css = "[class='product-detail__title-property'] h1")
    public WebElement productName;

    @FindBy(css = "[class='a-price-radio-b price-radio-cash a-price-radio-b--advantage '] [class='a-price-val']")
    public WebElement productPrice;

    @FindBy(css = "[class='a-price-radio-b price-radio-cash a-price-radio-b--advantage '] [class='a-price__currency']")
    public WebElement productCurrency;


    // ***** Methods *****
    @Description("Ürünün adını getir.")
    @Step("Get product name Step...")
    public void getProductName() {
        getText(productName);
    }

    @Description("Ürünün fiyatını getir.")
    @Step("Get product price Step...")
    public void getProductPrice() {
        getText(productPrice);
    }

    @Description("Ürünlerin adını karşılaştır.")
    @Step("Compare product names Step...")
    public void verifyBestSellersProductName(String name) {
        isTextsEquals(name, getText(productName));
    }

    @Description("Ürünlerin fiyatını karşılaştır.")
    @Step("Compare product prices Step...")
    public void verifyBestSellersProductPrice(String price) {
        isTextsEquals(price, getText(productPrice));
    }

    @Description("Ürünün fiyatını görene kadar sayfayı aşağı kaydır.")
    @Step("Scroll down until product price is visible Step...")
    public void scrollDownUntilProductPriceVisible() {
        scrollDownUntilElementVisible(productPrice);
    }
}
