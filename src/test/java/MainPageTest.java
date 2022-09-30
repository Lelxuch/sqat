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

public class MainPageTest {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentTest extentTest;
    public static DriverSettings driverSettings = new DriverSettings();

    @BeforeTest
    public void setup(){
        extent = new ExtentReports();
        String HTML_REPORT_PATH = "target//ShopkzAutomationReport" + System.currentTimeMillis() + ".html";
        htmlReporter = new ExtentHtmlReporter(HTML_REPORT_PATH);
        extent.attachReporter(htmlReporter);
        htmlReporter.loadXMLConfig("src/main/resources/extent-config.xml");
        extent.setSystemInfo("Hostname", ConfigProperties.getProperty("processorsPageURL"));
        extent.setSystemInfo("Execution Environment", "Staging");
        extent.setSystemInfo("Browser", ConfigProperties.getProperty("browser"));
        driverSettings.initDriver();
        driver = driverSettings.getDriver();
    }

    @Test
    public void testRedirectionOfProduct() throws InterruptedException {
        extentTest = extent.createTest("Shop.kz Redirection Test");
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
        extentTest = extent.createTest("Shop.kz Filter Range Test");
        MainPage mainPage = new MainPage(driver);
        driver.get(ConfigProperties.getProperty("processorsPageURL"));
        Thread.sleep(2000);
        mainPage.setPriceRange();
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.getRangeValue(mainPage.minRangeBy),ConfigProperties.getProperty("minRange"));
    }

    @AfterTest
    public void tearDown(){
        extent.flush();
        driver.quit();
    }
}