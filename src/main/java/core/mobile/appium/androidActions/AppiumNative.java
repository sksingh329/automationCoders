package core.mobile.appium.androidActions;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class AppiumNative {
    public String getScreenShot(AndroidDriver driver, String fileName){
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
