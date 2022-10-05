import org.testng.annotations.Test;
import pages.HomePage;
import utils.ConfigProperties;

public class SearchTest extends BasePage{
    @Test
    public void searchFunctionalityTest() throws InterruptedException {
        HomePage searchFunctionality = new HomePage(driver);
        driver.get(ConfigProperties.getProperty("mainURL"));
        Thread.sleep(2000);
        searchFunctionality.setSearchField();
        Thread.sleep(2000);
        searchFunctionality.typeKeyword("клавиатура");
        Thread.sleep(3000);
        searchFunctionality.setKeyboard();
        Thread.sleep(3000);
    }
}
