package core.web.selenium.seleniumActions;

import exceptions.CustomExceptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import reports.extent.ReporterUtils;

import java.time.Duration;

/***
 * Mouse Actions – doubleClick(), moveToElement(), contextClick(), clickAndHold(), dragAndDrop()
 * Keyboard Actions – sendKeys(), keyUp(), keyDown()
 */
public class SeleniumWebUIAction extends SeleniumDropDown {
    public void doubleClick(WebElement elem, WebDriver driver){
        doubleClick(elem,driver,false,null);
    }

    /***
     * Performs a double-click at middle of the given element. Equivalent to: Actions.moveToElement(element).doubleClick()
     * @param elem
     * @param driver
     * @param takeScreenshot
     * @param screenshotName
     */
    public void doubleClick(WebElement elem, WebDriver driver,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        String reportMessage = null;
        try{
            Actions action = new Actions(driver);
            action.doubleClick(elem).perform();
            reportMessage = "Double Click is performed on <p>elem - "+locator+"</p>";
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"DoubleClickError");
            String errorMessage = "Exception occurred while double click operation <p>elem - "+ locator +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void moveToElement(WebElement elem, WebDriver driver){
        moveToElement(elem,driver,false,null);
    }

    /***
     * Moves the mouse to the middle of the element. The element is scrolled into view and its location is calculated using getClientRects.
     * @param elem
     * @param driver
     * @param takeScreenshot
     * @param screenshotName
     */
    public void moveToElement(WebElement elem, WebDriver driver,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        String reportMessage = null;
        try{
            Actions action = new Actions(driver);
            action.moveToElement(elem).perform();
            reportMessage = "Mouse is moved to to element <p>elem - "+locator+"</p>";
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"MoveToElementError");
            String errorMessage = "Exception occurred while moving mouse focus to <p>elem - "+ locator +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void contextClick(WebElement elem, WebDriver driver){
        contextClick(elem,driver,false,null);
    }

    /***
     * To perform context click on WebElement
      * @param elem - WebElement on which context click will be done
     * @param driver - current instance of WebDriver
     * @param takeScreenshot - boolean value for taking screenshot
     * @param screenshotName - if takeScreenShot is true then provide name of screenshot
     */
    public void contextClick(WebElement elem, WebDriver driver,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        String reportMessage = null;
        try{
            Actions action = new Actions(driver);
            action.contextClick(elem).perform();
            reportMessage = "Context click is done on element <p>elem - "+locator+"</p>";
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"ContextClickError");
            String errorMessage = "Exception occurred while doing context click on element <p>elem - "+ locator +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void dragAndDrop(WebElement sourceElem,WebElement targetElem, WebDriver driver){
        dragAndDrop(sourceElem,targetElem,driver,false,null);
    }

    /***
     * To perform drag and drop from sourceElem to targetElem
     * @param sourceElem - WebElement of source element
     * @param targetElem - WebElement of target element
     * @param driver - Current WebDriver instance
     * @param takeScreenshot - boolean value for taking screenshot
     * @param screenshotName - if takeScreenshot is true then provide name for screenshot
     */
    public void dragAndDrop(WebElement sourceElem,WebElement targetElem, WebDriver driver,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String sourceLocator = getLocator(sourceElem.toString());
        String targetLocator = getLocator(targetElem.toString());
        String reportMessage = null;
        try{
            Actions action = new Actions(driver);
            action.dragAndDrop(sourceElem,targetElem).build().perform();
            /*
            action.moveToElement(sourceElem)
                    .pause(Duration.ofSeconds(10))
                    .clickAndHold(sourceElem)
                    .pause(Duration.ofSeconds(10))
                    .moveToElement(targetElem)
                    .pause(Duration.ofSeconds(10))
                    .release().build().perform();

             */
            reportMessage = "Drag and drop is done from source element to target element <p>source elem,target elem - "+sourceLocator+","+targetLocator+"</p>";
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"DragAndDropError");
            String errorMessage = "Exception occurred while performing drag And drop from source element to target element <p>source elem,target elem - "+sourceLocator+","+targetLocator +"</p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void actionKeysDownTypeKeysUp(WebElement elem, WebDriver driver, String key,String text){
        actionKeysDownTypeKeysUp(elem,driver,key,text);
    }
    public void actionKeysDownTypeKeysUp(WebElement elem, WebDriver driver, String inputKey,String text,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        String reportMessage = null;
        Keys key;
        switch (inputKey.toUpperCase()){
            case "CONTROL":
                key = Keys.CONTROL;
                break;
            case "SHIFT":
                key = Keys.SHIFT;
                break;
            default:
                key = Keys.ALT;
                break;
        }
        try{
            Actions action = new Actions(driver);
            action.keyDown(key).sendKeys(elem,text).keyUp(key).perform();
            reportMessage = "Key is pressed, value entered and key released on element <p>elem - "+locator+"</p>";
        }
        catch (Exception ex) {
            String screenshotPath = getScreenShot(driver,"ActionSendKeysError");
            String errorMessage = "Exception occurred while performing send key using  action on element <p>elem - "+ locator +"</p>~=/ExceptionMessage -"+ ex.getMessage();
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
