package core.web.selenium.seleniumActions;

import exceptions.CustomExceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.extent.ReporterUtils;

public class SeleniumWait extends SeleniumAlert{
    private final int WAIT_SLEEP_TIME_IN_SECONDS = 100;
    public enum AlertPresentWaitConditions{
        alertIsPresent
    }
    public enum ElementVisibilityWaitConditions{
        elementToBeClickable, elementToBeSelected,
        presenceOfElementLocated, visibilityOfElementLocated, invisibilityOfTheElementLocated
    }
    public enum ElementTextWaitConditions{
        textToBePresentInElementLocated, textToBePresentInElementValue,
        invisibilityOfElementWithText
    }
    public enum TitleWaitConditions{
        titleIs, titleContains
    }
    public enum NumberOfElementsAndWindowsConditions{
        numberOfElementsToBeMoreThan, numberOfElementsToBeLessThan,
        numberOfElementsToBe,numberOfWindowsToBe
    }
    public void explicitWaitForAlertPresence(WebDriver driver,AlertPresentWaitConditions conditions){
        explicitWaitForAlertPresence(driver,conditions,WAIT_SLEEP_TIME_IN_SECONDS);
    }
    public void explicitWaitForAlertPresence(WebDriver driver,AlertPresentWaitConditions conditions,int timeout){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver,timeout);
            switch (conditions){
                case alertIsPresent:
                    webDriverWait.until(ExpectedConditions.alertIsPresent());
                    reportMessage = "Waited for alert to be present";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + conditions);
            } 
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"ExplicitWaitForAlertPresenceError");
            String errorMessage = "Exception occurred while waiting for alert to be present</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void explicitWaitForElementVisibility(WebDriver driver, By locator,ElementVisibilityWaitConditions conditions){
        explicitWaitForElementVisibility(driver,locator,conditions,WAIT_SLEEP_TIME_IN_SECONDS);
    }
    public void explicitWaitForElementVisibility(WebDriver driver, By locator,ElementVisibilityWaitConditions conditions,int timeout){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver,timeout);
            switch (conditions){
                case elementToBeClickable:
                    webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
                    reportMessage = "Waited for element to be clickable <p> elem "+locator+"</p>";
                    break;
                case elementToBeSelected:
                    webDriverWait.until(ExpectedConditions.elementToBeSelected(locator));
                    reportMessage = "Waited for element to be selected <p> elem "+locator+"</p>";
                    break;
                case presenceOfElementLocated:
                    webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
                    reportMessage = "Waited for element to be present <p> elem "+locator+"</p>";
                    break;
                case visibilityOfElementLocated:
                    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                    reportMessage = "Waited for element to be visible  <p> elem "+locator+"</p>";
                    break;
                case invisibilityOfTheElementLocated:
                    webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
                    reportMessage = "Waited for element to be invisible <p> elem "+locator+"</p>";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + conditions);
            }
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"ExplicitWaitForElementVisibilityError");
            String errorMessage = "Exception occurred while checking element visibility</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void explicitWaitForElementText(WebDriver driver, By locator, String text,ElementTextWaitConditions conditions){
        explicitWaitForElementText(driver, locator, text, conditions,WAIT_SLEEP_TIME_IN_SECONDS);
    }
    public void explicitWaitForElementText(WebDriver driver, By locator, String text,ElementTextWaitConditions conditions,int timeout){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver,timeout);
            switch (conditions){
                case textToBePresentInElementLocated:
                    webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
                    reportMessage = "Waited for text "+text+" in element <p> elem "+locator+"</p>";
                    break;
                case textToBePresentInElementValue:
                    webDriverWait.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
                    reportMessage = "Waited for text "+text+" present in element value <p> elem "+locator+"</p>";
                    break;
                case invisibilityOfElementWithText:
                    webDriverWait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
                    reportMessage = "Waited for invisibility of text "+text+" in element <p> elem "+locator+"</p>";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + conditions);
            }
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"ExplicitWaitForElementTextError");
            String errorMessage = "Exception occurred while checking text in element </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void explicitWaitForTitle(WebDriver driver, TitleWaitConditions conditions, String title){
        explicitWaitForTitle(driver,conditions,title,WAIT_SLEEP_TIME_IN_SECONDS);
    }
    public void explicitWaitForTitle(WebDriver driver, TitleWaitConditions conditions, String title, int timeout) {
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
            switch(conditions){
                case titleIs:
                    webDriverWait.until(ExpectedConditions.titleIs(title));
                    reportMessage = "Waited for title to be "+title;
                    break;
                case titleContains:
                    webDriverWait.until(ExpectedConditions.titleContains(title));
                    reportMessage = "Waited for title contains "+title;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + conditions);
            }
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"ExplicitWaitForTitleError");
            String errorMessage = "Exception occurred while waiting for title </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void explicitWaitForNumberOfElementsAndWindows(WebDriver driver, By locator, NumberOfElementsAndWindowsConditions conditions, int expectedCount) {
        explicitWaitForNumberOfElementsAndWindows(driver, locator, conditions, expectedCount,WAIT_SLEEP_TIME_IN_SECONDS);
    }
    public void explicitWaitForNumberOfElementsAndWindows(WebDriver driver, By locator, NumberOfElementsAndWindowsConditions conditions, int expectedCount, int timeout) {
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
            switch (conditions){
                case numberOfElementsToBe:
                    webDriverWait.until(ExpectedConditions.numberOfElementsToBe(locator,expectedCount));
                    reportMessage = "Waited for element count to be "+expectedCount+"<p> for elem - "+locator+"</p>";
                    break;
                case numberOfElementsToBeMoreThan:
                    webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator,expectedCount));
                    reportMessage = "Waited for element count to be more than "+expectedCount+"<p> for elem - "+locator+"</p>";
                    break;
                case numberOfElementsToBeLessThan:
                    webDriverWait.until(ExpectedConditions.numberOfElementsToBeLessThan(locator,expectedCount));
                    reportMessage = "Waited for element count to be less than "+expectedCount+"<p> for elem - "+locator+"</p>";
                    break;
                case numberOfWindowsToBe:
                    webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(expectedCount));
                    reportMessage = "Waited for windows count to be "+expectedCount;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + conditions);
            }
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"ExplicitWaitForNumberOfElementsAndWindowsError");
            String errorMessage = "Exception occurred while waiting for number of element and window </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
}
