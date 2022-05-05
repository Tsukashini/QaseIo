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
import testdata.NewProjectData;

public class CreateNewProjectTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(CreateNewProjectTest.class.getName());

    @Test(priority = 2, description = "Authorization user create a new project")
    @Description("Authorization user create a new project")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://app.qase.io/projects")
    public void createNewProjectTest() {
        logger.info("Start CreateNewProjectTest");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.openPage().makeLogin().createNewProject().sendNewProjectModel(NewProjectData.getNewProjectData()).createProject().isCreated());
        logger.info("CreateNewProjectTest successful complete");
    }

}
