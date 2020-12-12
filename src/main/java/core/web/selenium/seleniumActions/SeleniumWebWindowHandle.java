package core.web.selenium.seleniumActions;

import exceptions.CustomExceptions;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import reports.extent.ReporterUtils;

import java.util.Set;

public class SeleniumWebWindowHandle extends SeleniumBrowser{
    private String parentWindowHandle;
    private Set<String> windowHandles;
    public void switchToNewWindow(WebDriver driver){
        switchToNewWindow(driver,false,null);
    }
    public void switchToNewWindow(WebDriver driver,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage = null;
        try{
            parentWindowHandle = driver.getWindowHandle();
            windowHandles = driver.getWindowHandles();
            for(String windowHandle : windowHandles){
                if(!windowHandle.equals(parentWindowHandle)){
                    driver.switchTo().window(windowHandle);
                    reportMessage = "Switched to new window having title: "+driver.getTitle();
                }
            }
        }
        catch(NoSuchWindowException ex){
            String screenshotPath = getScreenShot(driver,"SwitchToWindowError");
            String errorMessage = "Exception occurred while switching to new window </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"SwitchToWindowError");
            String errorMessage = "Exception occurred while switching to new window </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void switchToDefaultWindow(WebDriver driver){
        switchToDefaultWindow(driver,false,null);
    }
    public void switchToDefaultWindow(WebDriver driver,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage = null;
        try{
            windowHandles = driver.getWindowHandles();
            for(String windowHandle : windowHandles){
                if(windowHandle.equals(parentWindowHandle)){
                    driver.switchTo().window(windowHandle);
                    reportMessage = "Switched to parent window having title: "+driver.getTitle();
                }
            }
            reportMessage = "Switched to parent window having title: "+driver.getTitle();
        }
        catch(NoSuchWindowException ex){
            String screenshotPath = getScreenShot(driver,"SwitchToDefaultWindowError");
            String errorMessage = "Exception occurred while switching to parent window </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"SwitchToDefaultWindowError");
            String errorMessage = "Exception occurred while switching to parent window </p>~=/ExceptionMessage -"+ ex.getMessage();
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