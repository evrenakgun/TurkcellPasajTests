package pages;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static util.Constants.BRAND_NAME;

public class PcTabletCategoryPage extends BasePage {
    public PcTabletCategoryPage(WebDriver driver) {
        super(driver);
    }

    // ***** Web Elements *****
    @Description("Marka konteynırı")
    @FindBy(css = "[class='m-accordion__container m-accordion--scrolled'][data-type='brand']")
    public WebElement brandContainer;

    @Description("Arama kutusu")
    @FindBy(css = "[data-type='brand'] [class='filter-search']")
    public WebElement searchBox;

    @Description("Arama yapılan markanın adı")
    @FindBy(css = "[class='m-accordion__container m-accordion--scrolled'] [data-val='" + BRAND_NAME + "']")
    public WebElement brandName;

    @Description("Arama yapılan markanın ürün sayısı")
    @FindBy(css = "[class='m-accordion__container m-accordion--scrolled'] [data-val='" + BRAND_NAME + "'] label[class='count']")
    public WebElement brandQuantity;


    // ***** Methods *****
    @Description("Marka konteynırını görene kadar sayfayı aşağı kaydır.")
    public void scrollDownUntilBrandContainerVisible() {
        scrollDownUntilElementVisible(brandContainer);
    }

    @Description("Arama kutusuna marka yaz.")
    public void setBrand(String text) {
        setText(searchBox, text);
    }

    @Description("Markanın adını getir.")
    public String getBrandName() {
        return getText(brandName);
    }

    @Description("Markanın ürün sayısını getir.")
    public String getBrandQuantity() {
        return getText(brandQuantity);
    }

    @Description("Marka filtresini seç.")
    public void clickToBrand() {
        clickWithJs(brandName);
    }

}
