package core.web.selenium.seleniumActions;

import exceptions.CustomExceptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reports.extent.ReporterUtils;

// No dependency on visibility of element
public class SeleniumJSAction extends SeleniumFrame{
    public void jsScrollToElement(WebDriver driver,WebElement elem){
        jsScrollToElement(driver,elem,false,null);
    }
    public void jsScrollToElement(WebDriver driver,WebElement elem,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        String reportMessage = null;
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);",elem);
            reportMessage = "Scrolled to element using javascript<p>elem - "+locator+"</p>";
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"JsScrollToElementError");
            String errorMessage = "Exception occurred while scrolling to element using javascript</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void jsClick(WebDriver driver,WebElement elem){
        jsClick(driver,elem,false,null);
    }
    public void jsClick(WebDriver driver,WebElement elem,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        String reportMessage;
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",elem);
            reportMessage = "Clicked element using javascript<p>elem - "+locator+"</p>";
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"JsClickElementError");
            String errorMessage = "Exception occurred while clicking element using javascript</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void jsSetValueAttribute(WebDriver driver,WebElement elem,String text){
        jsSetValueAttribute(driver,elem,text,false,null);
    }
    public void jsSetValueAttribute(WebDriver driver,WebElement elem,String text,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        String reportMessage;
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='"+text+"'",elem);
            reportMessage = "Set value attribute of element using javascript<p>elem - "+locator+" ,value - "+text+"</p>";
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"JsSetValueAttributeError");
            String errorMessage = "Exception occurred while setting value attribute using javascript</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void jsExecuteCommand(WebDriver driver, WebElement elem, String jsCommand){
        jsExecuteCommand(driver,elem,jsCommand,false,null);
    }
    public void jsExecuteCommand(WebDriver driver,WebElement elem,String jsCommand,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        String reportMessage;
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(jsCommand,elem);
            reportMessage = "Javascript command execution on <p>elem - "+locator+" ,command - "+jsCommand+"</p>";
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"JsExecuteCommandError");
            String errorMessage = "Exception occurred while executing javascript command</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void jsExecuteCommand(WebDriver driver,String jsCommand){
        jsExecuteCommand(driver,jsCommand,false,null);
    }
    public void jsExecuteCommand(WebDriver driver,String jsCommand,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(jsCommand);
            reportMessage = "Javascript command execution <p>command - "+jsCommand+"</p>";
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"JsExecuteCommandError");
            String errorMessage = "Exception occurred while executing javascript command</p>~=/ExceptionMessage -"+ ex.getMessage();
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
