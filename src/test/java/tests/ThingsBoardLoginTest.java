package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ThingsBoardHomePage;
import pages.ThingsBoardLoginPage;

import static constants.Const.*;

public class ThingsBoardLoginTest extends BaseTest {

    @Test
    public void checkLogin() {

        ThingsBoardLoginPage thingsBoardLoginPage = new ThingsBoardLoginPage();
        ThingsBoardHomePage thingsBoardHomePage = new ThingsBoardHomePage();

        thingsBoardLoginPage
                .inputEmailForLogin(EMAIL)
                .inputPasswordForLogin(PASSWORD)
                .clickOnSubmitBtn();

        Assert.assertTrue(thingsBoardHomePage.getSidePanel().getThingsBoardLogo(), "ThingsBoard logo is not displayed!!!");
        Assert.assertEquals(thingsBoardHomePage.getSidePanel().getHomePageHeader().getText(), "Домашня сторінка");
        Assert.assertEquals(thingsBoardHomePage.getSidePanel().getUserRole().getText(), "Адміністратор власника");
        Assert.assertTrue(thingsBoardHomePage.getSidePanel().getLeftBarIcons().size() <= 26); //try use assertJ
    }
}
