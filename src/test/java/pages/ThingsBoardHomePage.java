package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ThingsBoardHomePage extends BasePage{

    @FindBy(xpath = "//img[@class='tb-logo-title']")
    private WebElement thingsBoardLogo;

    @FindBy(xpath = "(//span[contains(text(),'Домашня сторінка')])[1]")
    private WebElement homePageHeader;

    @FindBy(xpath = "//span[contains(text(), 'Адміністратор власника')]")
    private WebElement userRole;

    @FindBy(xpath = "//li[@class='ng-star-inserted']")
    private List<WebElement> leftBarIcons;

    public ThingsBoardHomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean getLogoThingsBoard(){
        return thingsBoardLogo.isDisplayed();
    }

    public WebElement getLogoFromHeader(){
        return homePageHeader;
    }

    public WebElement getUserRole(){
        return userRole;
    }

    public int getLeftBarIcons(){
        return leftBarIcons.size();
    }
}
