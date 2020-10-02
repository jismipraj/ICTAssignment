package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    private By txtsearch = By.id("twotabsearchtextbox");
    private By txtamazonPrime = By.cssSelector("#p_85-title > span");
    private By txtquqantity = By.className("a-native-dropdown");
    private By txtaddress = By.id("glow-ingress-line2");
    private By txtpincode = By.id("GLUXZipUpdateInput");
    private By btnapplyPin = By.cssSelector("#GLUXZipUpdate > span > input");
    private By linknaddAddress = By.linkText("Add an address or pick-up point");
    private By addAdressColoumn = By.id("ya-myab-plus-address-icon");
    private By txtrepassword = By.cssSelector("#ap_password");
    private By txtFullName = By.id("address-ui-widgets-enterAddressFullName");
    private By txtfullname = By.id("address-ui-widgets-enterAddressFullName");
    private By txtnewPhoneNumber = By.id("address-ui-widgets-enterAddressPhoneNumber");
    private By txtnewaddress = By.id("address-ui-widgets-enterAddressPhoneNumber");
    private By txtnewpincode = By.xpath("//*[@id=\"address-ui-widgets-enterAddressPostalCode\"]");
    private By txtnewHousename = By.id("address-ui-widgets-enterAddressLine1");
    private By txtArea = By.id("address-ui-widgets-enterAddressLine2");
    private By txtlandmark = By.cssSelector("#address-ui-widgets-landmark");
    private By txtcity = By.id("address-ui-widgets-enterAddressCity");
    private By dropdwnstate = By.cssSelector("#address-ui-widgets-enterAddressStateOrRegion > span > span");
    private By dropdownAddresstype = By.cssSelector("#address-ui-widgets-addr-details-address-type-and-business-hours > span > span");
    private By btnAddAddress = By.cssSelector("#address-ui-widgets-form-submit-button > span > input");
    private By txtelementadd = By.className("a-alert-heading");
//    10th testcase
    private By btnSignIn = By.cssSelector("#nav-link-accountList > span.nav-line-2.nav-long-width");
    private By btnLoginsecurity = By.cssSelector("#a-page > div.a-container > div > div:nth-child(2) > div:nth-child(2) > a > div > div > div > div.a-column.a-span9.a-span-last > h2");
    private By btneditpwd = By.id("auth-cnep-edit-password-button");
//    private By repassword =By.cssSelector("#ap_password");
    private By oldpassword =By.cssSelector("#ap_password");
    private By newpaswd = By.cssSelector("#ap_password_new");
    private By confirmpaswd = By.cssSelector("#ap_password_new_check");
    private By savechanges = By.id("cnep_1D_submit_button");
    private By givepassword = By.id("authportal-main-section");
    private By eleitem = By.linkText("Logitech M235 Wireless Mouse for Windows and Mac with 2.4 GHz Wireless Technology - Black/Grey");
    private By elepasswordchange = By.className("a-alert-heading");
    private By elepincode = By.xpath("//span(@id=\\\"glow-ingress-line2\\\")");
    private By errorpincode = By.xpath("//*[@id=\"GLUXZipError\"]/div/div/div");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String checkElementPresent() {
        String amazonText = driver.findElement(txtamazonPrime).getText();
        return amazonText;
    }
    public String checkElement8() {
    String errormsg = driver.findElement(errorpincode).getText();
    return errormsg;
    }
    public String checkElement9() {
        String addaddr = driver.findElement(txtelementadd).getText();
        return addaddr;
    }
    public String checkelement10() {
        String successText = driver.findElement(elepasswordchange).getText();
        return successText;
    }
    public String checkelement7() {
        String pincode = driver.findElement(elepincode).getText();
        return pincode;
    }


    public void Search(String item) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(txtsearch).sendKeys(item + Keys.ENTER);
//        driver.findElement(btnsearch).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        System.out.println("at homepage");


    }

    public void SelectItem() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(eleitem).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        for(String winHandle : driver.getWindowHandles()) {
            System.out.println( "number"+winHandle);
            driver.switchTo().window(winHandle);
        }


    }

    public void SelectPincode(String code) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(txtaddress).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(txtpincode).sendKeys(code);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btnapplyPin).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void SelectAddress(String fullName, String mobileNumber, String secondPinCode, String houseName) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(txtaddress).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(linknaddAddress).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//      driver.findElement(txtrepassword).sendKeys(password + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(addAdressColoumn).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(txtFullName).sendKeys(fullName);
        driver.findElement(txtnewPhoneNumber).sendKeys(mobileNumber);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(txtnewpincode).sendKeys(secondPinCode);
        driver.findElement(txtnewHousename).sendKeys(houseName);
//        driver.findElement(txtArea).sendKeys(area);
//        driver.findElement(txtlandmark).sendKeys(landmark);
////        driver.findElement(txtcity).sendKeys();
//        Select state = new Select(driver.findElement(dropdwnstate));
//        state.selectByValue("KERALA");
//        Select addressType = new Select(driver.findElement(dropdownAddresstype));
//        addressType.selectByValue("Home (7 am – 9 pm delivery)");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btnAddAddress).click();

    }

    public void ResetPassword ( String currentpassword, String newpassword, String confirmnewpassword)  throws InterruptedException  {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btnSignIn).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btnLoginsecurity).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btneditpwd).click();
//        driver.findElement(givepassword).sendKeys(password+ Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(oldpassword).sendKeys(currentpassword);
        driver.findElement(newpaswd).sendKeys(newpassword);
        driver.findElement(confirmpaswd).sendKeys(confirmnewpassword);
        driver.findElement(savechanges).click();




    }

}

