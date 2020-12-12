package core.web.selenium.seleniumActions;

import exceptions.CustomExceptions;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reports.extent.ReporterUtils;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class SeleniumBrowser {
    public String getCurrentUrl(WebDriver driver){
        return getCurrentUrl(driver,false,null);
    }
    public String getCurrentUrl(WebDriver driver,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        String currentUrl;
        try{
            currentUrl = driver.getCurrentUrl();
            reportMessage = "Current url is retrieved <p>Url: "+currentUrl;
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"GetCurrentUrlError");
            String errorMessage = "Exception occurred while getting current url </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
        return currentUrl;
    }
    public String getPageSource(WebDriver driver){
        return getPageSource(driver,false,null);
    }
    public String getPageSource(WebDriver driver,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        String pageSource;
        try{
            pageSource = driver.getPageSource();
            reportMessage = "Page source is retrieved <p>Page source: "+pageSource;
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"GetPageSourceError");
            String errorMessage = "Exception occurred while getting page source </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
        return pageSource;
    }
    public String getTitle(WebDriver driver){
        return getTitle(driver,false,null);
    }
    public String getTitle(WebDriver driver,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        String pageTitle;
        try{
            pageTitle = driver.getPageSource();
            reportMessage = "Page title is <p>Title: "+pageTitle;
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"GetPageTitleError");
            String errorMessage = "Exception occurred while getting page title </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
        return pageTitle;
    }
    public String getScreenShot(WebDriver driver, String fileName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String currentReportFolder = System.getProperty("reportFolder");
        String random = RandomStringUtils.randomAlphanumeric(4);
        String fileSuffix = Calendar.HOUR_OF_DAY+"_"+Calendar.MINUTE+"_"+Calendar.SECOND+"_"+random;
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destination = currentReportFolder+"/web/" +fileName+fileSuffix+".png";
        try {
            FileUtils.copyFile(source,new File(destination));
        } catch (IOException ex) {
            String errorMessage = "Exception occurred while getting page screenshot </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage);
        }
        catch (Exception ex){
            String errorMessage = "Exception occurred while getting page screenshot </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage);
        }
        return destination;
    }
    public String getScreenShot(WebElement elem,String fileName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String currentReportFolder = System.getProperty("reportFolder");
        String random = RandomStringUtils.randomAlphanumeric(4);
        String fileSuffix = Calendar.HOUR_OF_DAY+"_"+Calendar.MINUTE+"_"+Calendar.SECOND+"_"+random;
        File source = elem.getScreenshotAs(OutputType.FILE);
        String destination = currentReportFolder+"/web/" +fileName+fileSuffix+".png";
        try {
            FileUtils.copyFile(source,new File(destination));
        } catch (IOException ex) {

            String errorMessage = "Exception occurred while getting WebElement screenshot </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage);
        }
        catch (Exception ex){
            String errorMessage = "Exception occurred while getting WebElement screenshot </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage);
        }
        return destination;
    }
    public void cleanCookies(WebDriver driver){
        cleanCookies(driver,false,null);
    }
    public void cleanCookies(WebDriver driver,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        try{
            driver.manage().deleteAllCookies();
            reportMessage = "Cleaned browser cookies";
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"CleanCookiesError");
            String errorMessage = "Exception occurred while cleaning cookies </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void closeCurrentPage(WebDriver driver){
        closeCurrentPage(driver,false,null);
    }
    public void closeCurrentPage(WebDriver driver,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        try{
            driver.close();
            reportMessage = "Closed current page";
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"CloseCurrentPageError");
            String errorMessage = "Exception occurred while closing current page </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void quitBrowser(WebDriver driver){
        quitBrowser(driver,false,null);
    }
    public void quitBrowser(WebDriver driver,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        try{
            driver.quit();
            reportMessage = "Quit browser";
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"QuitBrowserError");
            String errorMessage = "Exception occurred while quitting browser </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void maximiseBrowser(WebDriver driver){
        maximiseBrowser(driver,false,null);
    }
    public void maximiseBrowser(WebDriver driver,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        try{
            driver.manage().window().maximize();
            reportMessage = "Maximise browser";
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"MaximiseBrowserError");
            String errorMessage = "Exception occurred while maximising browser </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    // Navigation command
    public void navigateForward(WebDriver driver){
        navigateForward(driver,false,null);
    }
    public void navigateForward(WebDriver driver,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        try{
            driver.navigate().forward();
            reportMessage = "Navigate browser forward";
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"NavigateBrowserForwardError");
            String errorMessage = "Exception occurred while navigating forward in browser </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void navigateBack(WebDriver driver){
        navigateBack(driver,false,null);
    }
    public void navigateBack(WebDriver driver,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        try{
            driver.navigate().back();
            reportMessage = "Navigate browser back";
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"NavigateBrowserBackError");
            String errorMessage = "Exception occurred while navigating back in browser </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void pageRefresh(WebDriver driver){
        pageRefresh(driver,false,null);
    }
    public void pageRefresh(WebDriver driver,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        try{
            driver.navigate().refresh();
            reportMessage = "Page is refreshed";
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"PageRefreshError");
            String errorMessage = "Exception occurred while refreshing page </p>~=/ExceptionMessage -"+ ex.getMessage();
            throw new CustomExceptions(methodName,errorMessage,screenshotPath);
        }
        if(takeScreenshot){
            String screenshotPath = getScreenShot(driver,screenshotName);
            ReporterUtils.logWithScreenshot(ReporterUtils.Status.PASS,methodName,reportMessage,screenshotPath);
        }
        else
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,reportMessage);
    }
    public void navigateToUrl(WebDriver driver,String url){
        navigateToUrl(driver,url,false,null);
    }
    public void navigateToUrl(WebDriver driver,String url,boolean takeScreenshot, String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String reportMessage;
        try{
            driver.navigate().to(url);
            reportMessage = "Navigated to url "+url;
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"NavigateToUrlError");
            String errorMessage = "Exception occurred while navigating to url </p>~=/ExceptionMessage -"+ ex.getMessage();
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
