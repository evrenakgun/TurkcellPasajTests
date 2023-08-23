package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    public PageGenerator page;

    @BeforeMethod
    @Step("Open chromedriver Step...")
    public void setUp() {
        // WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:/Users/evrenak/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        page = new PageGenerator(driver);
    }

    @AfterMethod
    @Step("Close chromedriver Step...")
    public void tearDown() {
        driver.quit();
    }
}
