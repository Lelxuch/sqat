package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;

import static utils.ExcelRead.workbook;

public class FirstStepDef {

    WebDriver webDriver;
    LoginPage loginPage;
    Sheet sheet;

    @Given("Launch the browser")
    public void launchTheBrowser() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
        sheet = workbook.getSheet("URLs");
        webDriver.get(sheet.getRow(1).getCell(1).getStringCellValue());
    }

    @When("Clear ad and click login button.")
    public void clear_ad_and_click_login_button() throws InterruptedException {
        loginPage.clearAd();
        loginPage.openSignIn();
    }
    @Then("Enter user credentials.")
    public void enter_user_credentials() {
        loginPage.signIn();
    }
    @Then("Click login and verify account name.")
    public void click_login_and_verify_account_name() throws InterruptedException {
        Thread.sleep(2000);
        sheet = workbook.getSheet("Account_data");

        String fullname = sheet.getRow(1).getCell(1).getStringCellValue() + " " + sheet.getRow(1).getCell(2).getStringCellValue();
        Assert.assertEquals(loginPage.getProfileName(), fullname);
    }

}
