package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import base.PageGenerator;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    public PageGenerator page;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/evrenak/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(this.driver, 15);
        driver.manage().window().maximize();

        page = new PageGenerator(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
