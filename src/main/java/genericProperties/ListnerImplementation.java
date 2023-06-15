package genericProperties;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.ReportStats;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener {
    ExtentReports reports;
    ExtentTest test;

    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println("Running Method: " + methodName);
        test = reports.createTest(methodName);
    }

    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println("Running Method: " + methodName);
        System.out.println("The test has successfully passed ");
        test.log(Status.PASS, "Test passed");
    }

    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println("Running Method: " + methodName);
        System.out.println("The Test has failed ");
        test.log(Status.FAIL, "Test failed");
        WebDriverUtility wb = new WebDriverUtility();
        String screenShotName = methodName + new JavaUtility().getSystemDateInFormat();
        try {
         String st = wb.takeScreenshot(BaseClass.sdriver, screenShotName);
            test.addScreenCaptureFromPath(st);
        } catch (IOException e) {
            e.printStackTrace();
        }
   
        test.log(Status.FAIL, result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println("Running Method: " + methodName);
        System.out.println("The Test is skipped");
        test.log(Status.SKIP, "Test skipped");
        test.log(Status.SKIP, result.getThrowable());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println("Running Method: " + methodName);
        System.out.println("Test failed, but some part did run");
        test.log(Status.WARNING, "Test failed, but some part did run");
        test.log(Status.WARNING, result.getThrowable());
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println("Running Method: " + methodName);
        System.out.println("Ran into timeout");
        test.log(Status.WARNING, "Test ran into timeout");
        test.log(Status.WARNING, result.getThrowable());
    }

    public void onStart(ITestContext context) {
        System.out.println("Real Test Started");

        // Configure the extent reporters
        ExtentSparkReporter htmlReport = new ExtentSparkReporter(
                ".\\ExtentReports\\Report-" + new JavaUtility().getSystemDateInFormat() + ".html");
        htmlReport.config().setDocumentTitle("Execution Report");
        htmlReport.config().setTheme(Theme.DARK);
        htmlReport.config().setReportName("Execution Report v1");

        reports = new ExtentReports();
        reports.attachReporter(htmlReport);
        reports.setSystemInfo("Base Browser", "Chrome");
        reports.setSystemInfo("Base URL", "Local Host");
    }

    public void onFinish(ITestContext context) {
        reports.flush();
        System.out.println("Test Finished");
    }
}
