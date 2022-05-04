package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RepositoryPage extends BasePage {

    private By NEW_SUITE_BUTTON = By.id("create-suite-button");
    private By NEW_CASE_BUTTON = By.id("create-case-button");
    private By SUCCESSFUL_ALERT_MESSAGE = By.xpath("//div[@class='alert alert-success show']/span[@class='alert-message']");

    private static final Logger logger = LogManager.getLogger(RepositoryPage.class.getName());

    public RepositoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCreated() {
        return driver.findElement(SUCCESSFUL_ALERT_MESSAGE).isDisplayed();
    }

    public CreateSuitePage newSuiteCreate() {
        driver.findElement(NEW_SUITE_BUTTON).click();
        logger.info("Click Suite create button");
        return  new CreateSuitePage(driver);
    }

    public CreateTestCasePage newTestCaseCreate() {
        driver.findElement(NEW_CASE_BUTTON).click();
        logger.info("Click test case create button");
        return new CreateTestCasePage(driver);
    }
}
