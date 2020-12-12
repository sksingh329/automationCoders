package core.web.selenium.seleniumActions;

import exceptions.CustomExceptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import reports.extent.ReporterUtils;

public class SeleniumDropDown extends SeleniumElements {
    //TODO - get options from dropdown
    public enum SelectOptions{
        INDEX,VALUE,VISIBLETEXT
    }
    public void selectFromDropDown(WebElement elem,SelectOptions selectUsing, String options,WebDriver driver){
        selectFromDropDown(elem,selectUsing,options,driver,false,null);
    }
    public void selectFromDropDown(WebElement elem,SelectOptions selectUsing, String options,WebDriver driver,boolean takeScreenshot,String screenshotName){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        String locator = getLocator(elem.toString());
        Select selectDropDown = new Select(elem);
        String reportMessage = "";
        try{
            switch (selectUsing){
                case INDEX:
                    selectDropDown.selectByIndex(Integer.parseInt(options));
                    reportMessage = "Value is selected using index "+options+" on <p>elem - "+locator+"</p>";
                    break;
                case VALUE:
                    selectDropDown.selectByValue(options);
                    reportMessage = "Value is selected using value "+options+" on <p>elem - "+locator+"</p>";
                    break;
                case VISIBLETEXT:
                    selectDropDown.selectByVisibleText(options);
                    reportMessage = "Value is selected using visible text "+options+" on <p>elem - "+locator+"</p>";
                    break;
            }
        }
        catch (Exception ex){
            String screenshotPath = getScreenShot(driver,"DropdownError");
            String errorMessage = "Exception occurred while selecting dropdown operation <p>elem - "+ locator +" using option "+options+"</p>~=/ExceptionMessage -"+ ex.getMessage();
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
