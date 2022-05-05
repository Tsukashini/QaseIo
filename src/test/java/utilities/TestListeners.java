package utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.uitests.BaseTest;
import tests.uitests.LoginTest;

public class TestListeners implements ITestListener {

    private static final Logger logger = LogManager.getLogger(LoginTest.class.getName());

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test ".concat(iTestResult.getName()).concat(" started"));

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test ".concat(iTestResult.getName()).concat(" complete"));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("Test Fail");
        Object currentClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseTest) currentClass).getDriver();
        AllureService allureService = new AllureService();
        allureService.takeScreenShot(webDriver);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
