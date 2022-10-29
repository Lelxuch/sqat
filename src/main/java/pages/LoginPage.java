package pages;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigProperties;
import utils.Database;
import utils.DatabaseReader;

import java.sql.Connection;

import static utils.ExcelRead.workbook;

public class LoginPage {
    protected WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By signInLinkBy = By.xpath("//a[@id='btn_show_auth']");
    private By oneTimeBy = By.id("onesignal-slidedown-cancel-button");
    private By emailBy = By.id("ppUSER_LOGIN");
    private By passwordBy = By.id("ppUSER_PASSWORD");
    private By loginBtnBy = By.id("login_btn");
    private By profileNameBy = By.xpath("//span[contains(text(), 'Merey Orynbassar')]");

    private By authStatusBy = By.id("auth-status");

    public void openSignIn(){
        driver.findElement(signInLinkBy).click();
    }

    public boolean isAlertDisplayed(){
        WebElement authStatus = driver.findElement(authStatusBy);
        String classOfAuthStatus = authStatus.getAttribute("class");
        return !classOfAuthStatus.contains("hidden");
    }
    public void clearAd() throws InterruptedException {
        Thread.sleep(2000);
        WebElement ad = driver.findElement(oneTimeBy);
        if(ad.isDisplayed()){
            ad.click();
        }
    }

    public void signIn(){
//        Database db = new Database();
//        DatabaseReader databaseReader = new DatabaseReader(db);
//        String email = databaseReader.readParam("email");
//        String password = databaseReader.readParam("password");
        Sheet sheet = workbook.getSheet("Account_data");
        WebElement emailField = driver.findElement(emailBy);
        emailField.sendKeys(sheet.getRow(1).getCell(4).getStringCellValue());
        WebElement passwordField = driver.findElement(passwordBy);
        passwordField.sendKeys(sheet.getRow(1).getCell(5).getStringCellValue());
        driver.findElement(loginBtnBy).click();
    }

    public void signInWithCredentials(String username, String password){
        WebElement emailField = driver.findElement(emailBy);
        emailField.sendKeys(username);
        WebElement passwordField = driver.findElement(passwordBy);
        passwordField.sendKeys(password);
        driver.findElement(loginBtnBy).click();
    }

    public void signInUnhappy(String nameKey, String surnameKey){
        WebElement emailField = driver.findElement(emailBy);
        emailField.sendKeys(nameKey);
        WebElement passwordField = driver.findElement(passwordBy);
        passwordField.sendKeys(surnameKey);
        driver.findElement(loginBtnBy).click();
    }

    public String getProfileName() {
        WebElement profileName = driver.findElement(profileNameBy);
        return profileName.getText();
    }
}
