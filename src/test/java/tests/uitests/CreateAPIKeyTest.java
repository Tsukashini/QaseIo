package tests.uitests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.APITokensPage;
import pages.LoginPage;

public class CreateAPIKeyTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(APITokensPage.class.getName());

    @Test
    @Description("Creating API token")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://app.qase.io/user/api/token")
    public void createAPIKeyTest() {
        logger.info("Start CreateAPIKeyTest");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.openPage().makeLogin().getUserMenu().goToAPITokens().createAndSaveAPIToken().isAPITokenCreated());

        logger.info("API key created");
        logger.info("CreateAPIKeyTest successful complete");
    }
}
