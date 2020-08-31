package flows.android.clock;

import flows.BaseAndroidFlow;
import pages.android.clockPages.ClockAlarmPage;
import pages.android.clockPages.ClockCreateAlarmsPage;
import pages.android.clockPages.ClockCurrentClockPage;
import pages.android.clockPages.ClockMenuPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import reports.extent.CustomReporter;

import java.util.concurrent.TimeUnit;

public class ValidateClockFlow extends BaseAndroidFlow {
    private AndroidDriver<AndroidElement> androidDriver;
    public ValidateClockFlow(String deviceName, String appType, String app){
        androidDriver = super.getAndroidDriver(deviceName,appType,app);
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public boolean validateClockMenuTimeStamp(){
        ClockMenuPage clockMenuPage = new ClockMenuPage(androidDriver);
        ClockCurrentClockPage clockCurrentClockPage = clockMenuPage.navigateToClockScreen();
        boolean isTimeStampValid = clockCurrentClockPage.validateTimeStamp();
        return isTimeStampValid;
    }
    public boolean validateClockMenuItems(){
        ClockMenuPage clockMenuPage = new ClockMenuPage(androidDriver);
        boolean isMenuItemsExist = clockMenuPage.validateMenuItemsExist();
        return isMenuItemsExist;
    }
    public boolean validateAlarmsAreSorted(){
        ClockMenuPage clockMenuPage = new ClockMenuPage(androidDriver);
        ClockAlarmPage clockAlarmPage = clockMenuPage.navigateToAlarmScreen();
        return clockAlarmPage.validateAlarmsAreSorted();
    }
    public void createNewAlarm(String hour, String minute, String amPm){
        ClockMenuPage clockMenuPage = new ClockMenuPage(androidDriver);
        ClockAlarmPage clockAlarmPage = clockMenuPage.navigateToAlarmScreen();
        ClockCreateAlarmsPage clockCreateAlarmPage = clockAlarmPage.clickCreateAlarm();
        clockCreateAlarmPage.createNewAlarm(hour,minute,amPm);
    }
    public boolean checkAlarmExist(String hour, String minute, String amPm){
        ClockMenuPage clockMenuPage = new ClockMenuPage(androidDriver);
        ClockAlarmPage clockAlarmPage = clockMenuPage.navigateToAlarmScreen();
        return clockAlarmPage.isAlarmExist(hour,minute,amPm);
    }
    public void deleteAlarm(String hour, String minute, String amPm){
        String methodInfo = "ValidateClockFlow->deleteAlarm";
        ClockMenuPage clockMenuPage = new ClockMenuPage(androidDriver);
        ClockAlarmPage clockAlarmPage = clockMenuPage.navigateToAlarmScreen();
        clockAlarmPage.deleteAlarm(hour, minute, amPm);
        CustomReporter.setReporter(CustomReporter.Status.PASS,methodInfo+": Search is done navigated to page");
    }
}