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

public class DeleteProjectTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(DeleteProjectTest.class.getName());

    @Test
    @Description("Delete random project from projects list")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://app.qase.io/projects")
    public void deleteProjectTest() {
        logger.info("Start DeleteProjectTest");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage().makeLogin().deleteProject().delete();
        Assert.assertEquals(driver.getCurrentUrl(), WebUrls.QASEIO_PROJECTS_URL, "Project not deleted");
        logger.info("DeleteProjectTest successful complete");
    }
}
