package core.web.selenium.seleniumActions;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class SeleniumBrowser {
    public String getTitle(WebDriver driver){return driver.getTitle();}
    public String getCurrentUrl(WebDriver driver){return driver.getCurrentUrl();}
    public String getPageSource(WebDriver driver){return driver.getPageSource();}
    public String getScreenShot(WebDriver driver, String fileName){
        String currentReportFolder = System.getProperty("reportFolder");
        String random = RandomStringUtils.randomAlphanumeric(4);
        String fileSuffix = Calendar.HOUR_OF_DAY+"_"+Calendar.MINUTE+"_"+Calendar.SECOND+"_"+random;
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destination = currentReportFolder+"/web/" +fileName+fileSuffix+".png";
        try {
            FileUtils.copyFile(source,new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}
