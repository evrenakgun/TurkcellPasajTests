import base.BasePage;
import base.BaseTest;
import base.TextExecutionListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.util.HashMap;
import java.util.Map;

@Listeners(TextExecutionListener.class)
public class TestFirstProductOfBestSellersList_CheckNameCheckPrice extends BaseTest {

    Map<String, String> productInMemory = new HashMap<>();

    @Test(priority = 0, description = "Check product name and price for first of best sellers list on home page and on product details page.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify product name and price.")
    @Story("Check product name and price on home page and product detail page")
    public void testBestSellersFirstProduct_CheckNameCheckPrice() {
        page.GetInstance(BasePage.class).goToTurkcellPasaj();
        page.GetInstance(HomePage.class).scrollDownUntilVisibleBestSellersFirstProductName();

        productInMemory.put("productName", page.GetInstance(HomePage.class).getBestSellersFirstProductName());
        productInMemory.put("productPrice", page.GetInstance(HomePage.class).getBestSellersFirstProductPrice());

        page.GetInstance(HomePage.class).clickToBestSellersFirstProduct();
        page.GetInstance(FirstProductOfBestSellersListPage.class).verifyBestSellersProductName(productInMemory.get("productName"));
        page.GetInstance(FirstProductOfBestSellersListPage.class).scrollDownUntilProductPriceVisible();
        page.GetInstance(FirstProductOfBestSellersListPage.class).verifyBestSellersProductPrice(productInMemory.get("productPrice"));
    }
}
