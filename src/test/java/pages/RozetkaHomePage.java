package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaHomePage extends BasePage{

    @FindBy(xpath = "(//a[contains(text(), 'Смартфони, ТВ і електроніка')]//parent::li)[3]")
    private WebElement smartphonesTVandElectronicsBtn;

    public RozetkaHomePage(){
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public RozetkaSmartphonesTVAndElectronicsPage clickSmartphonesTVandElectronicsBtn(){
        waitUntilElementToBeClickable(smartphonesTVandElectronicsBtn);
        smartphonesTVandElectronicsBtn.click();
        return new RozetkaSmartphonesTVAndElectronicsPage();
    }
}
