import pages.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static util.Constants.*;

public class TestPcTabletCategory_RandomFilterSelection extends BaseTest {

    Map<String, String> brandInMemory = new HashMap<>();


    public void testPcTabletCategory_RandomFilterSelection() {
        page.GetInstance(BasePage.class).goToTurkcellPasaj();
        page.GetInstance(HomePage.class).clickToPcTabletCategory();
        page.GetInstance(PcTabletCategoryPage.class).scrollDownUntilBrandContainerVisible();
        page.GetInstance(PcTabletCategoryPage.class).setBrand(BRAND_NAME);

        brandInMemory.put("brandName", page.GetInstance(PcTabletCategoryPage.class).getBrandName());
        brandInMemory.put("brandQuantity", page.GetInstance(PcTabletCategoryPage.class).getBrandQuantity());

        page.GetInstance(PcTabletCategoryPage.class).clickToBrand();

    }

}
