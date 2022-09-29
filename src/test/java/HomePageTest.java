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

    @Test
    public void testHappyPathLogin() throws InterruptedException {
        extentTest = extent.createTest("Shop.kz Login Test");
        LoginPage loginPage = new LoginPage(driver);
        driver.get(ConfigProperties.getProperty("mainURL"));
        Thread.sleep(2000);
        loginPage.clearAd();
        Thread.sleep(1000);
        loginPage.openSignIn();
        Thread.sleep(2000);
        loginPage.signIn();
        Thread.sleep(2000);

        String fullname = ConfigProperties.getProperty("name") + " " + ConfigProperties.getProperty("surname");
        Assert.assertEquals(loginPage.getProfileName(), fullname);
    }

    @Test
    public void testUnHappyPathLogin() throws InterruptedException {
        extentTest = extent.createTest("Shop.kz Login Test");
        LoginPage loginPage = new LoginPage(driver);
        driver.get(ConfigProperties.getProperty("mainURL"));
        Thread.sleep(2000);
        loginPage.clearAd();
        Thread.sleep(1000);
        loginPage.openSignIn();
        Thread.sleep(2000);
        loginPage.signInUnhappy("arexoff@mail.com", "12345678");
        Thread.sleep(2000);

        String fullname = ConfigProperties.getProperty("name") + " " + ConfigProperties.getProperty("surname");
        Assert.assertEquals(loginPage.getProfileName(), fullname);
    }

    @Test
    public void registrationTest() throws InterruptedException {
        extentTest = extent.createTest("Shop.kz Registration Test");
        RegisterPage registerPage = new RegisterPage(driver);
//        driver.get(ConfigProperties.getProperty("mainURL"));
//        registerPage.goToSignUpPage();
//        registerPage.signUp();

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
//       home.setKeyboard();
//       Thread.sleep(3000);
//        home.setSearchField();
//        home.tKeyword("macbook");
//        Thread.sleep(3000);

    }



    @AfterTest
    public void tearDown(){
        extent.flush();
        driver.quit();
    }
}