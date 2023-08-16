import org.testng.annotations.Test;
import pages.*;

public class TestFirstProductOfBestSellersList_CheckNameCheckPrice extends BaseTest{
    HomePage homePage;

    @Test
    public void testBestSellersFirstProduct_CheckNameCheckPrice() {
        page.GetInstance(BasePage.class).goToTurkcellPasaj();
        page.GetInstance(HomePage.class).scrollDownUntilVisibleBestSellersFirstProductName();

        String productNameInMemory = page.GetInstance(HomePage.class).getBestSellersFirstProductName();
        String productPriceInMemory = page.GetInstance(HomePage.class).getBestSellersFirstProductPrice();

        page.GetInstance(HomePage.class).clickToBestSellersFirstProduct();
        page.GetInstance(FirstProductOfBestSellersListPage.class).verifyBestSellersProductName(productNameInMemory);
        page.GetInstance(FirstProductOfBestSellersListPage.class).scrollDownUntilProductPriceVisible();
        page.GetInstance(FirstProductOfBestSellersListPage.class).verifyBestSellersProductPrice(productPriceInMemory);
    }
}
