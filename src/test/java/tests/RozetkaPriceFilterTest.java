package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RozetkaAppleIphonePage;
import pages.RozetkaHomePage;

public class RozetkaPriceFilterTest extends BaseTest {

    @Test
    public void checkPriceFilter() {
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage();
        RozetkaAppleIphonePage rozetkaAppleIphonePage = new RozetkaAppleIphonePage();

        rozetkaHomePage
                .clickSmartphonesTVandElectronicsBtn()
                .clickOnAppleIphoneBtn()
                .chooseXiaomiForFilter()
                .enterMaxPriceForFilterAndSubmit();

        Assert.assertTrue(rozetkaAppleIphonePage.getPriceFromCards("33 499"));
        //Assert.assertTrue(rozetkaAppleIphonePage.getPriceFromCards("35 001"));
    }
}
