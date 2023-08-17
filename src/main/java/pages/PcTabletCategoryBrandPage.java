package pages;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class PcTabletCategoryBrandPage extends BasePage {
    public PcTabletCategoryBrandPage(WebDriver driver) {
        super(driver);
    }

    // ***** Web Elements *****
    @Description("Filtreleme sonucu sayfada yüklenen ürünlerin sınıfı")
    @FindBy(css = "[class='m-grid-col-4 product'] [class='m-p-pc__title']")
    public WebElement productNames;


    // ***** Methods *****
    @Description("Sayfadaki ürünlerin açılmasını bekle.")
    public void waitUntilProductsVisible() {
        isElementVisible(productNames);
    }

    @Description("Ürün adlarını içeren web elementleri listeye at.")
    public List<String> getWebElementListAsString() {
        List<WebElement> productNamesWebElementList = driver.findElements(By.cssSelector("[class='m-grid-col-4 product'] [class='m-p-pc__title']"));
        List<String> productNamesStringList = new ArrayList<>();

        for (int i = 0; i < productNamesWebElementList.size(); i++) {
            productNamesStringList.add(productNamesWebElementList.get(i).getText());
        }

        return productNamesStringList;
    }

    @Description("Filtreleme sonucu gelen ürünlerin isimlerini kontrol et.")
    public void verifyProductNamesAfterFilter(String name) {
        List<String> namesAfterFilter = getWebElementListAsString();

        for (int i = 0; i < getWebElementListAsString().size(); i++) {
            namesAfterFilter.add(getWebElementListAsString().get(i));
            isTextsContains(namesAfterFilter.get(i).replaceAll(" ", ""), name);
        }
    }

    @Description("Filtreleme sonucu gelen ürün sayısını getir.")
    public void verifyQuantityOfProductsAfterFilter(String quantity) {
        List<String> quantityOfProductAfterFilter = getWebElementListAsString();

        isTextsEquals(String.valueOf(quantityOfProductAfterFilter.size()), quantity);
    }

}
