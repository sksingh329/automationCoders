package core.web.selenium.seleniumActions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class SeleniumBrowser {
    public String getTitle(WebDriver driver){return driver.getTitle();}
    public String getCurrentUrl(WebDriver driver){return driver.getCurrentUrl();}
    public String getPageSource(WebDriver driver){return driver.getPageSource();}
    public String getScreenShot(WebDriver driver, String fileName){
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir")+ "/reports/screenShots/web/" +fileName+".png";
        try {
            FileUtils.copyFile(source,new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}
