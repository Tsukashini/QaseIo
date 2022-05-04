package tests.uitests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RepositoryPage;
import testdata.NewSuiteData;

public class CreateSuiteTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(CreateSuiteTest.class.getName());

    @Test
    public void createSuiteTest() {
        logger.info("Start CreateSuiteTest");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage().makeLogin().editProject().newSuiteCreate().createSuite(NewSuiteData.getNewSuitData());
        Assert.assertTrue(new RepositoryPage(driver).isCreated());
        logger.info("New suite displayed in project repository");
        logger.info("CreateSuiteTest successful complete");
    }

}
