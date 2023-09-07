package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RozetkaAppleIphonePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), 'Xiaomi')]")
    private WebElement xiaomiCheckBoxField;

    @Getter
    @FindBy(xpath = "//a[@class='goods-tile__heading ng-star-inserted']")
    private List<WebElement> resultSmartphonesNames;

    @FindBy(xpath = "//div[@class='slider-filter__inner']/input[2]")
    private WebElement maxPriceForFilter;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//span[@class='goods-tile__price-value']")
    private List<WebElement> resultPrice;

    public RozetkaAppleIphonePage() {
        PageFactory.initElements(driver, this);
    }

    public RozetkaAppleIphonePage chooseXiaomiForFilter() {
        waitUntilElementToBeClickable(xiaomiCheckBoxField);
        xiaomiCheckBoxField.click();
        return this;
    }

    public boolean getTextFromCards(String firstNameForSearch, String secondNameForSearch) {
        for (WebElement element : resultSmartphonesNames) {
            if (element.getText().contains(firstNameForSearch) || element.getText().contains(secondNameForSearch)) {
                return true;
            }
        }
        return false;
    }

    public RozetkaAppleIphonePage enterMaxPriceForFilterAndSubmit() {
        waitUntilElementToBeClickable(maxPriceForFilter);
        maxPriceForFilter.clear();
        maxPriceForFilter.sendKeys("35000");
        submitBtn.click();
        return this;
    }

    public boolean getPriceFromCards(String price) {
        for (WebElement element : resultPrice) {
            if (element.getText().contains(price)) {
                return true;
            }
        }
        return false;
    }
}
