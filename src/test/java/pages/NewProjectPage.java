package pages;

import io.qameta.allure.Step;
import models.NewProjectModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NewProjectPage extends BasePage {


    private By PROJECT_CODE_INPUT = By.id("inputCode");
    private By PROJECT_NAME_INPUT = By.id("inputTitle");
    private By DESCRIPTION_INPUT = By.id("inputDescription");
    private By PUBLIC_CHECK_BOX = By.id("public-access-type");
    private By PRIVATE_CHECK_BOX = By.id("private-access-type");
    private By CREATE_PROJECT_BUTTON = By.xpath("//button[text()='Create project']");

    private static final Logger logger = LogManager.getLogger(NewProjectPage.class.getName());

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Send model new project")
    public NewProjectPage sendNewProjectModel(NewProjectModel newProjectModel) {
        driver.findElement(PROJECT_NAME_INPUT).click();
        driver.findElement(PROJECT_NAME_INPUT).sendKeys(newProjectModel.getName());
        driver.findElement(DESCRIPTION_INPUT).sendKeys(newProjectModel.getDescription());
        if (newProjectModel.getType() == 2) {
            driver.findElement(PUBLIC_CHECK_BOX).click();
        }
        logger.info("New project model is sending");
        return this;
    }

    @Step("Click button for create new project")
    public RepositoryPage createProject() {
        driver.findElement(CREATE_PROJECT_BUTTON).click();
        logger.info("New project created");
        return new RepositoryPage(driver);
    }

}
