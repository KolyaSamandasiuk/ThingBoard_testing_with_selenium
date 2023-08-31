package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ThingsBoardDashBoardsPage extends BasePage{

    @FindBy(xpath = "//input[@type='checkbox']")
    private List <WebElement> checkBoxes;

    @FindBy(xpath = "(//mat-icon[contains(text(), 'assignment_ind')]//parent::button)[1]")
    private WebElement assignmentInd;

    @FindBy(xpath = "//div[@role='presentation']")
    private WebElement presentatiomField;

    @FindBy(xpath = "//div[@role='listbox']//mat-option//span[contains(text(), 'Customer A')]")
    private WebElement customerA;

    @FindBy(xpath = "//span[contains(text(), 'Надати')]//parent::button")
    private WebElement submitBtn;

    @FindBy(xpath = "//input[@placeholder='Список сутності']")
    private WebElement entityListField;

    public ThingsBoardDashBoardsPage() {
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public ThingsBoardDashBoardsPage clickCheckboxByIndex(int index) {
        if (index >= 0 && index < 12) {
            WebElement checkbox = checkBoxes.get(index);
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        } else {
            System.out.println("Invalid checkbox index.");
        }
        return new ThingsBoardDashBoardsPage();
    }

    public ThingsBoardDashBoardsPage clickOnAssignmentIndBtn(){
        moveCursor(assignmentInd);
        assignmentInd.click();
        return new ThingsBoardDashBoardsPage();
    }

    public ThingsBoardDashBoardsPage clickOnPresentationField(){
        moveCursor(presentatiomField);
        presentatiomField.click();
        return new ThingsBoardDashBoardsPage();
    }

    public ThingsBoardDashBoardsPage clickOnCastomerA(){
        moveCursor(customerA);
        customerA.click();
        return new ThingsBoardDashBoardsPage();
    }

    public ThingsBoardDashBoardsPage clickOnSubmitBtn(){
        waitUntilElementToBeClickable(entityListField);
        entityListField.click();
        entityListField.sendKeys(Keys.ESCAPE);
        moveCursor(submitBtn);
        submitBtn.click();
        return new ThingsBoardDashBoardsPage();
    }

    public WebElement getAssignedCustomer(int numberOfField) {
        WebElement field = driver.findElement(By.xpath("(//span[contains(text(),'Customer A')])[" + numberOfField + "]"));
        return field;
    }
}
