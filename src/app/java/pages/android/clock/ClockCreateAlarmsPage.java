package pages.android.clock;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class ClockCreateAlarmsPage {
    private AndroidDriver<AndroidElement> androidDriver;
    private String strSelectDialPrefix = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"";
    private String strSelectDialSuffix = "\"]";
    private By idAm = By.id("android:id/am_label");
    private By idPm = By.id("android:id/pm_label");
    private By idHour = By.id("android:id/hours");
    private By idMinute = By.id("android:id/minutes");
    private By idOk = By.id("android:id/button1");

    public ClockCreateAlarmsPage(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
    }
    //TODO - Validate create alarm screen is opened

    private By getXPathDial(String value){
        return By.xpath(strSelectDialPrefix+value+strSelectDialSuffix);
    }
    private void clickDial(String value){
        By xPathDial = getXPathDial(value);
        androidDriver.findElement(xPathDial).click();
    }
    private void selectAmPm(String amPm){
        By idSelectAmPm;
        if(!isAmPmSelected(amPm)){
            if(amPm.equalsIgnoreCase("Am")) idSelectAmPm = idAm;
            else idSelectAmPm = idPm;
            androidDriver.findElement(idSelectAmPm).click();
        }
    }
    private String getHour(){
        return androidDriver.findElement(idHour).getAttribute("text");
    }
    private String getMinute(){
        if(androidDriver.findElement(idMinute).getAttribute("text").equalsIgnoreCase("00")) return "0";
        else if(androidDriver.findElement(idMinute).getAttribute("text").equalsIgnoreCase("05")) return "5";
        return androidDriver.findElement(idMinute).getAttribute("text");
    }

    private boolean isAmPmSelected(String amPm){
        boolean boolAmPmSelected;
        String strAmPmSelected = "false";
        if(amPm.equalsIgnoreCase("AM"))
            strAmPmSelected = androidDriver.findElement(idAm).getAttribute("checked");
        else if(amPm.equalsIgnoreCase("PM"))
            strAmPmSelected = androidDriver.findElement(idPm).getAttribute("checked");
        if(strAmPmSelected.equalsIgnoreCase("true"))
            boolAmPmSelected = true;
        else boolAmPmSelected = false;

        return boolAmPmSelected;
    }

    private void clickOk(){
        androidDriver.findElement(idOk).click();
    }

    //TODO - Validate return from clickDial method
    public void createNewAlarm(String hour, String minute, String amPm) {
        clickDial(hour);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickDial(minute);
        selectAmPm(amPm);
        validateAlarmIsAdded(hour, minute, amPm);
    }
    public void validateAlarmIsAdded(String hour, String minute, String amPm){
        System.out.println(getHour());
        System.out.println(getMinute());
        System.out.println(isAmPmSelected(amPm));

        if(getHour().equalsIgnoreCase(hour)&&getMinute().equalsIgnoreCase(minute)&&isAmPmSelected(amPm)){
            System.out.println("Time is selected as expected");
        }
        else
            System.out.println("Time is not selected as expected");
    }
}
