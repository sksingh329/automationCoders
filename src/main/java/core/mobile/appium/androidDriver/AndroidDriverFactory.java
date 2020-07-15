package core.mobile.appium.androidDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverFactory {
    private static final AndroidDriverFactory instance = new AndroidDriverFactory();
    private AndroidDriverFactory(){}

    public static AndroidDriverFactory getInstance(){return instance;}

    private static ThreadLocal<AndroidDriver<AndroidElement>> threadLocal = new ThreadLocal<>();

    public AndroidDriver<AndroidElement> getAndroidDriver(String deviceName,AndroidAppType appType, String app){
        if(threadLocal.get() == null){
            String automationName = "uiautomator2";
            String platformName = "Android";
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("automationName",automationName);
            cap.setCapability("platformName",platformName);
            cap.setCapability("deviceName",deviceName);
            cap.setCapability("noReset","true");
            if(appType == AndroidAppType.NATIVE){
                if(app.endsWith(".apk")){
                    File fs = new File(app);
                    cap.setCapability("app",fs.getAbsolutePath());
                }
                else{
                    String[] appActivity = app.split(";");
                    cap.setCapability("appPackage",appActivity[0]);
                    cap.setCapability("appActivity",appActivity[1]);
                }
            }
            else if(appType == AndroidAppType.BROWSER){
                WebDriverManager.chromedriver().browserVersion(app).setup();
                cap.setCapability("chromedriverExecutable",WebDriverManager.chromedriver().getBinaryPath());
                cap.setCapability("browserName","chrome");
            }
            try {
                 threadLocal.set(new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return threadLocal.get();
    }
}
