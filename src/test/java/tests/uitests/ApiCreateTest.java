package tests.uitests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import staticdata.WebUrls;

public class ApiCreateTest extends BaseTest{

    @Test
    public void cancelApiCreateTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.makeLogin();
        Assert.assertEquals(driver.getCurrentUrl(), WebUrls.QASEIO_PROJECTS_URL, "Login fail");
        driver.findElement(By.id("user-menu")).click();
        driver.findElement(By.xpath("//a[text()=' API tokens']")).click();
        driver.findElement(By.xpath("//a[text()='Create a new API token']")).click();
        driver.findElement(By.xpath("//div[@class='col text-end']/button[text()='Cancel']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Create a new API token']")).isDisplayed());
    }

}
