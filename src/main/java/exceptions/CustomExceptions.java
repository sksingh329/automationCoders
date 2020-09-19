package exceptions;

import reports.extent.ReporterUtils;

public class CustomExceptions extends RuntimeException{
    public CustomExceptions(){ }
    public CustomExceptions(String methodName,String message){
        ReporterUtils.log(ReporterUtils.Status.FAIL,methodName,message);
    }
    public CustomExceptions(String methodName,String message,String screenshotPath){
        ReporterUtils.logWithScreenshot(ReporterUtils.Status.FAIL,methodName,message,screenshotPath);
    }
}
