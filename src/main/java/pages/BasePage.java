package pages;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends PageGenerator {

    public BasePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

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
}
