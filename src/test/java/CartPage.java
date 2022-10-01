import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigProperties;

public class CartPage {
    protected WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    private By cartLinkBy = By.xpath("//a[@href='/personal/basket/']");
    private By addItem1ToCartBy = By.id("bx_117848907_1303739_add_basket_link");
    private By addToCartBy = By.xpath("//a[@tabindex='0']");
    private By deleteItemBy = By.xpath("//button[@onClick=\"itemBasketDelete(this);\"]");
    private By incrementBy = By.xpath("//button[@onClick=\"changeCount(this, 'plus', 1, 6);\"]");
    private By addedToCartBy = By.xpath("//a[contains(text(), 'В корзине')]");
    private By emptyCartBy = By.xpath("//p[contains(text(), 'Ваша корзина пуста')]");
    private By itemNameBy = By.xpath("//a[contains(text(), 'Ноутбук ASUS VivoBook Pro 16X M7600QC, OLED (90NB0V81-M01630)')]");

    public void openCart(){
        driver.findElement(cartLinkBy).click();
    }

    public void deleteItemFromCart(){
        openCart();
        driver.findElement(deleteItemBy).click();
    }

    public void addItemToCart(){
        driver.findElement(addItem1ToCartBy).click();
    }

    public boolean isCartEmpty(){
        driver.get(ConfigProperties.getProperty("cartURL"));
        return driver.findElement(emptyCartBy).isDisplayed();
    }

    public String getItemNameFromCart() {
        driver.get(ConfigProperties.getProperty("cartURL"));
        WebElement itemName = driver.findElement(itemNameBy);
        return itemName.getText();
    }
}
