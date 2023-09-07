package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;
    protected static Actions actions;

    public static void setDriver(WebDriver webDriver){
        driver = webDriver;
    }

    public static void waitUntilElementToBeClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("Element was not clickable: " + e.getMessage());
        }
    }

    protected void moveCursor(WebElement element) {
        actions.moveToElement(element).build().perform();
    }
}
