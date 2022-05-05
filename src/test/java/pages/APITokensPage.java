package pages;


import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.FakerMessage;

public class APITokensPage extends BasePage {

    private By NEW_API_TOKEN_BUTTON = By.linkText("Create a new API token");
    private By TITLE_INPUT = By.id("title");
    private By CREATE_BUTTON = By.id("createToken");
    private By TOKEN = By.id("token");
    private By CLOSE_BUTTON = By.id("tokenClose");
    private String title;

    private static final Logger logger = LogManager.getLogger(APITokensPage.class.getName());

    public APITokensPage(WebDriver driver) {
        super(driver);
    }

    @Step("Create and save API token")
    public APITokensPage createAndSaveAPIToken() {
        driver.findElement(NEW_API_TOKEN_BUTTON).click();
        title = FakerMessage.getAPITitle();
        driver.findElement(TITLE_INPUT).sendKeys(title);
        driver.findElement(CREATE_BUTTON).click();
        logger.info("Waiting that token link is displayed");
        while (!driver.findElement(TOKEN).isDisplayed()) {
        }
        String token = driver.findElement(TOKEN).getText();


        System.out.println(token);
        logger.info("Token saved");
        driver.findElement(CLOSE_BUTTON).sendKeys(Keys.ESCAPE);

        return this;
    }

    @Step("Сheck that API token is present on the page")
    public boolean isAPITokenCreated() {
        String xpath = String.format("//div/span[text()='%s']", title);
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }
}
