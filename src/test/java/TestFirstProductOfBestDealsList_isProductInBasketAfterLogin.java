import base.BasePage;
import base.BaseTest;
import base.TextExecutionListener;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.util.HashMap;
import java.util.Map;

@Listeners(TextExecutionListener.class)
@Epic("E2E Tests")
@Feature("Add to Basket Test")
public class TestFirstProductOfBestDealsList_isProductInBasketAfterLogin extends BaseTest {

    Map<String, String> productInMemory = new HashMap<>();

    @Test(priority = 0, description = "Add to basket first product of best deals list then login and check basket for product is in the basket.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Add to basket test.")
    @Story("Check basket after add to basket process with login test")
    public void testFirstProductOfBestDeals_isProductInBasketAfterLogin() throws InterruptedException {
        page.GetInstance(BasePage.class).goToTurkcellPasaj();

        page.GetInstance(HomePage.class).scrollDownUntilVisibleBestDealsFirstProductName();
        page.GetInstance(HomePage.class).clickToBestDealsFirstProduct();

        productInMemory.put("productName", page.GetInstance(FirstProductOfBestDealsListPage.class).getProductName());

        page.GetInstance(FirstProductOfBestDealsListPage.class).scrollDownUntilAddToBasketButtonVisible();
        page.GetInstance(FirstProductOfBestDealsListPage.class).clickAddToBasketButton();
        page.GetInstance(FirstProductOfBestDealsListPage.class).waitUntilSignInSignUpButtonClickable();
        page.GetInstance(FirstProductOfBestDealsListPage.class).clickSignInSignUpButton();

        page.GetInstance(FirstProductOfBestDealsListPage.class).switchToFastLoginWindow_LoginProcess();

        page.GetInstance(MyBasketPage.class).waitUntilMyBasketPageVisible();
        page.GetInstance(MyBasketPage.class).isCurrentPageBasketPage();
        page.GetInstance(MyBasketPage.class).verifyProductNameInBasket(productInMemory.get("productName"));
        page.GetInstance(MyBasketPage.class).verifyProductQuantityInBasket();

    }
}
