package pages;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstProductOfBestDealsListPage extends BasePage {
    public FirstProductOfBestDealsListPage(WebDriver driver) {
        super(driver);
    }

    // ***** Web Elements *****
    @FindBy(css = "[class='product-detail__title-property'] h1")
    public WebElement productName;

    @FindBy(css = "#p-1050019")
    public WebElement addToBasketButton;

    @FindBy(css = "[class='a-btn a-btn--full a-btn--big js-fast-login-btn']")
    public WebElement signInSignUpButton;


    // ***** Methods *****
    @Description("Sepete ekle butonunu görene kadar sayfayı aşağı kaydır.")
    public void scrollDownUntilAddToBasketButtonVisible() {
        scrollDownUntilElementVisible(addToBasketButton);
    }

    @Description("Ürünün adını getir")
    public String getProductName() {
        return getText(productName);
    }

    @Description("Sepete ekle butonuna tıkla.")
    public void clickAddToBasketButton() {
        clickWithJs(addToBasketButton);
    }

    @Description("Giriş Yap butonu tıklanabilir olana kadar bekle.")
    public void waitUntilSignInSignUpButtonClickable() {
        isElementClickable(signInSignUpButton);
    }

    @Description("Giriş Yap butonuna tıkla.")
    public void clickSignInSignUpButton() {
        click(signInSignUpButton);
    }

}
