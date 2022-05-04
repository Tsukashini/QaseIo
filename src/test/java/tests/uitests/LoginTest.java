package tests.uitests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import staticdata.WebUrls;
import utilities.Retry;


public class LoginTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(LoginTest.class.getName());

    @Test(retryAnalyzer = Retry.class)
    public void loginTest() {
        logger.info("loginTest started");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        logger.info("Login Page opened");
        loginPage.makeLogin();
        Assert.assertEquals(driver.getCurrentUrl(), WebUrls.QASEIO_PROJECTS_URL, "Login fail");
        logger.info("Login successful");
    }
}
