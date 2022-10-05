import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.ConfigProperties;

public class MainPageTest extends BasePage{

//    @Test
    public void testRedirectionOfProduct() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        driver.get(ConfigProperties.getProperty("processorsPageURL"));
        Thread.sleep(2000);
        mainPage.clickToFirstItemOnPage();
        Thread.sleep(2000);
        String articulFromDetailPage = mainPage.getArticulFromDetailPage();
        Assert.assertEquals(mainPage.getArticulOfItem(), articulFromDetailPage);

    }

//    @Test
    public void testFilterOfRange() throws  InterruptedException{
        MainPage mainPage = new MainPage(driver);
        driver.get(ConfigProperties.getProperty("processorsPageURL"));
        Thread.sleep(2000);
        mainPage.setPriceRange();
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.getRangeValue(mainPage.minRangeBy),ConfigProperties.getProperty("minRange"));
        Assert.assertEquals(mainPage.getRangeValue(mainPage.maxRangeBy),ConfigProperties.getProperty("maxRange"));
    }

    @Test
    public void testWishList() throws InterruptedException{
        MainPage mainPage = new MainPage(driver);
        driver.get(ConfigProperties.getProperty("processorsPageURL"));
        Thread.sleep(2000);
        mainPage.addToWishList();
        driver.get(ConfigProperties.getProperty("wishListURL"));
        String articulFromWishPage = mainPage.getArticulFromWishPage();
        Assert.assertEquals(mainPage.getArticulOfItem(), articulFromWishPage);
    }

//    @Test
    public void testComparison() throws InterruptedException{
        MainPage mainPage = new MainPage(driver);
        driver.get(ConfigProperties.getProperty("processorsPageURL"));
        Thread.sleep(2000);
        mainPage.addToComparison();

    }

}