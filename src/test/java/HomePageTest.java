import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ConfigProperties;

public class HomePageTest extends BasePage {

    @Test
    public void mainLocationTest() throws InterruptedException {
        HomePage mainLocation = new HomePage(driver);
        Thread.sleep(2000);
        mainLocation.setLocation();
        Thread.sleep(1000);
        mainLocation.setCity();
        Thread.sleep(2000);
    }

    @Test
    public void  locationByRegionsTest() throws InterruptedException {
        HomePage regionalLocation = new HomePage(driver);
        driver.get(ConfigProperties.getProperty("mainURL"));
        Thread.sleep(2000);
        regionalLocation.setLocation();
        Thread.sleep(1000);
        regionalLocation.setRegion();
        Thread.sleep(1000);
        regionalLocation.setCityName();
        Thread.sleep(2000);
    }
}