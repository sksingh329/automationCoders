package core.mobile.appium.androidDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidBaseDriver {
    public AndroidDriver<AndroidElement> androidDriver;

    public AndroidDriver<AndroidElement> getAndroidBrowserDriver(String deviceName){
        androidDriver = AndroidDriverFactory.getInstance().getAndroidDriver(deviceName,AndroidAppType.BROWSER,"");
        return androidDriver;
    }
    public AndroidDriver<AndroidElement> getAndroidNativeDriverUsingApkPath(String deviceName, String app){
        androidDriver = AndroidDriverFactory.getInstance().getAndroidDriver(deviceName,AndroidAppType.NATIVE,"");
        return androidDriver;
    }
    public AndroidDriver<AndroidElement> getAndroidNativeDriverUsingPackageDetails(String deviceName, String app){
        //ToDo - Use split to get activityPackage and activityClass
        androidDriver = AndroidDriverFactory.getInstance().getAndroidDriver(deviceName,AndroidAppType.NATIVE,"");
        return androidDriver;
    }
    public AndroidDriver<AndroidElement> getAndroidDriver(String deviceName,AndroidAppType appType,String app){
        androidDriver = AndroidDriverFactory.getInstance().getAndroidDriver(deviceName,appType,app);
        return androidDriver;
    }
}
