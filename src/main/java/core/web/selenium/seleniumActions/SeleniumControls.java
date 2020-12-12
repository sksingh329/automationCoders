package core.web.selenium.seleniumActions;

import exceptions.CustomExceptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reports.extent.ReporterUtils;

public class SeleniumControls extends SeleniumJSAction {
    public boolean click(WebElement elem,WebDriver driver){
        return click(elem,driver,false,null);
    }
    public boolean click(WebElement elem, WebDriver driver, boolean takeScreenshot,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        String reportMessage = null;
        try{
            elem.click();
            reportMessage = "Element is clicked <p>elem - "+locator+"</p>";
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"ClickError");
            String errorMessage = "Exception occurred while click operation <p>elem - "+ locator +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
        return true;
    }
    public boolean submit(WebElement elem,WebDriver driver){
        return submit(elem,driver,false,null);
    }
    public boolean submit(WebElement elem,WebDriver driver,boolean takeScreenshot,String screenshotName){
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
    public boolean type(WebElement elem,String value,WebDriver driver){
        return type(elem,value,driver,false,null);
    }
    public boolean type(WebElement elem,String value,WebDriver driver,boolean takeScreenshot,String screenshotName){
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
    public String getText(WebElement elem,WebDriver driver){
        return getText(elem,driver,false,null);
    }
    public String getText(WebElement elem, WebDriver driver, boolean takeScreenshot,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        String elemText;
        try{
            elemText = elem.getText();
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"Click");
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
    public String getAttributeValue(WebElement elem,String attributeName,WebDriver driver){
        return getAttributeValue(elem,attributeName,driver,false,null);
    }
    public String getAttributeValue(WebElement elem,String attributeName,WebDriver driver,boolean takeScreenshot,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        String attributeValue;
        try{
            attributeValue = elem.getAttribute(attributeName);
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"Click");
            String errorMessage = "Exception occurred while getText operation <p>elem - "+ locator +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,"Value is retrieved from element <p>elem - "+locator+" for attribute - "+attributeName+"</p> Output - "+attributeValue,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,"Value is retrieved from element <p>elem - "+locator+" for attribute - "+attributeName+"</p> Output - "+attributeValue);
        return attributeValue;
    }
    public boolean isEnabled(WebElement elem,WebDriver driver){
        return isEnabled(elem,driver,false,null);
    }
    public boolean isEnabled(WebElement elem,WebDriver driver,boolean takeScreenshot,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        boolean isElemEnabled = false;
        try{
            isElemEnabled = elem.isEnabled();
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"isEnabledCheckException");
            String errorMessage = "Exception occurred while checking if element is Enabled <p>elem - "+ locator +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,"Is element enabled? <p>elem - "+locator+"</p> Output - "+isElemEnabled,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,"Is element enabled? <p>elem - "+locator+"</p> Output - "+isElemEnabled);
        return isElemEnabled;
    }
    public boolean isDisplayed(WebElement elem,WebDriver driver){return isDisplayed(elem, driver);}
    public boolean isDisplayed(WebElement elem,WebDriver driver,boolean takeScreenshot,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        boolean isElemDisplayed = false;
        String actionLog = "Is element displayed? <p>elem - "+locator+"</p> Output - ";
        try{
            isElemDisplayed = elem.isDisplayed();
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"isDisplayedCheckException");
            String errorMessage = "Exception occurred while checking if element is Displayed <p>elem - "+ locator +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,actionLog+isElemDisplayed,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,actionLog+isElemDisplayed);
        return isElemDisplayed;
    }
    public boolean isSelected(WebElement elem,WebDriver driver){
        return isSelected(elem,driver,false,null);
    }
    public boolean isSelected(WebElement elem,WebDriver driver,boolean takeScreenshot,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        boolean isElemSelected = false;
        String actionLog = "Is element enabled? <p>elem - "+locator+"</p> Output - ";
        try{
            isElemSelected = elem.isSelected();
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"isSelectedCheckException");
            String errorMessage = "Exception occurred while checking if element is Selected <p>elem - "+ locator +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,actionLog+isElemSelected,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,actionLog+isElemSelected);
        return isElemSelected;
    }
    public void selectCheckBox(WebElement elem,WebDriver driver){
        selectCheckBox(elem,driver,false,null);
    }
    public void selectCheckBox(WebElement elem,WebDriver driver,boolean takeScreenshot,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        String actionLog = "Checkbox element is selected <p>elem - "+locator+"</p> Output - ";
        try{
            if(!isSelected(elem,driver))
                elem.click();
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"selectCheckBoxException");
            String errorMessage = "Exception occurred while selecting checkbox <p>elem - "+ locator +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,actionLog,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,actionLog);
    }
    public void deSelectCheckBox(WebElement elem,WebDriver driver){
        deSelectCheckBox(elem,driver,false,null);
    }
    public void deSelectCheckBox(WebElement elem,WebDriver driver,boolean takeScreenshot,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        String actionLog = "Checkbox element is deselected <p>elem - "+locator+"</p> Output - ";
        try{
            if(isSelected(elem,driver))
                elem.click();
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"selectCheckBoxException");
            String errorMessage = "Exception occurred while deselecting checkbox <p>elem - "+ locator +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,actionLog,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,actionLog);
    }
}
