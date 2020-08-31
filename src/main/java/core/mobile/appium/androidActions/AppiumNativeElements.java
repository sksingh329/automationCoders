package core.mobile.appium.androidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import reports.extent.CustomReporter;

public class AppiumNativeElements extends AppiumNative{
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
            CustomReporter.setReporter(CustomReporter.Status.FAIL,methodInfo+": Element not found "+locator+"Exception message - "+exception.toString());
        }
        catch(NullPointerException exception){
            System.out.println(exception.toString());
            CustomReporter.setReporter(CustomReporter.Status.FAIL,methodInfo+": Element not found "+locator+"Exception message - "+exception.toString());
        }

        CustomReporter.setReporter(CustomReporter.Status.PASS,methodInfo+": Element found "+locator);
        return elem;
    }
}
