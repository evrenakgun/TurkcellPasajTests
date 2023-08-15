package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageGenerator {
    public WebDriver driver;
    public WebDriverWait wait;

    public PageGenerator(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public <TPage extends BasePage> TPage GetInstance (Class<TPage> pageClass) {
        try {
            return PageFactory.initElements(driver, pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
