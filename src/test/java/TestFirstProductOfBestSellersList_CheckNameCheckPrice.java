import org.testng.annotations.Test;
import pages.*;

import java.util.HashMap;
import java.util.Map;

public class TestFirstProductOfBestSellersList_CheckNameCheckPrice extends BaseTest {

    Map<String, String> productInMemory = new HashMap<>();

    @Test
    public void testBestSellersFirstProduct_CheckNameCheckPrice() {
        page.GetInstance(BasePage.class).goToTurkcellPasaj();
        page.GetInstance(HomePage.class).scrollDownUntilVisibleBestSellersFirstProductName();

        // String productNameInMemory = page.GetInstance(HomePage.class).getBestSellersFirstProductName();
        // String productPriceInMemory = page.GetInstance(HomePage.class).getBestSellersFirstProductPrice();

        productInMemory.put("productName", page.GetInstance(HomePage.class).getBestSellersFirstProductName());
        productInMemory.put("productPrice", page.GetInstance(HomePage.class).getBestSellersFirstProductPrice());

        page.GetInstance(HomePage.class).clickToBestSellersFirstProduct();
        page.GetInstance(FirstProductOfBestSellersListPage.class).verifyBestSellersProductName(productInMemory.get("productName"));
        page.GetInstance(FirstProductOfBestSellersListPage.class).scrollDownUntilProductPriceVisible();
        page.GetInstance(FirstProductOfBestSellersListPage.class).verifyBestSellersProductPrice(productInMemory.get("productPrice"));
    }
}
