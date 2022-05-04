package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteProjectPage extends BasePage{

    private By DELETE_BUTTON = By.xpath("//button[text()=' Delete project']");
    private By CANCEL_BUTTON = By.linkText("Cancel");

    private static final Logger logger = LogManager.getLogger(DeleteProjectPage.class.getName());

    public DeleteProjectPage(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage delete() {
        driver.findElement(DELETE_BUTTON).click();
        logger.info("Delete b click");
        return new ProjectsPage(driver);
    }

    public ProjectsPage cancel() {
        driver.findElement(CANCEL_BUTTON).click();
        logger.info("Cancel button click");
        return new ProjectsPage(driver);
    }
}
