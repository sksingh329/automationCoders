package core.web.selenium.seleniumActions;

import exceptions.CustomExceptions;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import reports.extent.ReporterUtils;
import utils.CustomLogger;

import java.util.Arrays;
import java.util.List;

public class SeleniumElements extends SeleniumWait {
    public WebElement getWebElement(WebDriver driver, By locator,boolean takeScreenshot,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage = null;
        WebElement elem = getWebElement(driver,locator);
        String strLocator = getLocator(elem.toString());
        reportMessage = "Element is found with locator "+strLocator;
        if(takeScreenshot){
            String screenshotPath = getScreenShot(elem,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        return elem;
    }
    public WebElement getWebElement(WebDriver driver, By locator){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        WebElement elem;
        try{
            elem = driver.findElement(locator);
        }
        catch (NoSuchElementException ex){
            String screenshotPath = getScreenShot(driver,"ElementNotFound");
            String errorMessage = "Element not found while findElement operation <p>elem - "+locator.toString()+"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"ExceptionOccurred");
            String errorMessage = "Exception occurred while findElement operation <p>elem - "+locator.toString()+"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        return elem;
    }
    public WebElement getWebElement(WebDriver driver,By locator, int timeout){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        WebDriverWait webDriverWait = new WebDriverWait(driver,timeout);
        WebElement elem;
        try{
            elem = webDriverWait.until(driver1 -> driver1.findElement(locator));
        }
        catch (TimeoutException ex){
            String screenshotPath = getScreenShot(driver,"TimeoutException");
            String errorMessage = "Error Message - Element not found while findElement operation within given duration "+timeout+" seconds <p>elem - "+locator.toString()+"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"ExceptionOccurred");
            String errorMessage = "Exception occurred while findElement operation <p>elem - "+locator.toString()+"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        return elem;
    }
    public List<WebElement> getWebElements(WebDriver driver, By locator){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        List<WebElement> elems;
        try{
            elems = driver.findElements(locator);
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"ExceptionOccurred");
            String errorMessage = "Exception occurred while findElement operation <p>elem - "+locator.toString()+"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        return elems;
    }
    //Helper method to extract locator from WebElement string
    public String getLocator(String elemString){
        return elemString.split("->")[1].substring(0,elemString.split("->")[1].length()-1);
    }
}
