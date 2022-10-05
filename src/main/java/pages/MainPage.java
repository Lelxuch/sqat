package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigProperties;

public class MainPage {
    protected WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By itemOnPageBy = By.xpath("//div[@class='bx_catalog_item double']");
    private By linkToItemBy = By.xpath("//div[@class='bx_catalog_item_title']/a");
    private By articulFromMainPageBy = By.xpath("//div[@class='bx_catalog_item_XML_articul']");
    private By articulFromDetailPageBy = By.xpath("//ul[@class='bx-card-mark col-lg-4 col-xs-12 col-sm-6']");
    private By applyButtonBy = By.xpath("//a[@class='btn btn-xs btn-primary']");
    public By minRangeBy = By.id("filter_02_P7_MIN");
    public By maxRangeBy = By.id("filter_02_P7_MAX");

    public String articulOfItem = null;

    private By addToWishListBy = By.name("towishlist");
    private By addToComparisonBy = By.xpath("//div[@class='bx_catalog_item_controls_blockthree']/a[2]");
    private By articulFromWishListBy = By.xpath("//div[@class='g-i-tile-i-art']");


    public String getRangeValue(By by){
      return driver.findElement(by).getAttribute("value");
    }

    public String getArticulOfItem() {
        return articulOfItem;
    }

    public String clearStringFromChars(String str){
        return str.replaceAll("[^\\d.]", "");
    }

    public void setArticulOfItem(String articulOfItem) {
        this.articulOfItem = articulOfItem;
    }

    public String getArticulFromDetailPage(){
        return clearStringFromChars(driver.findElement(articulFromDetailPageBy).getText());
    }

    public String getArticulFromWishPage(){
        return clearStringFromChars(driver.findElement(articulFromWishListBy).getText());
    }

    public WebElement getProductFromPage(int index){
        return driver.findElements(itemOnPageBy).get(index);
    }

    public void addToWishList(){
        WebElement firstItem = getProductFromPage(0);
        setArticulOfItem(clearStringFromChars(firstItem.findElement(articulFromMainPageBy).getText()));
        firstItem.findElement(addToWishListBy).click();
    }

    public void addToComparison(){
        WebElement firstItem = getProductFromPage(0);
        WebElement secondItem = getProductFromPage(1);
        firstItem.findElement(addToComparisonBy).click();
        secondItem.findElement(addToComparisonBy).click();
    }
    public void clickToFirstItemOnPage(){
        WebElement firstItem = getProductFromPage(0);
        WebElement titleOfItem = firstItem.findElement(linkToItemBy);
        setArticulOfItem(clearStringFromChars(firstItem.findElement(articulFromMainPageBy).getText()));
        titleOfItem.click();
    }

    public void setPriceRange() throws InterruptedException {
        WebElement minRangeField = driver.findElement(minRangeBy);
        minRangeField.sendKeys(ConfigProperties.getProperty("minRange"));
        WebElement maxRangeField = driver.findElement(maxRangeBy);
        maxRangeField.sendKeys(ConfigProperties.getProperty("maxRange"));
        Thread.sleep(3000);
        WebElement confirmButton = driver.findElement(applyButtonBy);
        confirmButton.click();

    }

}
