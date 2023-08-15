package pages;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.o-p-header__bottom [href='/pasaj/bilgisayar-tablet']")
    public WebElement pcTabletCategoryButton;

    @FindBy(css = "[data-ga-name='Pasaj - En İyi Teklifler']")
    public WebElement bestDealsGenericProductList;

    @FindBy(css = "[id='9904be54-8ee7-436c-8696-3e56c4467266_tab']")
    public WebElement bestSellersGenericProductList;

    @FindBy(css = "[data-ga-name='Pasaj - En İyi Teklifler'] [class='m-p-flex m-p-flex--evenly'] div:nth-child(1) a:nth-child(1)")
    public WebElement bestDealsFirstProductOfList;

    @FindBy(css = "[class='m-p-ts__tab-content__item active'] div:nth-child(1) div:nth-child(1) a:nth-child(1)")
    public WebElement bestSellersFirstProductOfList;

    @Description("Çok satanlar listesini görene kadar sayfayı aşağı kaydır.")
    public void scrollDownUntilVisibleBestSellersList() {
        scrollDownUntilElementVisible(bestSellersGenericProductList);
    }

    @Description("Çok satanlar listesindeki ilk ürünün detaylarına git.")
    public void clickToBestSellersFirstProduct() {
        click(bestSellersFirstProductOfList);
    }
}

