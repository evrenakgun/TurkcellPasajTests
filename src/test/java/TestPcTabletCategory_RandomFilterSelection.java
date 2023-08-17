import org.testng.annotations.Test;
import pages.*;

import java.util.HashMap;
import java.util.Map;

import static util.Constants.*;

public class TestPcTabletCategory_RandomFilterSelection extends BaseTest {

    Map<String, String> brandInMemory = new HashMap<>();

    @Test
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
        page.GetInstance(PcTabletCategoryBrandPage.class).verifyProductNamesAfterFilter(brandInMemory.get("brandName"));
        page.GetInstance(PcTabletCategoryBrandPage.class).verifyQuantityOfProductsAfterFilter(brandInMemory.get("brandQuantity"));

    }

}
