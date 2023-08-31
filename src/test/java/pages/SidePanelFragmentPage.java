package pages;

import base.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SidePanelFragmentPage extends BasePage {

    @Getter
    @FindBy(xpath = "//img[@class='tb-logo-title']")
    private WebElement thingsBoardLogo;

    @Getter
    @FindBy(xpath = "(//span[contains(text(),'Домашня сторінка')])[1]")
    private WebElement homePageHeader;

    @Getter
    @FindBy(xpath = "//span[contains(text(), 'Адміністратор власника')]")
    private WebElement userRole;

    @Getter
    @FindBy(xpath = "//li[@class='ng-star-inserted']")
    private List<WebElement> leftBarIcons;

    @FindBy(xpath = "//a[@href='/home']/parent::*/parent::li")
    private WebElement homePageBtn;

    @FindBy(xpath = "//a[@href='/alarms']//parent::*//parent::li")
    private WebElement alarmsBtn;

    @FindBy(xpath = "//a[@href='/dashboards']//parent::*//parent::li")
    private WebElement dashBoardsBtn;

    @FindBy(xpath = "(//span[contains(text(), 'Сутності')])[1]")
    private WebElement entitiesBtn;

    @FindBy(xpath = "//a[@href='/entities/devices']//parent::*//parent::li")
    private WebElement entitiesDevicesBtn;

    public SidePanelFragmentPage() {
        super();
    }

    public boolean getThingsBoardLogo() {
        return thingsBoardLogo.isDisplayed();
    }

    public void clickHomePageBtn() {
        homePageBtn.click();
    }

    public void clickAlarmsBtn() {
        alarmsBtn.click();
    }

    public void clickDashBoardsBtn() {
        dashBoardsBtn.click();
    }

    public void clickEntitiesBtn() {
        entitiesBtn.click();
    }

    public void clickEntitiesDevicesBtn() {
        entitiesDevicesBtn.click();
    }
//    public void clickButtonByHref(String buttonHref) {
//        WebElement button = driver.findElement(By.cssSelector("[href='" + buttonHref + "']"));
//        button.click();
//    }
}
