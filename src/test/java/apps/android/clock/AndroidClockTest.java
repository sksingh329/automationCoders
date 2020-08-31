package apps.android.clock;

import flows.android.clock.ValidateClockFlow;
import core.mobile.appium.BaseAndroidPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.HandlePropertiesFile;

import java.util.Properties;

@Listeners(reports.listeners.TestNGListener.class)
public class AndroidClockTest extends BaseAndroidPage {
    public Properties env;
    ValidateClockFlow validateClockFlow;
    @BeforeMethod
    public void getAndroidClock() {
        env = HandlePropertiesFile.loadProperties("src/test/java/env/", "env.properties");
        String app = env.getProperty("mobileAppGoogleClock");
        validateClockFlow = new ValidateClockFlow(env.getProperty("mobileDeviceName"), "native", app);
    }

    @Test(enabled = false,description = "After app is launched menus items are shown as expected.")
    public void validateClockMenuItems(){
        boolean isMenuItemsDisplayed = validateClockFlow.validateClockMenuItems();
        System.out.println("Are Menu Items are displayed? "+isMenuItemsDisplayed);
    }
    @Test(enabled = false,description = "To validate time on Clock screen is current time.")
    public void validateTimeStampInClockMenu(){
        boolean isTimeStampValid = validateClockFlow.validateClockMenuTimeStamp();
        System.out.println("Timestamp validation on Clock screen is valid? "+isTimeStampValid);
    }
    @Test(enabled = false,description = "This test case validates alarm time on Alarm screen are sorted. It assumes there are two alarm in app as pre-requisite.")
    public void validateAlarmsAreSorted(){
        boolean isAlarmsAreSorted = validateClockFlow.validateAlarmsAreSorted();
        System.out.println("Are alarms are sorted? "+isAlarmsAreSorted);
    }
    @Test(enabled = false)
    public void createNewAlarm(){
        validateClockFlow.createNewAlarm("6","0","PM");
    }
    @Test(enabled = false)
    public void checkIfAlarmPresent(){
        boolean isAlarmExist = validateClockFlow.checkAlarmExist("8","30","PM");
        if(isAlarmExist) System.out.println("Alarm exist");
        else System.out.println("Alarm not exist");
    }
    @Test(enabled = false)
    public void deleteAlarmFromAlarmScreen(){
        validateClockFlow.deleteAlarm("11","08","PM");
    }

}
