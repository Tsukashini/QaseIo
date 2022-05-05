package pages;

import io.qameta.allure.Step;
import models.TestCaseModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateTestCasePage extends BasePage {

    private By TITLE_INPUT = By.id("title");
    private By SAVE_BUTTON = By.id("save-case");
    private By DESCRIPTION_INPUT = By.xpath("//div[@id='descriptionGroup']/descendant::p[@class='empty-node' ]");

    private static final Logger logger = LogManager.getLogger(CreateTestCasePage.class.getName());

    public CreateTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Send test case data to new test case form")
    public RepositoryPage createTestCase(TestCaseModel testCaseModel) {
        driver.findElement(TITLE_INPUT).sendKeys(testCaseModel.getTitle());
        driver.findElement(DESCRIPTION_INPUT).sendKeys(testCaseModel.getDescription());
        driver.findElement(SAVE_BUTTON).click();
        logger.info("New test case is saved");
        return new RepositoryPage(driver);
    }


}
