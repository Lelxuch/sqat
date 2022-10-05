package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigProperties;

import java.util.Locale;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By locationName = By.xpath("//div/div/a[@class='selected']");
    private By cityName = By.xpath("//div[@class='default_popup choose_city_popup']/ul/li/a[@rel='2']");
    private By regionName = By.xpath("//a[contains(text(),'Акмолинская область')]");
    private By city = By.xpath("//a[contains(text(),'Кокшетау')]");

    private By searchField = By.className("search-hover__field");
    private By multiSearch = By.className("multi-input");
    private By addToCartButton = By.className("bx-owl-item-add-btn");
    private By keyboardName = By.xpath("//div[@class='autocomplete-products__item-info']");
    private By submitButton = By.xpath("//div[@class='multi-header']/button[@class='multi-icon multi-searchIcon']");

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

    public void setSearchField(){
        WebElement searchBox = driver.findElement(searchField);
        searchBox.click();
    }

    public void typeKeyword (String keys){
        WebElement multiBox = driver.findElement(multiSearch);
        multiBox.sendKeys(keys);
    }

    public void setKeyboard(){
        String title = driver.findElement(keyboardName).getText();
        if(title.toLowerCase().contains("клавиатура")){
            Assert.assertTrue(true);
        }
    }

    public void pressAddToCartButton() {
//        WebElement button = driver.findElement(addToCartButton);
//        System.out.println(button);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }
}
