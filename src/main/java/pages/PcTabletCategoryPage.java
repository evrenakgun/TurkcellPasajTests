package pages;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    @FindBy(css = "[class='m-accordion__container m-accordion--scrolled'][data-type='brand'] [class='item a-checkbox show-item'] span")
    public WebElement brandNameAndQuantity;


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
        return getText(brandNameAndQuantity).replaceAll("\\s*\\(\\d+\\)", "");
    }

    @Description("Markanın ürün sayısını getir.")
    public String getBrandQuantity() {
        return getText(brandNameAndQuantity).replaceAll(".*\\((\\d+)\\).*", "$1");
    }

    @Description("Marka filtresini seç.")
    public void clickToBrand() {
        clickWithJs(brandNameAndQuantity);
    }

}
