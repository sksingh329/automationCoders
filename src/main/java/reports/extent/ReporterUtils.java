package reports.extent;

import org.testng.Reporter;

public class ReporterUtils {
    public enum Status{
        PASS,FAIL,INFO
    }
    public static void log(Status status,String methodName,String message){
        Reporter.log(status.toString()+";"+methodName+";"+message);
    }
    public static void logWithScreenshot(Status status,String methodName,String message,String screenshotPath){
        Reporter.log(status.toString()+";"+methodName+";"+message+";"+screenshotPath);
    }
    public static void setReporter(Status status,String message){
        String reporterStatus = status.toString();
        Reporter.log(reporterStatus+";"+message);
    }
    public static void setReporter(Status status,String message,String screenshotPath){
        String reporterStatus = status.toString();
        Reporter.log(reporterStatus+";"+message+";"+screenshotPath);
    }
}
