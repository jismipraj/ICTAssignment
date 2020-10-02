package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ProductDetailsPage {

    private WebDriver driver;
    //    select dropdwnQty = new select(driver.findElement(By.id("quantity")));
//         private By dropdwnQty=By.id("quantity");
         private By btnAddtoCart=By.id("add-to-cart-button");
         private By btnCart = By.id("nav-cart-count");
         private By txtlocation = By.id("contextualIngressPtLabel_deliveryShortLine");

    //    private By txtdeselectInCart=By.id("deselect-all");


    public ProductDetailsPage(WebDriver driver) {
        this.driver=driver;

    }
    public String checkelement4(){
        String element4 = driver.findElement(txtlocation).getText();
        return element4;
    }
//    public String verifyCartPage(){
//        String deselectText = driver.findElement(txtdeselectInCart).getText();
//        return deselectText;
//    }

    public void QuantitySelection(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select drpcount = new Select (driver.findElement(By.id("quantity")));
        drpcount.selectByValue("3");
 }


    public void AddtoCart() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btnAddtoCart).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btnCart).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

}

