package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigProperties;

public class RegisterPage {
    protected WebDriver driver;

    public RegisterPage (WebDriver driver){
        this.driver = driver;
    }

    private By registerLinkBy = By.xpath("//a[contains(text(),'Регистрация')]");
    private By nameFieldBy = By.xpath("//div[@class='bx-authform-input-container']/input[@name='USER_NAME']");
    private By surnameFieldBy = By.name("USER_LAST_NAME");
    private By emailFieldBy = By.xpath("//div[@class='bx-authform-input-container']/input[@name='USER_EMAIL']");
    private By phoneFieldBy = By.xpath("//div[@class='bx-authform-input-container']/input[@name='PERSONAL_PHONE']");
    private By passwordFieldBy = By.xpath("//div[@class='bx-authform-input-container']/input[@id='REG_USER_PASSWORD']");
    private By passwordConfirmBy = By.xpath("//div[@class='bx-authform-input-container']/input[@name='USER_CONFIRM_PASSWORD']");
    private By registerButtonBy = By.xpath("//input[@name='Register']");

    public void goToSignUpPage(){
        driver.findElement(registerLinkBy).click();
    }

    public void signUp(){
        WebElement nameField = driver.findElement(nameFieldBy);
        nameField.sendKeys(ConfigProperties.getProperty("name"));
        WebElement surnameField = driver.findElement(surnameFieldBy);
        surnameField.sendKeys(ConfigProperties.getProperty("surname"));
        WebElement emailField = driver.findElement(emailFieldBy);
        emailField.sendKeys(ConfigProperties.getProperty("email"));
        WebElement phoneField = driver.findElement(phoneFieldBy);
        phoneField.sendKeys(ConfigProperties.getProperty("phone"));
        WebElement passwordField = driver.findElement(passwordFieldBy);
        passwordField.sendKeys(ConfigProperties.getProperty("password"));
        WebElement passwordConfirmField = driver.findElement(passwordConfirmBy);
        passwordConfirmField.sendKeys(ConfigProperties.getProperty("password"));
        driver.findElement(registerButtonBy).click();
    }

}
