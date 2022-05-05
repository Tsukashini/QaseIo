package tests.uitests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import staticdata.WebUrls;
import utilities.Retry;


public class LoginTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(LoginTest.class.getName());

    @Test(retryAnalyzer = Retry.class, description = "Users can log in using valid email and password.")
    @Description("Users can log in using valid email and password.")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://app.qase.io/login")
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
