package tests.uitests;

import driver.DriverFactory;
import driver.DriverManager;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.TestListeners;

import java.net.MalformedURLException;

@Listeners(TestListeners.class)
public class BaseTest {
    WebDriver driver;
    DriverManager driverManager;
    DriverType driverType;

    @BeforeSuite
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        DriverFactory factory = new DriverFactory();
        switch (browser) {
            case "chrome":
                driverType = DriverType.CHROME;
                break;
            case "firefox":
                driverType = DriverType.MOZILLA;
                break;
            case "edge":
                driverType = DriverType.EDGE;
                break;
            case "remote":
                driverType = DriverType.REMOTE;
                break;
            default: driverType = null;
        }
        driverManager = factory.getManager(driverType);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.maximize();
        driverManager.setTimeout();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
