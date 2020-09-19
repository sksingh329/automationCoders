package reports.extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Calendar;

public class ExtentReporter {
    public static ExtentReports report;
    public static ExtentReports getReporter(){
        String baseTest = System.getProperty("user.dir")+ "/testResults/";
        Calendar cal = Calendar.getInstance();
        String reportPath = System.getProperty("reportFolder");
        if(reportPath == null){
            String reportFolderName = "Run_"+cal.get(Calendar.YEAR)+"_"+(cal.get(Calendar.MONTH)+1)+"_"+cal.get(Calendar.DAY_OF_MONTH)
                    +"_"+cal.get(Calendar.HOUR)+"_"+cal.get(Calendar.MINUTE)+"_"+cal.get(Calendar.SECOND)+"_"+
                    RandomStringUtils.randomNumeric(4);
            reportPath = baseTest+reportFolderName;
            System.setProperty("reportFolder",reportPath);
        }
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath+"/TestSummary.html");
        reporter.config().setReportName("Test Automation Report");
        reporter.config().setDocumentTitle("Test Results");
        reporter.config().setTheme(Theme.DARK);
        report = new ExtentReports();
        report.attachReporter(reporter);
        report.setSystemInfo("Tester","Subodh Singh");
        return report;
    }
}
