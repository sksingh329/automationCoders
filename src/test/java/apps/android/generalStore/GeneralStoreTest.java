package apps.android.generalStore;

import flows.android.generalStore.GeneralStoreFlow;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.HandlePropertiesFile;

import java.util.Properties;

public class GeneralStoreTest {
    GeneralStoreFlow generalStore;
    public Properties env;
    @BeforeMethod
    public void getAndroidGeneralStoreApp(){
        env = HandlePropertiesFile.loadProperties("src/test/java/env/", "env.properties");
        String apkPath = "src/test/java/googleTest/android/apk/"+env.getProperty("mobileApkGeneralStore");
        String app = env.getProperty("mobileAppYoutube");
        String browserVersion = env.getProperty("mobileBrowserVersion");
        generalStore = new GeneralStoreFlow(env.getProperty("mobileDeviceName"),"browser",browserVersion);
    }
    @Test(enabled = false)
    public void generalStoreAppLogin(){
        System.out.println("App is launched");
    }
}
