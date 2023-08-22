package filtreleme;

import base.BasePage;
import base.BaseTest;
import base.TextExecutionListener;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.util.HashMap;
import java.util.Map;

import static util.BrandFilterConstants.BRAND_NAME;

@Listeners(TextExecutionListener.class)
@Epic("Mini Regression Tests")
@Feature("Filter Test")
public class TC003_TestPcTabletCategory_RandomFilterSelection extends BaseTest {

    Map<String, String> brandInMemory = new HashMap<>();

    @Test(priority = 0, description = "Check product names and quantity after filter.")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Filter test.")
    @Story("Go to Pc-Tablet category select a brand then verify product names and quantity")
    public void testPcTabletCategory_RandomFilterSelection() {
        page.GetInstance(BasePage.class).goToTurkcellPasaj();
        page.GetInstance(HomePage.class).clickToPcTabletCategory();
        page.GetInstance(PcTabletCategoryPage.class).scrollDownUntilBrandContainerVisible();
        page.GetInstance(PcTabletCategoryPage.class).setBrand(BRAND_NAME);

        brandInMemory.put("brandName", page.GetInstance(PcTabletCategoryPage.class).getBrandName());
        brandInMemory.put("brandQuantity", page.GetInstance(PcTabletCategoryPage.class).getBrandQuantity());

        page.GetInstance(PcTabletCategoryPage.class).clickToBrand();
        page.GetInstance(PcTabletCategoryBrandPage.class).waitUntilProductsVisible();
        page.GetInstance(PcTabletCategoryBrandPage.class).getWebElementListAsString();
        page.GetInstance(PcTabletCategoryBrandPage.class).verifyProductNamesAfterFilter(brandInMemory.get("brandName").replaceAll(" ", ""));
        page.GetInstance(PcTabletCategoryBrandPage.class).verifyQuantityOfProductsAfterFilter(brandInMemory.get("brandQuantity"));

    }

}
