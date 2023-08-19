package pages;

import base.BasePage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // ***** Web Elements *****
    @FindBy(css = "div.o-p-header__bottom [href='/pasaj/bilgisayar-tablet']")
    public WebElement pcTabletCategoryButton;

    // ***** Best Sellers Elements*****
    //@FindBy(css = "[class='m-p-ts__tab-content__item active'] div:nth-child(1) div:nth-child(1) a:nth-child(1)")
    @FindBy(css = "[class='m-p-ts__tab-content__item active'] div:nth-child(1) div:nth-child(1) a:nth-child(1) [class='swiper-slide swiper-slide-active'] [class='m-p-pc__img']")
    public WebElement bestSellersFirstProduct;

    @FindBy(css = "[class='m-p-ts__tab-content__item active'] div:nth-child(1) div:nth-child(1) a:nth-child(1) [class='m-p-pc__title']")
    public static WebElement bestSellersFirstProductName;

    @FindBy(css = "[class='m-p-ts__tab-content__item active'] div:nth-child(1) div:nth-child(1) a:nth-child(1) [class='m-p-pc__price m-p-pc__price--secondary m-p-pc__price--dark']")
    public static WebElement bestSellersFirstProductPrice;

    // ***** Best Deals Elements *****
    @FindBy(css = "[data-ga-name='Pasaj - En İyi Teklifler'] [class='m-p-flex m-p-flex--evenly'] div:nth-child(1) a:nth-child(1)")
    public WebElement bestDealsFirstProduct;

    @FindBy(css = "[data-ga-name='Pasaj - En İyi Teklifler'] [class='m-p-flex m-p-flex--evenly'] div:nth-child(1) a:nth-child(1) [class='m-p-pc__title']")
    public static WebElement bestDealsFirstProductName;


    // ***** Methods *****

    // ***** Best Sellers Methods *****
    @Description("Çok satanlar listesini görene kadar sayfayı aşağı kaydır.")
    @Step("Scroll down until best sellers list is visible Step...")
    public void scrollDownUntilVisibleBestSellersFirstProductName() {
        scrollDownUntilElementVisible(bestSellersFirstProductName);
    }

    @Description("Çok satanlar listesindeki ilk ürünün adını getir.")
    @Step("Get first product name of best sellers list Step...")
    public String getBestSellersFirstProductName() {
        return getText(bestSellersFirstProductName);
    }

    @Description("Çok satanlar listesindeki ilk ürünün fiyatını getir.")
    @Step("Get first product price of best sellers list Step...")
    public String getBestSellersFirstProductPrice() {
        return getText(bestSellersFirstProductPrice).replaceAll("\\sTL.*$","");
    }

    @Description("Çok satanlar listesindeki ilk ürünün detaylarına git.")
    @Step("Go to first product details of best sellers list Step...")
    public void clickToBestSellersFirstProduct() {
        clickWithJs(bestSellersFirstProduct);
    }

    // ***** Best Deals Methods *****
    @Description("En iyi teklifler listesini görene kadar sayfayı aşağı kaydır.")
    @Step("Scroll down until best deals list is visible Step...")
    public void scrollDownUntilVisibleBestDealsFirstProductName() {
        scrollDownUntilElementVisible(bestDealsFirstProductName);
    }

    @Description("En iyi teklifler listesindeki ilk ürünün detaylarına git.")
    @Step("Go to first product details of best deals list Step...")
    public void clickToBestDealsFirstProduct() {
        clickWithJs(bestDealsFirstProduct);
    }

    @Description("PC-Tablet kategorisine tıkla.")
    @Step("Click to 'Pc-Tablet' category Step...")
    public void clickToPcTabletCategory() {
        clickWithJs(pcTabletCategoryButton);
    }

}

