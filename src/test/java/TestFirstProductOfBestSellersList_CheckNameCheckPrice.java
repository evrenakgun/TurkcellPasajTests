import org.testng.annotations.Test;
import pages.*;

public class TestFirstProductOfBestSellersList_CheckNameCheckPrice extends BaseTest{
    HomePage homePage;

    @Test
    public void testBestSellersFirstProduct_CheckNameCheckPrice() {
        page.GetInstance(BasePage.class).goToTurkcellPasaj();
        //page.GetInstance(HomePage.class).scrollDownUntilElementVisible(Buraya element göndermem lazım);
        page.GetInstance(HomePage.class).clickToBestSellersFirstProduct();

    }
}
