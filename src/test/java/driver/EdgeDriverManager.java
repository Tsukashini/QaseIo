package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.net.MalformedURLException;

public class EdgeDriverManager extends DriverManager{

    @Override
    public void createDriver() throws MalformedURLException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }
}
