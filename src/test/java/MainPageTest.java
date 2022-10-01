import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ConfigProperties;

public class MainPageTest extends BasePage{

    @Test
    public void testRedirectionOfProduct() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        driver.get(ConfigProperties.getProperty("processorsPageURL"));
        Thread.sleep(2000);
        mainPage.clickToFirstItemOnPage();
        Thread.sleep(2000);
        String articulFromDetailPage = mainPage.getArticulFromDetailPage();
        Assert.assertEquals(mainPage.getArticulOfItem(), articulFromDetailPage);

    }

    @Test
    public void testFilterOfRange() throws  InterruptedException{
        MainPage mainPage = new MainPage(driver);
        driver.get(ConfigProperties.getProperty("processorsPageURL"));
        Thread.sleep(2000);
        mainPage.setPriceRange();
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.getRangeValue(mainPage.minRangeBy),ConfigProperties.getProperty("minRange"));
    }


}