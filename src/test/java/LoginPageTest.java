import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigProperties;
import utils.ExtentManager;

public class LoginPageTest extends  BasePage{

    @Test
    public void testHappyPathLogin() throws InterruptedException {
        ExtentManager.extentTest = ExtentManager.extent.createTest("Shop.kz Success login test");
        LoginPage loginPage = new LoginPage(driver);
        driver.get(ConfigProperties.getProperty("mainURL"));
        Thread.sleep(2000);
        loginPage.clearAd();
        Thread.sleep(1000);
        loginPage.openSignIn();
        Thread.sleep(2000);
        loginPage.signIn();
        Thread.sleep(2000);

        String fullname = "Mere" + " " + ConfigProperties.getProperty("surname");
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

        Assert.assertTrue(loginPage.isAlertDisplayed());
    }


}