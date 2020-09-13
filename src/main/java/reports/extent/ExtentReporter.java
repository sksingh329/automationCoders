package reports.extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
    public static ExtentReports report;
    public static ExtentReports getReporter(){
        String reportPath = System.getProperty("user.dir")+ "/executionReports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Test Automation Report");
        reporter.config().setDocumentTitle("Test Results");
        reporter.config().setTheme(Theme.DARK);
        report = new ExtentReports();
        report.attachReporter(reporter);
        report.setSystemInfo("Tester","Subodh Singh");
        return report;
    }
}
