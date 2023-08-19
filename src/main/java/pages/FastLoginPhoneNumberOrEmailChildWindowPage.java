package pages;

import base.BasePage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FastLoginPhoneNumberOrEmailChildWindowPage extends BasePage {
    public FastLoginPhoneNumberOrEmailChildWindowPage(WebDriver driver) {
        super(driver);
    }

    // ***** Web Elements *****
    @FindBy(css = "input#phoneNo")
    public WebElement phoneNumberTextField;

    @FindBy(css = "[class='tab__content js-gsm-tab tab__content--active'] [for='loginWithPassword']")
    public WebElement loginWithFastLoginPasswordCheckBox;

    @FindBy(css = "button#webLogin-button")
    public WebElement loginButton;


    // ***** Methods *****
    @Description("Login Step: Telefon numarasını yaz.")
    @Step("Login Step: Enter PhoneNumber: {0}, for method: {method} Step...")
    public void setPhoneNumberTextField(String phoneNumber) {
        setText(phoneNumberTextField, phoneNumber);
    }

    @Description("Login Step: HızlıGiriş Şifresi ile Gir seçeneğini işaretle.")
    @Step("Login Step: Tick the Login with FastLogin password Step...")
    public void tickLoginWithFastLoginPasswordCheckBox() {
        clickWithJs(loginWithFastLoginPasswordCheckBox);
    }

    @Description("Giriş Yap butonuna tıkla.")
    @Step("Login Step: Click login button Step...")
    public void clickLoginButton() {
        clickWithJs(loginButton);
    }

}
