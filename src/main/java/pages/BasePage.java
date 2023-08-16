package pages;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage extends PageGenerator {

    public BasePage(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait = new WebDriverWait(this.driver, 10);

    JavascriptExecutor js = (JavascriptExecutor) driver;

    String baseUrl = "https://www.turkcell.com.tr/pasaj";

    @Description("Turkcell Pasaj ana sayfasına git.")
    public void goToTurkcellPasaj() {
        driver.get(baseUrl);
    }

    @Description("Elemente tıkla.")
    public void click(WebElement elementLocation) {
        elementLocation.click();
    }

    @Description("Elemente js executor ile tıkla.")
    public void clickWithJs(WebElement elementLocation) {
        js.executeScript("arguments[0].click();", elementLocation);
    }

    @Description("Elemente text yolla.")
    public void setText (WebElement elementLocation, String text) {
        elementLocation.sendKeys(text);
    }

    @Description("Elementten text getir.")
    public String getText (WebElement elementLocation) {
        return elementLocation.getText();
    }

    @Description("Elementi görene kadar sayfayı kaydır.")
    public void scrollDownUntilElementVisible(WebElement elementLocation) {
        js.executeScript("arguments [0].scrollIntoView();", elementLocation);
    }

    @Description("Text karşılaştır.(Birbirine eşit mi?)")
    public void isTextsEquals(String productName1, String productName2) {
        Assert.assertEquals(productName1.trim(), productName2.trim());
    }
}
