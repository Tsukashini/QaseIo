package pages;


import io.qameta.allure.Step;
import models.SuiteModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateSuitePage extends BasePage {

    private By SUITE_NAME_INPUT = By.id("name");
    private By SAVE_SUITE_BUTTON = By.id("save-suite-button");
    private By PRECONDITIONS_INPUT = By.xpath("//div[@id='preconditionsGroup']/descendant::p[@class='empty-node' ]");
    private By DESCRIPTION_INPUT = By.xpath("//div[@id='descriptionGroup']/descendant::p[@class='empty-node' ]");

    private static final Logger logger = LogManager.getLogger(CreateSuitePage.class.getName());

    public CreateSuitePage(WebDriver driver) {
        super(driver);
    }

    @Step("Send suite data to new suite form")
    public RepositoryPage createSuite(SuiteModel suiteModel) {
        logger.info(this.getClass().getName() + "is opened");
        driver.findElement(SUITE_NAME_INPUT).sendKeys(suiteModel.getSuiteName());
        driver.findElement(DESCRIPTION_INPUT).sendKeys(suiteModel.getDescription());
        driver.findElement(PRECONDITIONS_INPUT).sendKeys(suiteModel.getPrecondition());
        driver.findElement(SAVE_SUITE_BUTTON).click();
        logger.info("New suite is saved");
        return new RepositoryPage(driver);
    }

}
