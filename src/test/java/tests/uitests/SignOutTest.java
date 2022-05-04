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

public class SignOutTest extends BaseTest{
    private static final Logger logger = LogManager.getLogger(LoginTest.class.getName());

    // @Test(retryAnalyzer = Retry.class, priority = 1)
    @Test
    @Description("Sign out from account")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://app.qase.io/*")
    public void signOutTest() {
        logger.info("Start CreateAPIKeyTest");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.openPage().makeLogin().getUserMenu().signOut().isSignOut(), WebUrls.QASEIO_LOGIN_URL, "SignOut not complete");
        logger.info("SignOutTest successful complete");
    }
}
