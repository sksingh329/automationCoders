package reports.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import reports.extent.ExtentReporter;


import java.io.IOException;
import java.util.List;

public class TestNGListener implements ITestListener {
    ExtentReports report = ExtentReporter.getReporter();
    ExtentTest test;
    public ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = report.createTest(result.getName());
        extentTestThreadLocal.set(test);
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        List<String> reporterMessage = Reporter.getOutput(result);
        for(String report:reporterMessage){
            String[] log = report.split(";");
            String screenshotPath = null;
            boolean takeScreenshot = false;
            String status = log[0];
            String methodName = "Method - "+log[1];
            String message = "Step - "+log[2];
            //Initialise screenshot variable if argument passed for screenshot
            if(log.length == 4) {
                takeScreenshot = true;
                screenshotPath = log[3];
            }
            //Log Pass status in extent report
            if(status.equalsIgnoreCase("Pass")){
                if(takeScreenshot) {
                    try {
                        extentTestThreadLocal.get().log(Status.PASS,methodName+"</br>"+message+"</br>Screenshot - ",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else
                    extentTestThreadLocal.get().log(Status.PASS,methodName+"</br>"+message);
            }
            //Log Info status in extent report - Info is default status assumed
            else{
                if(takeScreenshot){
                    try {
                        extentTestThreadLocal.get().log(Status.INFO,methodName+"</br>"+message+"</br>Screenshot - ",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else
                    extentTestThreadLocal.get().log(Status.INFO,methodName+"</br>"+message);
            }
        }
        extentTestThreadLocal.get().log(Status.PASS,"Test "+ result.getName()+" Passed.");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        List<String> reporterMessage = Reporter.getOutput(result);
        for(String report:reporterMessage){
            String[] log = report.split(";");
            if(log.length == 3){
                String status = log[0];
                String methodName = "Method - "+log[1];
                String message = "Step - "+log[2];
                if(status.equalsIgnoreCase("Pass"))
                    extentTestThreadLocal.get().log(Status.PASS,methodName+"</br>"+message);
                else if(status.equalsIgnoreCase("Fail")){
                    extentTestThreadLocal.get().log(Status.FAIL,methodName+"</br>"+message);
                }

                else if(status.equalsIgnoreCase("Info"))
                    extentTestThreadLocal.get().log(Status.INFO,methodName+"</br>"+message);
            }else if(log.length == 4){
                String status = log[0];
                String methodName = "Method - "+log[1];
                String message = "Step - "+log[2];
                String screenshotPath = log[3];
                String exceptionMessage = null;
                if(message.contains("~=/ExceptionMessage -")){
                    String[] message1 = message.split("~=/ExceptionMessage -");
                    message = message1[0];
                    exceptionMessage = message1[1];
                }
                try {
                        if(status.equalsIgnoreCase("Pass"))
                            extentTestThreadLocal.get().log(Status.PASS,methodName+"</br>"+message+"</br>Screenshot - ",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                        else if(status.equalsIgnoreCase("Fail")){
                            if(!exceptionMessage.isEmpty())
                                extentTestThreadLocal.get().log(Status.FAIL,methodName+"</br>"+message+"</br>Screenshot - ",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()).error(exceptionMessage).error(result.getThrowable());
                            else
                                extentTestThreadLocal.get().log(Status.FAIL,methodName+"</br>"+message+"</br>Screenshot - ",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()).error(result.getThrowable());
                        }
                        else if(status.equalsIgnoreCase("Info"))
                            extentTestThreadLocal.get().log(Status.INFO,methodName+"</br>"+message+"</br>Screenshot - ",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
        extentTestThreadLocal.get().log(Status.FAIL,"Test "+ result.getName()+" Failed.");
    }
    @Override
    public void onFinish(ITestContext context) {
        report.flush();
    }
}