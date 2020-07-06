package reports.extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
    public static ExtentReports report;
    public static ExtentReports getReporter(){
        String reportPath = System.getProperty("user.dir")+ "/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Test Automation Report");
        reporter.config().setDocumentTitle("Test Results");
        report = new ExtentReports();
        report.attachReporter(reporter);
        report.setSystemInfo("Tester","Subodh Singh");
        return report;
    }
}
