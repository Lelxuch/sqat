import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigProperties;
import utils.Database;
import utils.DatabaseWriter;
import utils.ExtentManager;

import static utils.ExcelRead.workbook;

public class LoginPageTest extends  BasePage{

    @Test
    public void testHappyPathLogin() throws InterruptedException {
//        ExtentManager.extentTest = ExtentManager.extent.createTest("Shop.kz Success login test");
        DatabaseWriter databaseWriter = new DatabaseWriter(new Database());
        try{
            LoginPage loginPage = new LoginPage(driver);
//        driver.get(ConfigProperties.getProperty("mainURL"));
            Sheet sheet = workbook.getSheet("URLs");
            driver.get(sheet.getRow(1).getCell(1).getStringCellValue());
            Thread.sleep(2000);
            loginPage.clearAd();
            Thread.sleep(1000);
            loginPage.openSignIn();
            Thread.sleep(2000);
            loginPage.signIn();
            Thread.sleep(2000);

            sheet = workbook.getSheet("Account_data");

            String fullname = sheet.getRow(1).getCell(1).getStringCellValue() + " " + sheet.getRow(1).getCell(2).getStringCellValue();
            Assert.assertEquals(loginPage.getProfileName(), fullname);
            databaseWriter.writeResult("testHappyPathLogin", true);
        }
        catch (Exception e){
            e.printStackTrace();
            databaseWriter.writeResult("testHappyPathLogin", false);


        }

    }

    @Test
    public void testUnHappyPathLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
//        driver.get(ConfigProperties.getProperty("mainURL"));
        Sheet sheet = workbook.getSheet("URLs");
        driver.get(sheet.getRow(1).getCell(1).getStringCellValue());
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