package base;

import io.qameta.allure.*;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.FastLoginPasswordChildWindowPage;
import pages.FastLoginPhoneNumberOrEmailChildWindowPage;

import java.util.Iterator;
import java.util.Set;

import static util.LoginConstants.FASTLOGIN_PASSWORD;
import static util.LoginConstants.PHONE_NUMBER;

public class BasePage extends PageGenerator {
    PageGenerator page;

    public BasePage(WebDriver driver) {
        super(driver);
        page = new PageGenerator(driver);
    }
    WebDriverWait wait = new WebDriverWait(this.driver, 10);

    JavascriptExecutor js = (JavascriptExecutor) driver;

    String baseUrl = "https://www.turkcell.com.tr/pasaj";

    // Asıl pencereyi bir değişkene atadık.
    public String mainWindow = driver.getWindowHandle();
    // Açık pencerelerinin kimliklerini barındıran bir Set oluşturduk.
    public Set<String> windowHandles = driver.getWindowHandles();
    //Oluşturduğum Set'in içindeki pencerelere erişmesi için bir iterator oluşturduk.
    public Iterator<String> iterator = windowHandles.iterator();
    public String titleFastLogin = "Giriş Yap";


    // ***** Methods *****
    @Description("Turkcell Pasaj ana sayfasına git.")
    @Step("Open TurkcellPasaj Step...")
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
    public void isTextsEquals(String text1, String text2) {
        Assert.assertEquals(text1.trim(), text2.trim());
    }

    @Description("Text karşılaştır.(İçinde geçiyor mu?)")
    public void isTextsContains(String text1, String text2) {
        Assert.assertTrue(StringUtils.containsIgnoreCase(text1, text2));
    }

    @Description("Element tıklanabilir olana kadar bekle.")
    public void isElementClickable(WebElement elementLocation) {
        wait.until(ExpectedConditions.elementToBeClickable(elementLocation));
    }

    @Description("Element görünür olana kadar bekle.")
    public void isElementVisible(WebElement elementLocation) {
        wait.until(ExpectedConditions.visibilityOf(elementLocation));
    }

    @Description("HızlıGiriş ile giriş yap.")
    @Step("Login Step...")
    public void switchToFastLoginWindow_LoginProcess() throws InterruptedException {
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            driver.switchTo().window(childWindow);
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                page.GetInstance(FastLoginPhoneNumberOrEmailChildWindowPage.class).setPhoneNumberTextField(PHONE_NUMBER);
                page.GetInstance(FastLoginPhoneNumberOrEmailChildWindowPage.class).tickLoginWithFastLoginPasswordCheckBox();
                page.GetInstance(FastLoginPhoneNumberOrEmailChildWindowPage.class).clickLoginButton();

                page.GetInstance(FastLoginPasswordChildWindowPage.class).waitUntilPasswordTextFieldClickable();
                page.GetInstance(FastLoginPasswordChildWindowPage.class).setPasswordTextField(FASTLOGIN_PASSWORD);
                page.GetInstance(FastLoginPasswordChildWindowPage.class).clickForwardButton();
            }
        }
        driver.switchTo().window(mainWindow);
    }

}
