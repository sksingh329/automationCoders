package flows.android.generalStore;

import core.mobile.appium.BaseAndroidFlow;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralStoreFlow extends BaseAndroidFlow {
    private AndroidDriver<AndroidElement> androidDriver;
    public GeneralStoreFlow(String deviceName, String appType, String app){
        androidDriver = super.getAndroidDriver(deviceName,appType,app);
    }
}
