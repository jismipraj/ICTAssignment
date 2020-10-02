

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListenerTest implements ITestListener {
    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println(iTestResult.getName()+" test case started");
    }
    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("The name of the testcase passed is :"+iTestResult.getName());

    }
    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("The name of the testcase failed is :"+iTestResult.getName());

    }


    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("The name of the testcase Skipped is :"+iTestResult.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {


    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
