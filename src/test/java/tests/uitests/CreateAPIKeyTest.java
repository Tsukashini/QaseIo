package tests.uitests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.APITokensPage;
import pages.LoginPage;

public class CreateAPIKeyTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(APITokensPage.class.getName());
    @Test
    public void createAPIKeyTest() {
        logger.info("Start CreateAPIKeyTest");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.openPage().makeLogin().getUserMenu().goToAPITokens().createAndSaveAPIToken().isAPITokenCreated());

        logger.info("API key created");
        logger.info("CreateAPIKeyTest successful complete");
    }
}
