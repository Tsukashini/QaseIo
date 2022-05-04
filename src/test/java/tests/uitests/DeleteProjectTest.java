package tests.uitests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import staticdata.WebUrls;

public class DeleteProjectTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(DeleteProjectTest.class.getName());
    @Test
    public void deleteProjectTest() {
        logger.info("Start DeleteProjectTest");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage().makeLogin().deleteProject().delete();
        Assert.assertEquals(driver.getCurrentUrl(), WebUrls.QASEIO_PROJECTS_URL, "Project not deleted");
        logger.info("DeleteProjectTest successful complete");
    }
}
