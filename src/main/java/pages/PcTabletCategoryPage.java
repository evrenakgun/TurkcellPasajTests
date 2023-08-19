package pages;

import base.BasePage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PcTabletCategoryPage extends BasePage {
    public PcTabletCategoryPage(WebDriver driver) {
        super(driver);
    }

    // ***** Web Elements *****
    @FindBy(css = "[class='m-accordion__container m-accordion--scrolled'][data-type='brand']")
    public WebElement brandContainer;

    @FindBy(css = "[data-type='brand'] [class='filter-search']")
    public WebElement searchBox;

    @FindBy(css = "[class='m-accordion__container m-accordion--scrolled'][data-type='brand'] [class='item a-checkbox show-item'] span")
    public WebElement brandNameAndQuantity;


    // ***** Methods *****
    @Description("Marka konteynırını görene kadar sayfayı aşağı kaydır.")
    @Step("Scroll down until brand container is visible Step...")
    public void scrollDownUntilBrandContainerVisible() {
        scrollDownUntilElementVisible(brandContainer);
    }

    @Description("Arama kutusuna marka yaz.")
    @Step("Write brand name in search box Step...")
    public void setBrand(String text) {
        setText(searchBox, text);
    }

    @Description("Markanın adını getir.")
    @Step("Get brand name Step...")
    public String getBrandName() {
        return getText(brandNameAndQuantity).replaceAll("\\s*\\(\\d+\\)", "");
    }

    @Description("Markanın ürün sayısını getir.")
    @Step("Get product quantity of brand Step...")
    public String getBrandQuantity() {
        return getText(brandNameAndQuantity).replaceAll(".*\\((\\d+)\\).*", "$1");
    }

    @Description("Marka filtresini seç.")
    @Step("Choose brand filter Step...")
    public void clickToBrand() {
        clickWithJs(brandNameAndQuantity);
    }

}
