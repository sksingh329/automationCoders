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


public class SeleniumElements extends SeleniumAlert {
    private final int WAIT_SLEEP_TIME_IN_MILLIS = 100;

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
    public WebElement getWebElementAfterVisible(WebDriver driver,By locator, int durationInSeconds){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        WebDriverWait webDriverWait = new WebDriverWait(driver,durationInSeconds);
        WebElement elem;
        try{
            elem = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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
    //Helper method to extract locator from WebElement string
    public String getLocator(String elemString){
        return elemString.split("->")[1].substring(0,elemString.split("->")[1].length()-1);
    }
}
