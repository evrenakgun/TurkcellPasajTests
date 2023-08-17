package pages;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FastLoginPhoneNumberOrEmailChildWindowPage extends BasePage {
    public FastLoginPhoneNumberOrEmailChildWindowPage(WebDriver driver) {
        super(driver);
    }

    // ***** Web Elements *****
    @Description("Telefon numarası text field")
    @FindBy(css = "input#phoneNo")
    public WebElement phoneNumberTextField;

    @Description("HızlıGiriş Şifresi ile Gir checkbox")
    @FindBy(css = "[class='tab__content js-gsm-tab tab__content--active'] [for='loginWithPassword']")
    public WebElement loginWithFastLoginPasswordCheckBox;

    @Description("Login butonu")
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
