package tests.uitests;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RepositoryPage;
import testdata.NewProjectData;

public class CreateNewProjectTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(CreateNewProjectTest.class.getName());
    @Test
    public void createNewProjectTest() {
        logger.info("Start CreateNewProjectTest");
        LoginPage loginPage = new LoginPage(driver);
        //loginPage.openPage().makeLogin().createNewProject().sendNewProjectModel(NewProjectData.getNewProjectData()).createProject().isCreated();
        Assert.assertTrue(loginPage.openPage().makeLogin().createNewProject().sendNewProjectModel(NewProjectData.getNewProjectData()).createProject().isCreated());
        logger.info("CreateNewProjectTest successful complete");
    }

}
