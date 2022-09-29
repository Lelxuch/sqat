import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    By locationName = By.xpath("//div/div/a[@class='selected']");
    By cityName = By.xpath("//body/div[7]/ul[1]/li[3]/a[1]");
    By regionName = By.xpath("//a[contains(text(),'Акмолинская область')]");
    By city = By.xpath("//a[contains(text(),'Кокшетау')]");

    public void setLocation(){
        driver.findElement(locationName).click();
    }

    public void setCity(){
        driver.findElement(cityName).click();
    }

    public  void setRegion(){
        driver.findElement(regionName).click();
    }

    public void setCityName(){
        driver.findElement(city).click();
    }

    By searchField = By.className("search-hover__field");
    By multiSearch = By.className("multi-input");
    By keyboardName = By.xpath("//div[contains(text(),'Клавиатура HyperX Alloy Origins 60, White-Pink, US')]");
    By submitButton = By.xpath("//div[@class='multi-layout']/div/button[@class='multi-icon multi-searchIcon']");

    public void setSearchField(){
        WebElement searchBox = driver.findElement(searchField);
        searchBox.click();

    }

    public void typeKeyword (String keys){
        WebElement multiBox = driver.findElement(multiSearch);
        multiBox.sendKeys(keys);
    }

    public void setKewboard(){
        driver.findElement(keyboardName).click();

    }
    public void tKeyword (String keys){
        WebElement multiBox = driver.findElement(multiSearch);
        multiBox.sendKeys(keys);

    }

    By signIn = By.id("btn_show_auth");
    By email = By.id("ppUSER_LOGIN");
    By password = By.id("ppUSER_PASSWORD");
    By loginBtn = By.id("login_btn");

    public void openSignIn(){
        driver.findElement(signIn).click();
    }

    public void emailField(String key){
        WebElement element = driver.findElement(email);
        element.sendKeys(key);
    }
    public void setPasswordField(String keys){
        WebElement element = driver.findElement(password);
        element.sendKeys(keys);
    }

    public void loginButton(){
        driver.findElement(loginBtn).click();
    }

    By register = By.xpath("//a[contains(text(),'Регистрация')]");
    By nameField = By.xpath("//div[@class='bx-authform-input-container']/input[@name='USER_NAME']");
    By surnameField = By.name("USER_LAST_NAME");
    By emailField = By.xpath("//div[@class='bx-authform-input-container']/input[@name='USER_EMAIL']");
    By phoneField = By.xpath("//div[@class='bx-authform-input-container']/input[@name='PERSONAL_PHONE']");
    By passwordField = By.xpath("//div[@class='bx-authform-input-container']/input[@id='REG_USER_PASSWORD']");
    By passwordConfirm = By.xpath("//div[@class='bx-authform-input-container']/input[@name='USER_CONFIRM_PASSWORD']");
    By registerButton = By.xpath("//div[@class='bx-authform-formgroup-container']/input[@name='Register']");

    public void signUp(){
        driver.findElement(register).click();
    }

    public void setName(String nameKey){
        WebElement element = driver.findElement(nameField);
        element.sendKeys(nameKey);
    }

    public void setSurname(String surnameKey){
        WebElement element = driver.findElement(surnameField);
        element.sendKeys(surnameKey);
    }

    public void setEmail(String emailKey){
        WebElement element = driver.findElement(emailField);
        element.sendKeys(emailKey);
    }

    public void setPhone(String phoneKey){
        WebElement element = driver.findElement(phoneField);
        element.sendKeys(phoneKey);
    }

    public void setPassword(String passwordKey){
        WebElement element = driver.findElement(passwordField);
        element.sendKeys(passwordKey);
    }

    public void confirmPassword(String confirmKey){
        WebElement element = driver.findElement(passwordConfirm);
        element.sendKeys(confirmKey);
    }

    public void registerBtn(){
        driver.findElement(registerButton).click();
    }



}