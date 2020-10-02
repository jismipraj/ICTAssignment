import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerTest.class)
public class LoginTest extends Execution {

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
    SearchPage searchPage = new SearchPage(driver);
    CartPage cartPage = new CartPage(driver);


    @Test(priority = 1, description = "Verify Login", dataProvider = "logindata")
    public void validLogin(String Username1, String Password1, String loggedInName) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.validateHelloTest(),"Hello, Sign in","User is on Amazon website" );
        loginPage.Login(Username1,Password1 );
        Assert.assertEquals(loginPage.validateHelloTest(),"Hello, "+loggedInName+"","User name is displayed");

    }
    @Test(priority = 2, description = "Verify Invalid Login", dataProvider = "invalidlogindata")
    public void invalidLogin(String Username2) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Invalid(Username2);
        Assert.assertEquals(loginPage.validateErrormessage(),"There was a problem");
    }

    @Test(priority = 3, description = "Validate Search for item",dataProvider = "itemdata")
    public void searchItem(String itemname) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.Search(itemname);
        Assert.assertEquals(homePage.checkElementPresent(), "Amazon Prime");


    }

    @Test(priority = 4, description = "Verify Product details page",dataProvider = "itemdata")
    public void productPage(String itemname) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.Search(itemname);
        homePage.SelectItem();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        Assert.assertEquals(productDetailsPage.checkelement4(), "Select delivery location");
    }

    @Test(priority = 5, description = "Validate Adding item to cart",dataProvider = "itemdata")
    public void addingItemsToCart(String itemname) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.Search(itemname);
        String winHandleBefore = driver.getWindowHandle();
        homePage.SelectItem();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.QuantitySelection();
        productDetailsPage.AddtoCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.cartCount(),"3");

    }

    @Test(priority = 6, description = "Remove Item from cart",dataProvider = "itemdata")
    public void removingItemsFromCart(String itemname) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.Search(itemname);
        String winHandleBefore = driver.getWindowHandle();
        homePage.SelectItem();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.AddtoCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.CartOpertion();
       // driver.switchTo().window(winHandleBefore);
        Assert.assertEquals(cartPage.cartemptymessage(), "Your Amazon Basket is empty");

    }

    @Test(priority = 7, description = "Verify pincode works",dataProvider = "pincode")
    public void pincodeWorks(String pin, String Place) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.SelectPincode(pin);
        System.out.println("fjfcjfjfcjgjjjjjjjjjjjjjjjj    "+homePage.checkelement7());
        Assert.assertEquals(homePage.checkelement7(), ""+Place+" "+pin+"");

    }

    @Test(priority = 8, description = "Verify Invalid picode works",dataProvider = "wrongpincode")
    public void InvalidpincodeWorks(String wrongPin) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.SelectPincode(wrongPin);
        Assert.assertEquals(homePage.checkElement8(), "Please enter a valid pincode");

    }

    @Test(priority = 9, description = "Add new Address", dataProvider = "newAddressData")
    public void addNewAddress(String username, String password, String fullname, String phone, String pin, String house) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.Login(username,password);
        homePage.SelectAddress(fullname,phone,pin,house);
        Assert.assertEquals(homePage.checkElement9(), "Address saved");
    }


    @Test(priority = 10, description = "Change Password",dataProvider = "resetpasswordData")
    public void changePassword(String Username, String Password, String Newpassword) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.Login(Username, Password);
        homePage.ResetPassword(Password, Newpassword, Newpassword);
        Assert.assertEquals(homePage.checkelement10(),"Success");


    }

    @Test(priority = 11, description = "Items Sorting")
    public void sortItems() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.Sorting("mouse");

    }

    @Test(priority = 12, description = "Verify naviagtion to product detail page")
    public void Hamburgeractivity() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.Hamburger();
        Assert.assertEquals(searchPage.elementcheck12(),"Show results for");



    }

    @Test(priority = 13, description = "Save for later",dataProvider = "itemdata")
    public void saveItemsfromCart(String item) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.Search(item);
        homePage.SelectItem();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.AddtoCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.SaveItem();
        Assert.assertEquals(cartPage.saveitems(),"Saved for later (1 item)");



    }

    @Test(priority = 14, description = "Verify footer elements")
    public void checkfooter() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.Footer();
        Assert.assertEquals(searchPage.checkAboutUs(),"Get the latest news in your inbox", "page is not loaded yet");

    }

}
