package tests.uitests;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.LoginPage;

@Log4j
public class GetProjectsTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(GetProjectsTest.class.getName());
    @Test
    public void getAllProjects() {
        logger.info("Start GetProjectsTest");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage().makeLogin().getProjectsList();
        logger.info("GetProjectsTest successful complete");

    }
}
