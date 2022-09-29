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

public class CartPageTest {
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
    public void addItemToCart() throws InterruptedException {
        extentTest = extent.createTest("Shop.kz Adding Item to Cart Test");
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        driver.get(ConfigProperties.getProperty("mainURL"));
        Thread.sleep(2000);
        loginPage.clearAd();
        Thread.sleep(1000);
        loginPage.openSignIn();
        Thread.sleep(2000);
        loginPage.signIn();
        Thread.sleep(2000);

        cartPage.addItemToCart();

        Assert.assertEquals(cartPage.getItemNameFromCart(), "Ноутбук ASUS VivoBook Pro 16X M7600QC, OLED (90NB0V81-M01630)");
    }

    @Test
    public void deleteItemFromCart() throws InterruptedException {
        extentTest = extent.createTest("Shop.kz Deleting Item from Cart Test");
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        driver.get(ConfigProperties.getProperty("mainURL"));
        Thread.sleep(2000);
        loginPage.clearAd();
        Thread.sleep(1000);
        loginPage.openSignIn();
        Thread.sleep(2000);
        loginPage.signIn();
        Thread.sleep(2000);

        cartPage.deleteItemFromCart();

        Assert.assertTrue(cartPage.isDisplayedItemNameFromCart());
    }


    @AfterTest
    public void tearDown(){
        extent.flush();
//        driver.quit();
    }
}