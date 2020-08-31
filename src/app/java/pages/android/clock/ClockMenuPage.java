package pages.android.clock;

import core.mobile.appium.BaseAndroidPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ClockMenuPage extends BaseAndroidPage {
    private final AndroidDriver<AndroidElement> androidDriver;

    private final String xPathMenuAlarm = "//*[@text='ALARM']";
    private final String xPathMenuClock = "//*[@text='CLOCK']";
    private final String xPathMenuTimer = "//*[@text='TIMER']";
    private final String xPathMenuStopWatch = "//*[@text='STOPWATCH']";
    public ClockMenuPage(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
    }
    public boolean validateMenuItemsExist(){
        boolean isMenuItemsExist,boolMenuAlarmDisplayed, boolMenuClockDisplayed, boolMenuTimerDisplayed, boolMenuStopWatchDisplayed;
        String isMenuAlarmDisplayed = androidDriver.findElementByXPath(xPathMenuAlarm).getAttribute("displayed");
        if(isMenuAlarmDisplayed.equalsIgnoreCase("true")) boolMenuAlarmDisplayed = true;
        else boolMenuAlarmDisplayed = false;
        String isMenuClockDisplayed = androidDriver.findElementByXPath(xPathMenuClock).getAttribute("displayed");
        if(isMenuClockDisplayed.equalsIgnoreCase("true")) boolMenuClockDisplayed = true;
        else boolMenuClockDisplayed = false;
        String isMenuTimerDisplayed = androidDriver.findElementByXPath(xPathMenuTimer).getAttribute("displayed");
        if(isMenuTimerDisplayed.equalsIgnoreCase("true")) boolMenuTimerDisplayed = true;
        else boolMenuTimerDisplayed = false;
        String isMenuStopWatchDisplayed = androidDriver.findElementByXPath(xPathMenuStopWatch).getAttribute("displayed");
        if(isMenuStopWatchDisplayed.equalsIgnoreCase("true")) boolMenuStopWatchDisplayed = true;
        else boolMenuStopWatchDisplayed = false;
        isMenuItemsExist = boolMenuAlarmDisplayed && boolMenuClockDisplayed && boolMenuStopWatchDisplayed && boolMenuTimerDisplayed;
        return isMenuItemsExist;
    }

    public ClockCurrentClockPage navigateToClockScreen(){
        //androidDriver.findElementByXPath(xPathMenuClock).click();
        System.out.println("Reached here");
        click(getAndroidElement(androidDriver,"//*[@text='CLOCK1']"));
        return new ClockCurrentClockPage(androidDriver);
    }
    public ClockAlarmPage navigateToAlarmScreen(){
        //androidDriver.findElementByXPath(xPathMenuAlarm).click();
        click(getAndroidElement(androidDriver,xPathMenuAlarm));
        return new ClockAlarmPage(androidDriver);
    }
}
