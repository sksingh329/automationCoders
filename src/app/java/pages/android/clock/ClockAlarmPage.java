package pages.android.clock;

import core.mobile.appium.BaseAndroidPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import reports.extent.ReporterUtils;

import java.util.List;

public class ClockAlarmPage extends BaseAndroidPage {
    private AndroidDriver<AndroidElement> androidDriver;
    private By idDigitalClock = By.id("com.google.android.deskclock:id/digital_clock");
    private By idCreateAlarm = By.id("com.google.android.deskclock:id/fab");
    private By idDigitalArrow = By.id("com.google.android.deskclock:id/arrow");
    private By idDigitalDelete = By.id("com.google.android.deskclock:id/delete");

    public ClockAlarmPage(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
    }
    public boolean validateAlarmsAreSorted(){
        List<AndroidElement> elemDigitalClocks = androidDriver.findElements(idDigitalClock);
        String strFirstDigitalClock =elemDigitalClocks.get(0).getAttribute("text");
        String strSecondDigitalClock = elemDigitalClocks.get(1).getAttribute("text");
        boolean isAlarmsAreSorted;
        if(getAmPm(strFirstDigitalClock).equalsIgnoreCase(getAmPm(strSecondDigitalClock))){
            if(getHour(strFirstDigitalClock).equalsIgnoreCase(getHour(strSecondDigitalClock))){
                if(Integer.parseInt(getMinute(strFirstDigitalClock)) < Integer.parseInt(getMinute(strSecondDigitalClock))){
                    System.out.println("Sorting is as expected using minute");
                    isAlarmsAreSorted = true;
                }
                else isAlarmsAreSorted=false;
            }
            else{
                if(Integer.parseInt(getHour(strFirstDigitalClock)) < Integer.parseInt(getHour(strSecondDigitalClock))){
                    System.out.println("Sorting is as expected using hour");
                    isAlarmsAreSorted = true;
                }
                else isAlarmsAreSorted=false;
            }
        }
        else{
            if(getAmPm(strFirstDigitalClock).equalsIgnoreCase("AM")&&getAmPm(strSecondDigitalClock).equalsIgnoreCase("PM")){
                System.out.println("Sorting is as expected using AM and PM");
                isAlarmsAreSorted = true;
            }
            else isAlarmsAreSorted=false;
        }
        return isAlarmsAreSorted;
    }
    public ClockCreateAlarmsPage clickCreateAlarm(){
        androidDriver.findElement(idCreateAlarm).click();
        return new ClockCreateAlarmsPage(androidDriver);
    }
    public boolean isAlarmExist(String hour, String minute, String amPm){
        List<AndroidElement> elemDigitalClocks = androidDriver.findElements(idDigitalClock);
        boolean flag = false;
        for (AndroidElement elemAlarm:elemDigitalClocks
             ) { String time = elemAlarm.getAttribute("text");
                 if(getAmPm(time).equalsIgnoreCase(amPm) && getHour(time).equalsIgnoreCase(hour) && getMinute(time).equalsIgnoreCase(minute)){
                     flag = true;
                     break;
                 }
        }
       return flag;
    }
    private int getAlarmIndex(String hour, String minute, String amPm){
        List<AndroidElement> elemDigitalClocks = androidDriver.findElements(idDigitalClock);
        int pos = 0;
        boolean flag =false;
        for (AndroidElement elemAlarm:elemDigitalClocks
        ) { String time = elemAlarm.getAttribute("text");
            pos += 1;
            if(getAmPm(time).equalsIgnoreCase(amPm) && getHour(time).equalsIgnoreCase(hour) && getMinute(time).equalsIgnoreCase(minute)){
                flag = true;
                break;
            }
        }
        if(flag) return pos;
        else return 0;
    }
    public void deleteAlarm(String hour, String minute, String amPm){
        String methodInfo = "ClockAlarmPage->deleteAlarm";
        List<AndroidElement> elemDigitalArrow = androidDriver.findElements(idDigitalArrow);
        String screenshotPath = getScreenShot(androidDriver,"GoogleSearchPage");
        System.out.println("Number of arrows "+elemDigitalArrow.size());
        int alarmPos = getAlarmIndex(hour,minute,amPm);
        //TODO - Handle alarm not exist scenario
        elemDigitalArrow.get(alarmPos-1).click();
        //androidDriver.findElement(idDigitalDelete).click();
        //TODO - Validate alarm is deleted using index
        ReporterUtils.setReporter(ReporterUtils.Status.PASS,methodInfo+": Navigated to Delete Alarm",screenshotPath);
    }
    private String getAmPm(String time){
        return time.substring(time.length()-2);
    }
    private String getHour(String time){
        String[] timeBeforeSpace = time.split(" ");
        String timeHrMinute = timeBeforeSpace[0];
        String[] timeHrString = timeHrMinute.split(":");
        return timeHrString[0];
    }
    private String getMinute(String time){
        String[] timeBeforeSpace = time.split(" ");
        String timeHrMinute = timeBeforeSpace[0];
        String[] timeMinString = timeHrMinute.split(":");
        return timeMinString[1].substring(0,2);
    }
}
