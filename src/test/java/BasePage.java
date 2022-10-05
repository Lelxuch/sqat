import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ConfigProperties;
import utils.DriverSettings;
import utils.ExtentManager;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasePage {
    public static WebDriver driver;
    public static DriverSettings driverSettings = new DriverSettings();


    @BeforeSuite
    public void BeforeSuit(){
      ExtentManager.setExtent();
    }

    @AfterSuite
    public void AfterSuit(){
        ExtentManager.endReport();
    }


    @BeforeMethod
    public void setup(){
        driverSettings.initDriver();
        driver = driverSettings.getDriver();
        driver.get(ConfigProperties.getProperty("mainURL"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public static String screenShot(WebDriver driver, String filename){
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
//        String destination = System.getProperty("user.dir")+"\\ScreenShot\\"+filename+".png";
        String destination = "target//ScreenShorts"+  ".jpeg";
        File finalDestinatiom= new File(destination);
        try {
            FileUtils.copyFile(source, finalDestinatiom);
        } catch (Exception e){
            e.getMessage();
        }
        return destination;
    }
}
