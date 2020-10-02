package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CartPage {
    private WebDriver driver;
//    private By btndelete = By.xpath("//input[@value=\"Delete\"]");
    private By btndelete = By.xpath("//input[@data-action=\"delete\"]");
    //*[@id="sc-item-Cf073e9be-d80c-4e98-a557-86f5d41080c9"]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[2]
//    private By txtcartDeleteMeassge = By.className("a-spacing-mini a-spacing-top-base");
    private By btnSavelater = By.xpath("//input[@data-action=\"save-for-later\"]");
    private By numCart = By.xpath("//*[@id=\"nav-cart-count\"]");
    //private By textsaved = By.linkText("Saved for later (1 item)");
    private By cartempty = By.className("a-row sc-your-amazon-cart-is-empty");
    private By textsaved = By.id("sc-saved-cart-list-caption-text");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

//    public String verifyCartIsEmpty() {
//        String cartemptyMessage = driver.findElement(txtcartDeleteMeassge).getText();
//        return cartemptyMessage;
//
//    }
    public String cartCount() {
        String cartCountNumber = driver.findElement(numCart).getText();
        return cartCountNumber;
    }
    public String saveitems(){
        String saveditems = driver.findElement(textsaved).getText();
        return saveditems;
    }
    public String cartemptymessage() {
        String cartemptytxt = driver.findElement(cartempty).getText();
        return cartemptytxt;
    }

    public void CartOpertion() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btndelete).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void SaveItem() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btnSavelater).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

}




