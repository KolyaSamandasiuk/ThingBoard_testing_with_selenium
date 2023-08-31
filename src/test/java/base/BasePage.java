package base;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static base.DriverManager.getDriver;

@Slf4j
public abstract class BasePage {

    protected Actions actions;
    protected WebDriverWait wait;
    public static final long WAIT_TIMEOUT = TimeUnit.SECONDS.toMillis(10);

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
        actions = new Actions(getDriver());
        wait = new WebDriverWait(getDriver(), Duration.ofMillis(WAIT_TIMEOUT));
    }

    public void waitUntilElementToBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            log.error("Element was not clickable: " + e.getMessage());
        }
    }

    protected void moveCursor(WebElement element) {
        actions.moveToElement(element).build().perform();
    }
}
