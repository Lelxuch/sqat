import org.testng.annotations.Test;
import pages.RegisterPage;
import utils.ConfigProperties;

public class RegisterPageTest extends BasePage {

    @Test
    public void registrationTest() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        driver.get(ConfigProperties.getProperty("mainURL"));
        registerPage.goToSignUpPage();
        registerPage.signUp();

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

}
