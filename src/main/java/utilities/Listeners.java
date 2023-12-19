package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {

    /*
       Method Name:onStart
       Method Description: method running  when starting execution(befor class tests start)
    */

    public void onStart(ITestContext execution) {

        System.out.println("---------------------- Starting Execution ------------------");
    }
      /*
       Method Name:onFinish
       Method Description: method running when ending execution(all test case in class finish)
    */

    public void onFinish(ITestContext execution) {
        System.out.println("---------------------- Ending Execution ------------------");
    }

    /*
     Method Name:onTestStart
     Method Description: method running when test case start
     */
    public void onTestStart(ITestResult test) {
        System.out.println("---------------------- Test: " + test.getName() + " Started ------------------");
        if (!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(test.getName());
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }

    /*
    Method Name:onTestSuccess
    Method Description: method running when test case passes successfully
    */
    public void onTestSuccess(ITestResult test) {
        System.out.println("---------------------- Test: " + test.getName() + " Passed ------------------");
        if (!platform.equalsIgnoreCase("api")) {

            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }

            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if (file.delete()) {
                System.out.println("Recorded Screen Cast File Deleted Successfully");
            } else {
                System.out.println("Failed to Delete the Recorded Screen Cast File");
            }
        }

    }
    /*
    Method Name:onTestFailure
    Method Description: method running when test case failed
    */

    public void onTestFailure(ITestResult test) {
        System.out.println("---------------------- Test " + test.getName() + " Failed ------------------");
        if (!platform.equalsIgnoreCase("api")) {
            attachScreenshot();

            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
    }

    /*
      Method Name:onTestSkipped
      Method Description: method running when test case skipped
    */
    public void onTestSkipped(ITestResult test) {
        System.out.println("----------------------  Test " + test.getName() + " Skipping ------------------");
        // TODO Auto-generated method stub
    }

    /*
          Method Name:attachScreenshot
          Method Description: method capturing a screenshot
        */
    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        System.out.println("Capturing a screenshot...");
        if (!platform.equalsIgnoreCase("mobile"))
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        else
            return ((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.BYTES);

    }
}
