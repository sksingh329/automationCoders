package pages.android.clock;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.Calendar;

public class ClockCurrentClockPage {
    private AndroidDriver<AndroidElement> androidDriver;

    By idClockTimeStamp = By.id("com.google.android.deskclock:id/digital_clock");
    By idClockDate = By.id("com.google.android.deskclock:id/date");

    public ClockCurrentClockPage(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
    }
    public boolean validateTimeStamp(){
        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR);
        int minute = currentTime.get(Calendar.MINUTE);
        int amPm = currentTime.get(Calendar.AM_PM);
        String strAmPm;
        String minutePrefix = "";
        if(minute<10) minutePrefix = "0";
        if(amPm == 0 ) strAmPm = "AM";
        else strAmPm = "PM";
        String expectedTime = hour+":"+minutePrefix+minute+" "+strAmPm;
        String stringClockTime = androidDriver.findElement(idClockTimeStamp).getAttribute("text");
        String stringClockDay = androidDriver.findElement(idClockDate).getAttribute("text");
        if(stringClockTime.equalsIgnoreCase(expectedTime)) return true;
        else return false;
    }
}
