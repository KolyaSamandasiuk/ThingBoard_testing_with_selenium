package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaSmartphonesTVAndElectronicsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'Apple iPhone')]")
    private WebElement appleIphoneBtn;

    public RozetkaSmartphonesTVAndElectronicsPage() {
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public RozetkaAppleIphonePage clickOnAppleIphoneBtn() {
        waitUntilElementToBeClickable(appleIphoneBtn);
        appleIphoneBtn.click();
        return new RozetkaAppleIphonePage();
    }
}
