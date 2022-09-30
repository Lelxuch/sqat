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

    private By priceAsc = By.xpath("//a[@data-value='price-asc']");
    private By priceDesc = By.xpath("//a[@data-value='price-desc']");
    public String articulOfItem = null;

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
    public void clickToFirstItemOnPage(){
        WebElement firstItem = driver.findElements(itemOnPageBy).get(0);
        WebElement titleOfItem = firstItem.findElement(linkToItemBy);
        String href = titleOfItem.getAttribute("href");
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
