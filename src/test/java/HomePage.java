import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By locationName = By.xpath("//div/div/a[@class='selected']");
    private By cityName = By.xpath("//body/div[7]/ul[1]/li[3]/a[1]");
    private By regionName = By.xpath("//a[contains(text(),'Акмолинская область')]");
    private By city = By.xpath("//a[contains(text(),'Кокшетау')]");
    private By searchField = By.className("search-hover__field");
    private By multiSearch = By.className("multi-input");
    private By keyboardName = By.xpath("//div[contains(text(),'Клавиатура HyperX Alloy Origins 60, White-Pink, US')]");
    private By submitButton = By.xpath("//div[@class='multi-layout']/div/button[@class='multi-icon multi-searchIcon']");

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
        driver.findElement(keyboardName).click();

    }

}
