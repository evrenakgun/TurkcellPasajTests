package pages;

import base.BasePage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FastLoginPasswordChildWindowPage extends BasePage {
    public FastLoginPasswordChildWindowPage(WebDriver driver) {
        super(driver);
    }

    // ***** Web Elements *****
    @FindBy(css = "input#password")
    public WebElement passwordTextField;

    @FindBy(css = "button#password-login-forward-button")
    public WebElement forwardButton;


    // ***** Methods *****
    @Description("Şifre alanı tıklanabilir olana kadar bekle.")
    @Step("Wait until PasswordTextField clickable Step...")
    public void waitUntilPasswordTextFieldClickable() {
        isElementClickable(passwordTextField);
    }

    @Description("Şifreyi yaz.")
    @Step("Login Step: Enter password: {0}, for method: {method} Step...")
    public void setPasswordTextField(String password) {
        setText(passwordTextField, password);
    }

    @Description("Tamam butonuna tıkla.")
    @Step("Login Step: click OK button Step...")
    public void clickForwardButton() {
        clickWithJs(forwardButton);
    }
}
