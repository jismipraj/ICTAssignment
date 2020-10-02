import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Execution {

    ExtentReports reports;
    ExtentSparkReporter extentSparkReporter;
    ExtentTest extentTest;
    public static WebDriver driver = null;

    @BeforeMethod
    public void LoginTests() throws IOException {

        String path=System.getProperty("user.dir");
        System.out.println(path);
        File file = new File(path+"\\Data.properties");
        FileInputStream fileInput = null;
        fileInput = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fileInput);
        String url=prop.getProperty("URL");
        String browser = prop.getProperty("BROWSER");
        driver = Driver.openBrowser(browser,url);
    }

    @BeforeClass
    public void createExtentReport() throws UnknownHostException {
        System.out.print("at beforeclass");

        String path = System.getProperty("user.dir");
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        reports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(path + "\\report\\report_" + timeStamp + ".html");
        reports.setSystemInfo("Machine Name", InetAddress.getLocalHost().getHostName());
        reports.attachReporter(extentSparkReporter);
    }


    @AfterMethod
    public void screen(Method method) throws IOException, InterruptedException {
        System.out.print("at aftermethod");

        //extentTest=reports.createTest(getClass().getSimpleName() );
        extentTest = reports.createTest(method.getAnnotation(Test.class).description());


        //  extentTest=reports.createTest(this.getClass().getAnnotation(Test.class).testName());
        extentTest.log(Status.PASS, "Passed");
        extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());
        reports.flush();
        Driver.closeBrowser();
    }
    @AfterClass
    public void closeBrowsers() {
        driver.quit();
    }


    @DataProvider(name = "logindata")
    public Object[][] gettestdata1() {
        String[][] data = {
                {"amazontest.jismi@gmail.com", "password123", "Amazon1"},
        };
        return data;
    }

    @DataProvider(name = "invalidlogindata")
    public Object[][] gettestdata2() {
        String[][] data = {
                {"username", "password123"},
        };
        return data;
    }

    @DataProvider(name = "newAddressData")
    public Object[][] gettestdata3() {
        String[][] data = {
                {"amazontest.jismi@gmail.com", "password123", "Jismi", "9747453989", "683574", "45B/110"},
        };
        return data;
    }

    @DataProvider(name = "resetpasswordData")
    public Object[][] gettestdata4() {
        String[][] data = {
                {"amazontest.jismi@gmail.com", "password123", "password123amazon"},
        };
        return data;
    }

    @DataProvider(name = "itemdata")
    public Object[][] gettestdata5() {
        String[][] data = {
                {"mouse"},
        };
        return data;
    }

    @DataProvider(name = "pincode")
    public Object[][] gettestdata6() {
        String[][] data = {
                {"683574", "Chowwara"},
        };
        return data;
    }

    @DataProvider(name = "wrongpincode")
    public Object[][] gettestdata7() {
        String[][] data = {
                {"680000"},
        };
        return data;
    }

}