package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PcTabletCategoryBrandPage extends BasePage {
    public PcTabletCategoryBrandPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class='m-grid-col-4 product'] [class='m-p-pc__title']")
    public WebElement productNames;


    public int quantityOfProducts() {
        return 0;
    }
}
