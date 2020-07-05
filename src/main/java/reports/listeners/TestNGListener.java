package reports.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import core.web.selenium.seleniumActions.SeleniumBrowser;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import reports.extent.ExtentReporter;


import java.io.IOException;
import java.util.List;

public class TestNGListener extends SeleniumBrowser implements ITestListener {
    ExtentReports report = ExtentReporter.getReporter();
    ExtentTest test;
    public ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();


    @Override
    public void onTestStart(ITestResult result) {
        test = report.createTest(result.getName());
        extentTestThreadLocal.set(test);
        //extentTestThreadLocal.get().log(Status.INFO,"Test Name - "+result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        List<String> reporterMessage = Reporter.getOutput(result);
        for(String report:reporterMessage){
            String[] log = report.split(";");
            if(log.length == 2){
                String status = log[0];
                String message = log[1];
                if(status.equalsIgnoreCase("Pass"))
                    extentTestThreadLocal.get().log(Status.PASS,message);
                else
                    extentTestThreadLocal.get().log(Status.INFO,message);
            }else if(log.length == 3){
                String status = log[0];
                String message = log[1];
                String screenshotPath = log[2];
                if(status.equalsIgnoreCase("Pass")) {
                    try {
                        extentTestThreadLocal.get().log(Status.PASS,message,MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    try {
                        extentTestThreadLocal.get().log(Status.INFO,message,MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        extentTestThreadLocal.get().log(Status.PASS,"Test "+ result.getName()+" Passed");
        /*String methodName = result.getMethod().getMethodName();
        WebDriver driver = null;
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            String screenshotPath = getScreenShot(driver,methodName);
            extentTestThreadLocal.get().info("Screenshot - ", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void onTestFailure(ITestResult result) {
        /*
        String methodName = result.getMethod().getMethodName();
        WebDriver driver = null;

        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }*/
        extentTestThreadLocal.get().log(Status.FAIL,"Test "+ result.getName()+result.getThrowable());
        /*try {
            String screenshotPath = getScreenShot(driver,methodName);
            extentTestThreadLocal.get().addScreenCaptureFromPath(screenshotPath,"Screenshot");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("***Execution completed***");
        report.flush();
    }
}
