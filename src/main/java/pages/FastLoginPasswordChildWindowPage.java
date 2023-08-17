package pages;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FastLoginPasswordChildWindowPage extends BasePage {
    public FastLoginPasswordChildWindowPage(WebDriver driver) {
        super(driver);
    }

    // ***** Web Elements *****
    @Description("Password text field")
    @FindBy(css = "input#password")
    public WebElement passwordTextField;

    @Description("Tamam butonu")
    @FindBy(css = "button#password-login-forward-button")
    public WebElement forwardButton;


    // ***** Methods *****
    @Description("Şifre alanı tıklanabilir olana kadar bekle.")
    public void waitUntilPasswordTextFieldClickable() {
        isElementClickable(passwordTextField);
    }

    @Description("Şifreyi yaz.")
    public void setPasswordTextField(String password) {
        setText(passwordTextField, password);
    }

    @Description("Tamam butonuna tıkla.")
    public void clickForwardButton() {
        clickWithJs(forwardButton);
    }
}
