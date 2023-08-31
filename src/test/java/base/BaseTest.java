package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    @BeforeSuite
    public void initializeDriver() throws Exception {
        String browserTypeStr = System.getProperty("browserType");
        if (browserTypeStr == null) {
            browserTypeStr = "CHROME";
        }
        BrowserType browserType = BrowserType.fromString(browserTypeStr);
        WebDriver driver;
        switch (browserType) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            default -> throw new Exception("You chose an invalid browser!");
        }

        driver.get("https://demo.thingsboard.io/login");
        driver.manage().window().maximize();
        /*
        try use default window size like "driver.manage().window().setSize(new Dimension(1680, 1050));"
        cause using "driver.manage().window().maximize();" may result in flaky tests
        */
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        DriverManager.setDriver(driver);
    }

    @AfterSuite
    public void closeBrowser() {
        DriverManager.quitDriver();
    }
}
