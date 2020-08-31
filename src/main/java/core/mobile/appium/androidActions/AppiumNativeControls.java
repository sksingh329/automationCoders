package core.mobile.appium.androidActions;

import io.appium.java_client.android.AndroidElement;
import reports.extent.CustomReporter;

public class AppiumNativeControls extends AppiumNativeElements{
    public void click(AndroidElement elem){
        String methodInfo = "AppiumNativeControls->click";
        elem.click();
        String s = elem.toString();
        CustomReporter.setReporter(CustomReporter.Status.PASS,methodInfo+": Element is clicked"+s.substring(s.lastIndexOf("->"),s.length()-1));
    }
}
