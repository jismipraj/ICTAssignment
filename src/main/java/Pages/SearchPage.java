package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SearchPage {

    private WebDriver driver;
    private By barsearch = By.id("twotabsearchtextbox");
    private By dropdwnSort = By.id("a-autoid-0-announce");
    private By hightoLow = By.id("s-result-sort-select_2");

    private By btnHamburger = By.id("nav-hamburger-menu");
    private By category1 = By.cssSelector("#hmenu-content > ul.hmenu.hmenu-visible > li:nth-child(9) > a");
    private By subcategory = By.cssSelector("#hmenu-content > ul.hmenu.hmenu-visible.hmenu-translateX > li:nth-child(17) > a");
    private  By elecase12 = By.cssSelector("#leftNav > h3.a-size-medium.a-spacing-base.a-spacing-top-small.a-color-tertiary.a-text-normal");


//footer activities in search page
    private By btnAboutUs = By.cssSelector("#navFooter > div.navFooterVerticalColumn.navAccessibility > div > div:nth-child(1) > ul > li.nav_first > a");
    private By assertAboutUs =By.linkText("Get the latest news in your inbox");



    public SearchPage(WebDriver driver) {

        this.driver = driver;
    }

    public String checkAboutUs() {
        String aboutUs = driver.findElement(assertAboutUs).getText();
        return aboutUs;
    }
    public String elementcheck12(){
        String testcase = driver.findElement(elecase12).getText();
        return  testcase;
    }

    public void Sorting(String item) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(barsearch).sendKeys(item+ Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(dropdwnSort).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(hightoLow).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    public void Hamburger() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(btnHamburger).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(category1).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(subcategory).click();
    }


    public void Footer() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(btnAboutUs).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


}
