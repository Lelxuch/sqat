import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ListenerClass extends ExtentManager implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentManager.extentTest = ExtentManager.extent.createTest(iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        if(iTestResult.getStatus()==ITestResult.SUCCESS){
            ExtentManager.extentTest.log(Status.PASS, "Past Test Case is: "+iTestResult.getName());
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        if(iTestResult.getStatus()==ITestResult.FAILURE){
            ExtentManager.extentTest.log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getName()+"- Test case Failed", ExtentColor.RED));
            ExtentManager.extentTest.log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getThrowable()+"- Test Case Failed",ExtentColor.RED));

            String pathString = BasePage.screenShot(BasePage.driver, iTestResult.getName());
            try {
                ExtentManager.extentTest.addScreenCaptureFromPath(pathString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        if(iTestResult.getStatus()==ITestResult.SKIP){
            ExtentManager.extentTest.log(Status.SKIP, "Skipped Test Case is: "+iTestResult.getName());
        }

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
