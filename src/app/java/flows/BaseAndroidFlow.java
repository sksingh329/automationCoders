package flows;

import core.mobile.appium.androidDriver.AndroidAppType;
import core.mobile.appium.androidDriver.AndroidBaseDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseAndroidFlow extends AndroidBaseDriver {
    public AndroidDriver<AndroidElement> getAndroidDriver(String deviceName, String appType, String app){
        AndroidAppType appTypeEnum;
        String appTyeParam = appType.toUpperCase();
        switch(appTyeParam){
            case "BROWSER":
                appTypeEnum = AndroidAppType.BROWSER;
                break;
            default:
                appTypeEnum = AndroidAppType.NATIVE;
        }
        return super.getAndroidDriver(deviceName,appTypeEnum,app);
    }
}
