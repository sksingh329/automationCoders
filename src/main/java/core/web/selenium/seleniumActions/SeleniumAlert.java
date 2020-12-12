package core.web.selenium.seleniumActions;

import exceptions.CustomExceptions;
import org.openqa.selenium.WebDriver;
import reports.extent.ReporterUtils;

public class SeleniumAlert extends SeleniumWebWindowHandle {

    public String getAlertText(WebDriver driver){
        return getAlertText(driver,false,null);
    }
    public String getAlertText(WebDriver driver,boolean takeScreenshot,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage = "";
        String alertText = "";
        try{
            alertText = driver.switchTo().alert().getText();
            reportMessage = "Alert text is "+alertText;
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"getAlertTextError");
            String errorMessage = "Exception occurred while getting text from Alert box ~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else{
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
        }
        return alertText;
    }
    public void acceptAlert(WebDriver driver){
        acceptAlert(driver,false,null);
    }
    public void acceptAlert(WebDriver driver,boolean takeScreenshot,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage = "";
        try{
            driver.switchTo().alert().accept();
            reportMessage = "Alert accepted.";
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"getAlertTextError");
            String errorMessage = "Exception occurred while accepting alert box ~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else{
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
        }
    }
    public void dismissAlert(WebDriver driver){
        dismissAlert(driver,false,null);
    }
    public void dismissAlert(WebDriver driver,boolean takeScreenshot,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage = "";
        try{
            driver.switchTo().alert().dismiss();
            reportMessage = "Alert dismissed.";
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"getAlertTextError");
            String errorMessage = "Exception occurred while dismissing alert box ~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else{
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
        }
    }
    public void sendKeysAlert(WebDriver driver,String value){
        sendKeysAlert(driver,value,false,null);
    }
    public void sendKeysAlert(WebDriver driver,String value,boolean takeScreenshot,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage = "";
        try{
            driver.switchTo().alert().sendKeys(value);
            reportMessage = "Text "+value+" is entered";
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"getAlertTextError");
            String errorMessage = "Exception occurred while typing value in  alert box ~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else{
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
        }
    }

}
