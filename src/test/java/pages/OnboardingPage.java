package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnboardingPage extends BasePage{

    private By STEP_1_PAGE_OPEN_TEST = By.xpath("//h2[contains(., 'Tell us about you')]"); //STEP 1 TEST

    private By FULL_NAME_INPUT = By.id("fullName");
    private By JOB_TITLE_INPUT = By.id("jobTitle");
    private By YOUR_ROLE_RADIO_BUTTON = By.name("role");  //8 items

    private By SAVE_BUTTON = By.xpath("//button[contains(., 'Save')]");

    private By STEP_2_PAGE_OPEN_TEST = By.xpath("//h2[contains(., 'About your team')]"); //STEP 2 TEST
    private By STEP_3_PAGE_OPEN_TEST = By.xpath("//h2[contains(., 'You’re almost set up!')]"); //STEP 2 TEST

    private By COMPANY_NAME_INPUT = By.id("companyName");
    private By PEOPLE_IN_COMPANY_BUTTON = By.xpath("//div[@class='form-group']/button"); // 7 items
    private By COMPANY_TYPE_RADIO_BUTTON = By.name("company-type");  // 2 items
    private By COMPANY_INDUSTRY_RADIO_BUTTON = By.name("industry");   // 9 items
    private By LATER_BUTTON = By.xpath("//button[contains(., 'Later')]");

    public OnboardingPage(WebDriver driver) {
        super(driver);
    }
}
