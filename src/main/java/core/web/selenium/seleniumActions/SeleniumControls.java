package core.web.selenium.seleniumActions;

import exceptions.CustomExceptions;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reports.extent.ReporterUtils;
import utils.CustomLogger;


public class SeleniumControls extends SeleniumDropDown {
    public boolean click(WebElement elem){
        return click(elem,false,null,null);
    }
    public boolean click(WebElement elem, boolean takeScreenshot, WebDriver driver,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        try{
            elem.click();
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"CLick");
            String errorMessage = "Exception occurred while click operation <p>elem - "+ locator +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,"Element is clicked <p>elem - "+locator+"</p>",screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,"Element is clicked <p>elem - "+locator+"</p>");
        return true;
    }
    public boolean submit(WebElement elem){
        return submit(elem,false,null,null);
    }
    public boolean submit(WebElement elem,boolean takeScreenshot,WebDriver driver,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        try{
            elem.submit();
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"CLick");
            String errorMessage = "Exception occurred while submit operation <p>elem - "+ locator +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,"Element is submitted <p>elem - "+locator+"</p>",screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,"Element is submitted <p>elem - "+locator+"</p>");
        return true;
    }
    public boolean type(WebElement elem,String value){
        return type(elem,value,false,null,null);
    }
    public boolean type(WebElement elem,String value,boolean takeScreenshot,WebDriver driver,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        try{
            elem.sendKeys(value);
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"Send Keys");
            String errorMessage = "Exception occurred while send keys operation <p>elem - "+locator.toString()+"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,value+" is typed on element <p>elem - "+locator+"</p>",screenshotPath);
        }
        else{
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,value+" is typed on element <p>elem - "+locator+"</p>");
        }
        return true;
    }
    public String getText(WebElement elem){
        return getText(elem,false,null,null);
    }
    public String getText(WebElement elem, boolean takeScreenshot,WebDriver driver,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        String elemText;
        try{
            elemText = elem.getText();
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"CLick");
            String errorMessage = "Exception occurred while getText operation <p>elem - "+ locator +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,"Text is retrieved from element <p>elem - "+locator+"</p> Output - "+elemText,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,"Text is retrieved from element <p>elem - "+locator+"</p> Output - "+elemText);
        return elemText;
    }
}
