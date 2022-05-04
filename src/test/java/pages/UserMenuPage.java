package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMenuPage extends BasePage{

    private By SIGN_OUT_LINK = By.xpath("//a[text()=' Sign out']");
    private By API_TOKENS_LINK = By.xpath("//a[text()=' API tokens']");

    private static final Logger logger = LogManager.getLogger(UserMenuPage.class.getName());

    public UserMenuPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Api tokens' link from menu")
    public APITokensPage goToAPITokens() {
        driver.findElement(API_TOKENS_LINK).click();
        logger.info("Click Api tokens button");
        return new APITokensPage(driver);
    }
    @Step("Click 'Sign out' link from menu")
    public SignOutPage signOut() {
        driver.findElement(SIGN_OUT_LINK).click();
        logger.info("Click Sign out button");
        return new SignOutPage(driver);
    }

}
