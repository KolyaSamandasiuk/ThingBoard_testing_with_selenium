package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RozetkaAppleIphonePage;
import pages.RozetkaHomePage;

public class RozetkaBrandFilterTest extends BaseTest {

    @Test
    public void checkFilter() {
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage();
        RozetkaAppleIphonePage rozetkaAppleIphonePage = new RozetkaAppleIphonePage();

        rozetkaHomePage
                .clickSmartphonesTVandElectronicsBtn()
                .clickOnAppleIphoneBtn()
                .chooseXiaomiForFilter();

        Assert.assertTrue(rozetkaAppleIphonePage.getTextFromCards("Apple", "Xiaomi"));
        Assert.assertTrue(rozetkaAppleIphonePage.getTextFromCards("Мобільний телефон Apple iPhone 13 128GB Midnight (MLPF3HU/A)", "Мобільний телефон Xiaomi Redmi Note 12 8/256GB Onyx Gray (998678)"));
        Assert.assertTrue(rozetkaAppleIphonePage.getResultSmartphonesNames().size() <= 60);
    }
}
