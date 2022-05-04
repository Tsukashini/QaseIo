package tests.uitests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RepositoryPage;
import testdata.NewTestCaseData;

public class CreateTestCaseTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(CreateTestCaseTest.class.getName());
    @Test
    public void createTestCaseTest() {
        logger.info("Start CreateTestCaseTest");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage().makeLogin().editProject().newTestCaseCreate().createTestCase(NewTestCaseData.getNewTestCaseData());
        Assert.assertTrue(new RepositoryPage(driver).isCreated());
        logger.info("New test case displayed in project repository");
        logger.info("CreateTestCaseTest successful complete");
    }
}
