package pages;

import org.openqa.selenium.WebDriver;

public class SignOutPage extends BasePage{

    public SignOutPage(WebDriver driver) {
        super(driver);
    }

    public String isSignOut() {
        return driver.getCurrentUrl();
    }
}
