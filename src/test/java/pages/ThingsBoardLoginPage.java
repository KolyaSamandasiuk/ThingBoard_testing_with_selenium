package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThingsBoardLoginPage extends BasePage {

    @FindBy(xpath = "//div[@class='mat-mdc-form-field-infix ng-tns-c58-0']//input")
    private WebElement emailFieldForLogin;

    @FindBy(xpath = "//input[@id='password-input']")
    private WebElement passwordFieldForLogin;

    @FindBy(xpath = "//div[@class='tb-action-button']//button")
    private WebElement submitBtn;

    public ThingsBoardLoginPage(){
        PageFactory.initElements(driver, this);
    }

    public ThingsBoardLoginPage inputEmailForLogin(String email){
        emailFieldForLogin.sendKeys(email);
        return this;
    }

    public ThingsBoardLoginPage inputPasswordForLogin(String password){
        passwordFieldForLogin.sendKeys(password);
        return this;
    }

    public ThingsBoardHomePage clickOnSubmitBtn(){
        submitBtn.click();
        return new ThingsBoardHomePage();
    }
}
