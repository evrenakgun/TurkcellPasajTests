package pages;

import base.BasePage;
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
    @Step("Scroll down until 'add to basket' button visible Step...")
    public void scrollDownUntilAddToBasketButtonVisible() {
        scrollDownUntilElementVisible(addToBasketButton);
    }

    @Description("Ürünün adını getir")
    @Step("Get product name Step...")
    public String getProductName() {
        return getText(productName);
    }

    @Description("Sepete ekle butonuna tıkla.")
    @Step("Click 'add to basket' button Step...")
    public void clickAddToBasketButton() {
        clickWithJs(addToBasketButton);
    }

    @Description("Giriş Yap butonu tıklanabilir olana kadar bekle.")
    @Step("Wait until 'SignIn/SignUp' button is clickable Step...")
    public void waitUntilSignInSignUpButtonClickable() {
        isElementClickable(signInSignUpButton);
    }

    @Description("Giriş Yap butonuna tıkla.")
    @Step("Click 'SignIn/SignUp' button Step...")
    public void clickSignInSignUpButton() {
        click(signInSignUpButton);
    }

}
