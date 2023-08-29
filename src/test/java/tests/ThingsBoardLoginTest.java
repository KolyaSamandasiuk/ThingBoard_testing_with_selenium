package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ThingsBoardHomePage;
import pages.ThingsBoardLoginPage;

import static constants.Const.*;

public class ThingsBoardLoginTest extends BaseTest{

    @Test
    public void checkLogin() {

        ThingsBoardLoginPage thingsBoardLoginPage = new ThingsBoardLoginPage();
        ThingsBoardHomePage thingsBoardHomePage = new ThingsBoardHomePage();

        thingsBoardLoginPage
                .inputEmailForLogin(EMAIL)
                .inputPasswordForLogin(PASSWORD)
                .clickOnSubmitBtn();

        Assert.assertTrue(thingsBoardHomePage.getLogoThingsBoard(), "ThingsBoard logo is not displayed!!!");
        Assert.assertEquals(thingsBoardHomePage.getLogoFromHeader().getText(), "Домашня сторінка");
        Assert.assertEquals(thingsBoardHomePage.getUserRole().getText(), "Адміністратор власника");
        Assert.assertTrue(thingsBoardHomePage.getLeftBarIcons() <= 26);
    }
}
