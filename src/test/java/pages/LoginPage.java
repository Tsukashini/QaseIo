package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.Secret;
import staticdata.WebUrls;

public class LoginPage extends BasePage {

    private By EMAIL_INPUT = By.id("inputEmail");
    private By PASSWORD_INPUT = By.id("inputPassword");
    private By LOGIN_BUTTON = By.id("btnLogin");

    private static final Logger logger = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step ("Open login page ")
    public LoginPage openPage() {
        driver.get(WebUrls.QASEIO_LOGIN_URL);
        return this;
    }

    @Step("Send user email and password into login form and click login button")
    public ProjectsPage makeLogin() {
        driver.findElement(EMAIL_INPUT).sendKeys(Secret.EMAIL);
        driver.findElement(PASSWORD_INPUT).sendKeys(Secret.PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
        logger.info("Authorization data send");
        return new ProjectsPage(driver);
    }
}
