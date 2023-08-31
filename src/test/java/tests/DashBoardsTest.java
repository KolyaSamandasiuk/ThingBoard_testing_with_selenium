package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ThingsBoardDashBoardsPage;
import pages.ThingsBoardHomePage;
import pages.ThingsBoardLoginPage;

import static constants.Const.*;

public class DashBoardsTest extends BaseTest {

    @Test
    public void checkDashBoards(){
        ThingsBoardLoginPage thingsBoardLoginPage = new ThingsBoardLoginPage();
        ThingsBoardHomePage thingsBoardHomePage = new ThingsBoardHomePage();
        ThingsBoardDashBoardsPage thingsBoardDashBoardsPage = new ThingsBoardDashBoardsPage();

        thingsBoardLoginPage.loginToAccount(EMAIL, PASSWORD);

        thingsBoardHomePage.getSidePanel().clickDashBoardsBtn();

        thingsBoardDashBoardsPage
                .clickCheckboxByIndex(3)
                .clickCheckboxByIndex(6)
                .clickOnAssignmentIndBtn()
                .clickOnPresentationField()
                .clickOnCastomerA()
                .clickOnSubmitBtn();

        Assert.assertTrue(thingsBoardDashBoardsPage.getAssignedCustomer(1).isDisplayed());
        Assert.assertTrue(thingsBoardDashBoardsPage.getAssignedCustomer(2).isDisplayed());
        Assert.assertTrue(thingsBoardDashBoardsPage.getAssignedCustomer(3).isDisplayed());
        Assert.assertTrue(thingsBoardDashBoardsPage.getAssignedCustomer(4).isDisplayed());
    }
}
