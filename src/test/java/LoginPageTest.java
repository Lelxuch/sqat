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

public class LoginPageTest extends  BasePage{

    @Test
    public void testHappyPathLogin() throws InterruptedException {
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


}