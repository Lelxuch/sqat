import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        String HTML_REPORT_PATH = "ShopkzAutomationReport" + System.currentTimeMillis() + ".html";
        htmlReporter = new ExtentHtmlReporter(HTML_REPORT_PATH);
        extent.attachReporter(htmlReporter);
        htmlReporter.loadXMLConfig("src/test/resources/extent-config.xml");
        extent.setSystemInfo("Hostname", ConfigProperties.getProperty("mainURL"));
        extent.setSystemInfo("Execution Environment", "Staging");
        extent.setSystemInfo("Browser", ConfigProperties.getProperty("browser"));
        WebDriverManager.chromedriver().setup();
        driver  = new ChromeDriver();

    }

    @Test
    public void homeTesting() throws InterruptedException {
        extentTest = extent.createTest("Shop.kz Registration Test");
        HomePage home = new HomePage(driver);
        driver.get(ConfigProperties.getProperty("mainURL"));


//        home.setLocation();
//        Thread.sleep(2000);
//        home.setCity();
//        home.setRegion();
//        Thread.sleep(2000);
//        home.setCityName();
//        Thread.sleep(2000);

//       home.setSearchField();
//       home.typeKeyword("клавиатура");
//       Thread.sleep(3000);
//       home.setKewboard();
//       Thread.sleep(3000);
//        home.setSearchField();
//        home.tKeyword("macbook");
//        Thread.sleep(3000);

//        home.openSignIn();
//        Thread.sleep(3000);
//        home.emailField("merey0903@gmail.com");
//        Thread.sleep(3000);
//        home.setPasswordField("Merey0903");
//        Thread.sleep(3000);
//        home.loginButton();
//        Thread.sleep(4000);

        home.signUp();
        Thread.sleep(3000);
        home.setName("Merey");
        Thread.sleep(3000);
        home.setSurname("Orynbassar");
        Thread.sleep(3000);
        home.setEmail("overexm@gmail.com");
        Thread.sleep(3000);
        home.setPhone("77472646428");
        Thread.sleep(3000);
        home.setPassword("Testing123");
        Thread.sleep(3000);
        home.confirmPassword("Testing123");
        Thread.sleep(3000);
        home.registerBtn();
        Thread.sleep(3000);



    }

    @AfterTest
    public void tearDown(){
        extent.flush();
        driver.quit();
    }
}