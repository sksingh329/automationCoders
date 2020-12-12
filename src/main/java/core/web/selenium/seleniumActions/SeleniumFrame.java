package core.web.selenium.seleniumActions;

import exceptions.CustomExceptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reports.extent.ReporterUtils;

/*
    Motive - Class to handle frames on web page
 */
public class SeleniumFrame extends SeleniumWebUIAction{
    public void switchToFrameUsingIndex(WebDriver driver, int index){
        switchToFrameUsingIndex(driver,index,false,null);
    }
    public void switchToFrameUsingIndex(WebDriver driver, int index, boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage = null;
        try{
            driver.switchTo().frame(index);
            reportMessage = "Switched to frame using index "+index;
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"SwitchToFrameError");
            String errorMessage = "Exception occurred while switching to frame using index"+ index +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void switchToFrameUsingNameOrId(WebDriver driver, String nameOrId){
        switchToFrameUsingNameOrId(driver,nameOrId,false,null);
    }
    public void switchToFrameUsingNameOrId(WebDriver driver, String nameOrId, boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage = null;
        try{
            driver.switchTo().frame(nameOrId);
            reportMessage = "Switched to frame using name or id "+nameOrId;
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"SwitchToFrameError");
            String errorMessage = "Exception occurred while switching to frame using name or id"+ nameOrId +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void switchToFrameUsingWebElement(WebDriver driver, WebElement elem){
        switchToFrameUsingWebElement(driver,elem,false,null);
    }
    public void switchToFrameUsingWebElement(WebDriver driver, WebElement elem, boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        String reportMessage = null;
        try{
            driver.switchTo().frame(elem);
            reportMessage = "Switched to frame using Web element <p>elem - "+locator+"</p>";
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"SwitchToFrameError");
            String errorMessage = "Exception occurred while switching to frame using web element <p>elem -"+ locator +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void switchToParentFrame(WebDriver driver){
        switchToParentFrame(driver,false,null);
    }
    public void switchToParentFrame(WebDriver driver, boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        try{
            driver.switchTo().parentFrame();
            reportMessage = "Switched to parent frame";
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"SwitchToParentFrameError");
            String errorMessage = "Exception occurred while switching to parent frame -</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void switchToDefaultFrame(WebDriver driver){
        switchToDefaultFrame(driver,false,null);
    }
    public void switchToDefaultFrame(WebDriver driver, boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        try{
            driver.switchTo().defaultContent();
            reportMessage = "Switched to default frame";
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"SwitchToDefaultFrameError");
            String errorMessage = "Exception occurred while switching to default frame -</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
}
