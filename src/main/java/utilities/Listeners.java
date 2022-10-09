package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {

    public void onStart(ITestContext execution) {
        System.out.println("onStart method started");
    }

    public void onFinish(ITestContext execution) {
        System.out.println("----------onFinish method finished----------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("-----Method failed with certain success percentage " + result.getName() + "----");
    }


    public void onTestFailure(ITestResult result) {
        System.out.println("-----Method failed " + result.getName() + "------");
        if (!platform.equalsIgnoreCase("api")) {


            //Stop Recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveScreenShot();
        }
    }


    public void onTestSkipped(ITestResult result) {
        System.out.println("-----Method skipped " + result.getName() + "-----");
    }


    public void onTestStart(ITestResult result) {
        System.out.println("-----Method started " + result.getName() + "-----");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("-----Method passed " + result.getName() + "-----");

        if (!platform.equalsIgnoreCase("api")) {

            //Stop Recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Delete Recorded File
            File file = new File("./test-recordings/" + result.getName() + ".avi");
            if (file.delete())
                System.out.println("File Deleted Successfully");
            else
                System.out.println("Failed to delete video");
        }
    }

    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public byte[] saveScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
