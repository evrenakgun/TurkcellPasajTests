package pages;

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
    @Description("Telefon numarasını yaz.")
    public void setPhoneNumberTextField(String phoneNumber) {
        setText(phoneNumberTextField, phoneNumber);
    }

    @Description("HızlıGiriş Şifresi ile Gir seçeneğini işaretle.")
    public void tickLoginWithFastLoginPasswordCheckBox() {
        clickWithJs(loginWithFastLoginPasswordCheckBox);
    }

    @Description("Giriş Yap butonuna tıkla.")
    public void clickLoginButton() {
        clickWithJs(loginButton);
    }

}
