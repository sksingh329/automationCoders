package reports.extent;

import org.testng.Reporter;

public class CustomReporter {
    public enum Status{
        PASS,FAIL,INFO;
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
