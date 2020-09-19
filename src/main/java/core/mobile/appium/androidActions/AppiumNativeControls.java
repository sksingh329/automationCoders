package core.mobile.appium.androidActions;

import io.appium.java_client.android.AndroidElement;
import reports.extent.ReporterUtils;

public class AppiumNativeControls extends AppiumNativeElement {
    public void click(AndroidElement elem){
        String methodInfo = "AppiumNativeControls->click";
        elem.click();
        String s = elem.toString();
        ReporterUtils.setReporter(ReporterUtils.Status.PASS,methodInfo+": Element is clicked"+s.substring(s.lastIndexOf("->"),s.length()-1));
    }
}
