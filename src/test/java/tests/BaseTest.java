package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;

    private static final String BROWSER_NAME = "chrome";

    @BeforeMethod
    public void setUp() throws Exception {
        switch (BROWSER_NAME) {
            case ("chrome") -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case ("firefox") -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            default -> throw new Exception("You chose not valid browser!");
        }
        driver.get("https://rozetka.com.ua");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        BasePage.setDriver(driver);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
