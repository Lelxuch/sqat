import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import utils.ConfigProperties;

public class CartPageTest extends BasePage {

    @Test
    public void addItemToCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        Thread.sleep(1500);
        loginPage.clearAd();
        Thread.sleep(1500);
        loginPage.openSignIn();
        Thread.sleep(1000);
        loginPage.signIn();
        Thread.sleep(2000);

        driver.get(ConfigProperties.getProperty("product1URL"));
        cartPage.addItemToCart();
        Thread.sleep(1000);

        Assert.assertEquals(cartPage.getItemNameFromCart(), "Ноутбук ASUS VivoBook Pro 16X M7600QC, OLED (90NB0V81-M01630)");
    }

    @Test
    public void deleteItemFromCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
//        driver.get(ConfigProperties.getProperty("mainURL"));
        Thread.sleep(1500);
        loginPage.clearAd();
        Thread.sleep(1500);
        loginPage.openSignIn();
        Thread.sleep(1000);
        loginPage.signIn();
        Thread.sleep(2000);

        cartPage.deleteItemFromCart();
        Thread.sleep(1500);



        Assert.assertTrue(cartPage.isCartEmpty());
    }
}