package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import testbase.BaseClass;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkreporter;
    public ExtentReports extent;
    public ExtentTest test;
    String repName;

    @Override
    public void onStart(ITestContext testContext) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        String timestamp = df.format(new Date());

        repName = "Test-Report-" + timestamp + ".html";
        sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + repName);

        sparkreporter.config().setDocumentTitle("Open Cart Test Automation");
        sparkreporter.config().setReportName("Open Cart Functional Testing");
        sparkreporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkreporter);

        extent.setSystemInfo("Application", "OpenCart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customer");
        extent.setSystemInfo("Username", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

       
        try {
            String os = testContext.getCurrentXmlTest().getParameter("os");
            String browser = testContext.getCurrentXmlTest().getParameter("Browser");
            extent.setSystemInfo("Operating System", os);
            extent.setSystemInfo("Browser", browser);
        } catch (Exception e) {
            // parameters not defined
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, result.getName() + " executed successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, result.getName() + " failed.");
        test.log(Status.INFO, result.getThrowable().getMessage());

        try {
            String imgPath = new BaseClass().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName() + " was skipped.");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
