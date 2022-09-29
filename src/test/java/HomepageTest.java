import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigProperties;

public class HomepageTest {

    WebDriver driver;
    @BeforeMethod
    public void logoutTestingSetUp(){
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromeDriver"));
        driver  = new ChromeDriver();

    }

    @Test
    public void homeTesting() throws InterruptedException {
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

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }
}
