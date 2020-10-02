package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;
    private String helloText;

    private By txtUserName = By.id("ap_email");
    private By txtPassword = By.id("ap_password");
    private By btnContinue = By.id("continue");
    private By txtLogin = By.id("signInSubmit");
    private By btnarrow = By.id("nav-link-accountList");
    private By numCart = By.id("nav-cart-count");
    private By txtHello = By.xpath("//*[@id=\"nav-link-accountList\"]/div/span");
    private By txtError = By.cssSelector("#auth-error-message-box > div > h4");


    public String validateHelloTest() {
        String helloText = driver.findElement(txtHello).getText();
        return helloText;
    }

    public String validateErrormessage() {
        String errorText = driver.findElement(txtError).getText();
        return errorText;
    }


    public LoginPage(WebDriver driver) {
        System.out.print("at logonpage");

        this.driver = driver;
    }

    public void Login(String userName, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btnarrow).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(txtUserName).sendKeys(userName);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btnContinue).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(txtPassword).sendKeys(password);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(txtLogin).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void Invalid(String username2) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btnarrow).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(txtUserName).sendKeys(username2);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btnContinue).click();
    }
}