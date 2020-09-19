package core.mobile.appium.androidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import reports.extent.ReporterUtils;

public class AppiumNativeElement extends AppiumNative{
    public AndroidElement getAndroidElement(AndroidDriver<AndroidElement> androidDriver, By locator){
        AndroidElement elem = androidDriver.findElement(locator);
        return elem;
    }
    public AndroidElement getAndroidElement(AndroidDriver<AndroidElement> androidDriver, String locator){
        String methodInfo = "AppiumNativeElements->getAndroidElement";
        AndroidElement elem = null;
        try{
             elem = androidDriver.findElementByXPath(locator);
        }
        catch(NoSuchElementException exception){
            System.out.println(exception.toString());
            ReporterUtils.setReporter(ReporterUtils.Status.FAIL,methodInfo+": Element not found "+locator+"Exception message - "+exception.toString());
        }
        catch(NullPointerException exception){
            System.out.println(exception.toString());
            ReporterUtils.setReporter(ReporterUtils.Status.FAIL,methodInfo+": Element not found "+locator+"Exception message - "+exception.toString());
        }

        ReporterUtils.setReporter(ReporterUtils.Status.PASS,methodInfo+": Element found "+locator);
        return elem;
    }
}
