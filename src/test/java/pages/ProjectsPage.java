package pages;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectsPage extends BasePage {

    private By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    private By DELETE_BUTTON = By.xpath("//div[@class='dropdown-item' and contains(., 'Delete')]");
    private By PROJECTS_TITLES = By.xpath("//a[@class='defect-title']");
    private By PROJECT_DROPDOWN_MENU = By.xpath("//div[@class='dropdown']/a");
    private By USER_MENU = By.id("user-menu");

    private static final Logger logger = LogManager.getLogger(ProjectsPage.class.getName());

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public NewProjectPage createNewProject() {
        driver.findElement(CREATE_NEW_PROJECT_BUTTON).click();
        logger.info("New project button click");
        return new NewProjectPage(driver);
    }

    @Step("Open user menu")
    public UserMenuPage getUserMenu() {
        logger.info("Go to user menu");
        driver.findElement(USER_MENU).click();
        return new UserMenuPage(driver);
    }

    @Step("Getting a list of projects and add it to JSON file")
    public ProjectsPage getProjectsList() {
        List<String> titles = new ArrayList<>();
        for (WebElement element : driver.findElements(PROJECTS_TITLES)) {
            titles.add(element.getText());
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/test/resources/projects.json")) {
            gson.toJson(titles, writer);
            logger.info("Json with projects list created");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Delete random project")
    public DeleteProjectPage deleteProject() {
        logger.info("Start deleting random project");
        int size = driver.findElements(PROJECTS_TITLES).size();
        int number = new Faker().number().numberBetween(2, size);
        (driver.findElements(PROJECT_DROPDOWN_MENU)).get(number).click();
        driver.findElements(DELETE_BUTTON).get(number).click();
        logger.info("Go to DeleteProjectPage");
        return new DeleteProjectPage(driver);
    }

    @Step("Edit random project")
    public RepositoryPage editProject() {
        List<WebElement> webElements = driver.findElements(PROJECTS_TITLES);
        int size = webElements.size();
        int number = new Faker().number().numberBetween(0, size);
        webElements.get(number).click();
        logger.info("Go to project repository");
        return new RepositoryPage(driver);
    }

}
