import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.PageGenerator;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    PageGenerator page;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
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
