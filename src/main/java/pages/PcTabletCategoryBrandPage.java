package pages;

import base.BasePage;
import io.qameta.allure.*;
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
    private By paginationList = By.cssSelector("[class='m-p-pagination__container'] li");
    private By productsNameList = By.cssSelector("[class='m-grid-col-4 product'] [class='m-p-pc__title']");

    @FindBy(css = "[class='m-grid-col-4 product'] [class='m-p-pc__title']")
    public WebElement productNames;

    // ***** Methods *****
    @Description("Sayfadaki ürünlerin yüklenmesini bekle.")
    @Step("Wait until all products are visible Step...")
    public void waitUntilProductsVisible() {
        isElementVisible(productNames);
    }

    @Description("Ürün adlarını içeren web elementleri listeye at.")
    @Step("Add product web elements to a list Step...")
    public List<String> getWebElementListAsString() {
        // Kaç sayfa olduğunu web elementle belirledik, bunları liste içine atacağız. Sayfalar içindeki ürünleri sayacağız.
        List<WebElement> productNamesWebElementList = driver.findElements(productsNameList);
        List<String> productNamesStringList = new ArrayList<>();

        for (int i = 0; i < productNamesWebElementList.size(); i++) {
            productNamesStringList.add(productNamesWebElementList.get(i).getText());
        }

        return productNamesStringList;
    }

    @Description("Filtreleme sonucu gelen ürünlerin isimlerini kontrol et.")
    @Step("Verify product names after filter on Step...")
    public void verifyProductNamesAfterFilter(String name) {
        List<String> namesAfterFilter = getWebElementListAsString();

        for (int i = 0; i < getWebElementListAsString().size(); i++) {
            isTextsContains(namesAfterFilter.get(i).replaceAll(" ", ""), name);
        }
    }

    @Description("Filtreleme sonucu gelen ürün sayısını getir.")
    @Step("Verify product quantity after filter on Step...")
    public void verifyQuantityOfProductsAfterFilter(String quantity) {
        List<WebElement> pageNumbersWebElementList = driver.findElements(paginationList);
        List<String> quantityOfProductAfterFilter = getWebElementListAsString();

        int quantityInMemory = Integer.parseInt(quantity);
        int currentPage = 1;
        int lastPage = pageNumbersWebElementList.size();
        int productsPerPage = quantityOfProductAfterFilter.size();

        if (pageNumbersWebElementList.isEmpty()) {
            isTextsEquals(String.valueOf(quantityOfProductAfterFilter.size()), quantity);
        } else {
            int subTotal = ((lastPage - currentPage) * productsPerPage);
            int productQuantityOnLastPage = quantityInMemory - subTotal;
            int totalProductQuantity = productQuantityOnLastPage + subTotal;

            isTextsEquals(String.valueOf(totalProductQuantity), quantity);
        }

    }

}
