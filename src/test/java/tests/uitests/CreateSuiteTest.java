package tests.uitests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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
    @Description("Create suite for random project from projects list")
    @Severity(SeverityLevel.CRITICAL)
    public void createSuiteTest() {
        logger.info("Start CreateSuiteTest");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage().makeLogin().editProject().newSuiteCreate().createSuite(NewSuiteData.getNewSuitData());
        Assert.assertTrue(new RepositoryPage(driver).isCreated());
        logger.info("New suite displayed in project repository");
        logger.info("CreateSuiteTest successful complete");
    }

}
