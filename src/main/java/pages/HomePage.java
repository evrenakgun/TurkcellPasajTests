package pages;

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
    public void scrollDownUntilVisibleBestSellersFirstProductName() {
        scrollDownUntilElementVisible(bestSellersFirstProductName);
    }

    @Description("Çok satanlar listesindeki ilk ürünün adını getir.")
    public String getBestSellersFirstProductName() {
        return getText(bestSellersFirstProductName);
    }

    @Description("Çok satanlar listesindeki ilk ürünün fiyatını getir.")
    public String getBestSellersFirstProductPrice() {
        return getText(bestSellersFirstProductPrice).replaceAll("\\sTL.*$","");
    }

    @Description("Çok satanlar listesindeki ilk ürünün detaylarına git.")
    public void clickToBestSellersFirstProduct() {
        clickWithJs(bestSellersFirstProduct);
    }

    // ***** Best Deals Methods *****
    @Description("En iyi teklifler listesini görene kadar sayfayı aşağı kaydır.")
    public void scrollDownUntilVisibleBestDealsFirstProductName() {
        scrollDownUntilElementVisible(bestDealsFirstProductName);
    }

    @Description("En iyi teklifler listesindeki ilk ürünün detaylarına git.")
    public void clickToBestDealsFirstProduct() {
        clickWithJs(bestDealsFirstProduct);
    }

    @Description("PC-Tablet kategorisine git.")
    public void clickToPcTabletCategory() {
        clickWithJs(pcTabletCategoryButton);
    }

}

