import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigProperties;

public class DriverSettings {

    public static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    String config = ConfigProperties.getProperty("browser");
    public static WebDriverWait wait;

    public void initDriver() {
        System.out.println(config);
        switch (config) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver.set(new FirefoxDriver());
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                webDriver.set(new ChromeDriver());
        }
//        webDriver.get().manage().window().fullscreen();
    }

    public WebDriver getDriver() {
        return webDriver.get();
    }

    public void closeDriver() {
        webDriver.get().quit();
    }
}
