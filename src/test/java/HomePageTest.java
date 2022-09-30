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

public class HomePageTest {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentTest extentTest;

    @BeforeTest
    public void setup(){
        extent = new ExtentReports();
        String HTML_REPORT_PATH = "target//ShopkzAutomationReport" + System.currentTimeMillis() + ".html";
        htmlReporter = new ExtentHtmlReporter(HTML_REPORT_PATH);
        extent.attachReporter(htmlReporter);
        htmlReporter.loadXMLConfig("src/main/resources/extent-config.xml");
        extent.setSystemInfo("Hostname", ConfigProperties.getProperty("mainURL"));
        extent.setSystemInfo("Execution Environment", "Staging");
        extent.setSystemInfo("Browser", ConfigProperties.getProperty("browser"));
        WebDriverManager.chromedriver().setup();
        driver  = new ChromeDriver();
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //ADD HERE TEST CASES RELATED TO HomePage OR CREATE ANOTHER CLASSES
    //EXAMPLE:
//    @Test
//    public void testSomeUnHappyPath() throws InterruptedException {
//        extentTest = extent.createTest("Shop.kz SOME_TEST_CASE_NAME Test");
//        SomePage somePage = new SomePage(driver);
//        driver.get(ConfigProperties.getProperty("mainURL"));
//        Thread.sleep(2000);
//        somePage.testCase1();
//
//        Assert.assertEquals(String actual, String expected); //OR
//        Assert.assertTrue();
//    }
    ////////////////////////////////////////////////////////////////////////////////////////


    @AfterTest
    public void tearDown(){
        extent.flush();
        driver.quit();
    }
}