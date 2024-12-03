package com.codetru.listeners;

import com.Japfu.annotations.FrameworkAnnotation;
import com.Japfu.constants.FrameworkConstants;
import com.Japfu.driver.DriverManager;
import com.Japfu.enums.AuthorType;
import com.Japfu.enums.Browser;
import com.Japfu.enums.CategoryType;
import com.Japfu.helpers.CaptureHelpers;
import com.Japfu.helpers.FileHelpers;
import com.Japfu.helpers.PropertiesHelpers;
import com.Japfu.helpers.ScreenRecoderHelpers;
import com.Japfu.keywords.WebUI;
import com.Japfu.report.AllureManager;
import com.Japfu.report.ExtentReportManager;
import com.Japfu.report.TelegramManager;
import com.Japfu.utils.BrowserInfoUtils;
import com.Japfu.utils.EmailSendUtils;
import com.Japfu.utils.LogUtils;
import com.Japfu.utils.ZipUtils;
import com.aventstack.extentreports.Status;
import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import org.testng.*;
import static com.Japfu.constants.FrameworkConstants.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

    static int count_totalTCs;
    static int count_passedTCs;
    static int count_skippedTCs;
    static int count_failedTCs;
    static List<String> failedTests ;
    
    private ScreenRecoderHelpers screenRecorder;
    
    public TestListener() {
//        try {
//            screenRecorder = new ScreenRecoderHelpers();
//        } catch (IOException | AWTException e) {
//            System.out.println(e.getMessage());
//        }
    }

    public String getTestName(ITestResult result) {
//    	return res
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    	
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    }

    @Override
    public void onStart(ISuite iSuite) {
        System.out.println("========= INSTALLING CONFIGURATION DATA =========");

        PropertiesHelpers.loadAllFiles();
        AllureManager.setAllureEnvironmentInformation();
        ExtentReportManager.initReports();
        System.out.println("========= INSTALLED CONFIGURATION DATA =========");
        System.out.println("");
       //failedTests = new ArrayList<>();

        LogUtils.info("Starting Suite: " + iSuite.getName());
    }

    @Override
    public void onFinish(ISuite iSuite) {
        LogUtils.info("End Suite: " + iSuite.getName());
        WebUI.stopSoftAssertAll();

        ExtentReportManager.flushReports();

        ZipUtils.zipReportFolder();

        TelegramManager.sendReportPath();

       // EmailSendUtils.sendEmail(count_totalTCs, count_passedTCs, count_failedTCs, count_skippedTCs,failedTests);
        EmailSendUtils.sendEmail(count_totalTCs, count_passedTCs, count_failedTCs, count_skippedTCs);
        AllureEnvironmentWriter.allureEnvironmentWriter(ImmutableMap.<String, String>builder().put("Test URL", FrameworkConstants.URL_CRM).put("Target Execution", FrameworkConstants.TARGET).put("Global Timeout", String.valueOf(FrameworkConstants.WAIT_DEFAULT)).put("Page Load Timeout", String.valueOf(FrameworkConstants.WAIT_PAGE_LOADED)).put("Headless Mode", FrameworkConstants.HEADLESS).put("Local Browser", String.valueOf(Browser.CHROME)).put("Remote URL", FrameworkConstants.REMOTE_URL).put("Remote Port", FrameworkConstants.REMOTE_PORT).put("TCs Total", String.valueOf(count_totalTCs)).put("TCs Passed", String.valueOf(count_passedTCs)).put("TCs Skipped", String.valueOf(count_skippedTCs)).put("TCs Failed", String.valueOf(count_failedTCs)).build());

        FileHelpers.copyFile("src/test/resources/config/allure/categories.json", "target/allure-results/categories.json");
        FileHelpers.copyFile("src/test/resources/config/allure/executor.json", "target/allure-results/executor.json");

    }

    public AuthorType[] getAuthorType(ITestResult iTestResult) {
        if (iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class) == null) {
            return null;
        }
        AuthorType authorType[] = iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author();
        return authorType;
    }

    public CategoryType[] getCategoryType(ITestResult iTestResult) {
        if (iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class) == null) {
            return null;
        }
        CategoryType categoryType[] = iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category();
        return categoryType;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LogUtils.info("Test case: " + getTestName(iTestResult) + " is starting...");
        count_totalTCs = count_totalTCs + 1;

        ExtentReportManager.createTest(iTestResult.getName());
        ExtentReportManager.addAuthors(getAuthorType(iTestResult));
        ExtentReportManager.addCategories(getCategoryType(iTestResult));
        ExtentReportManager.addDevices();
        String testTag = iTestResult.getTestContext().getCurrentXmlTest().getName();
        ExtentReportManager.info(BrowserInfoUtils.getOSInfo());
       failedTests = new ArrayList<>();

        ExtentReportManager.info(testTag);
        if (VIDEO_RECORD.toLowerCase().trim().equals(YES)) {
            screenRecorder.startRecording(getTestName(iTestResult));
        }

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LogUtils.info("Test case: " + getTestName(iTestResult) + " is passed.");
        count_passedTCs = count_passedTCs + 1;

       
            CaptureHelpers.captureScreenshot(DriverManager.getDriver(), getTestName(iTestResult));
       //    ExtentReportManager.addScreenShot(Status.PASS, getTestName(iTestResult));

   

        //ExtentReports log operation for passed tests.
        ExtentReportManager.logMessage(Status.PASS, "Test case: " + getTestName(iTestResult) + " is passed.");

        if (VIDEO_RECORD.trim().toLowerCase().equals(YES)) {
            screenRecorder.stopRecording(true);
        }
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LogUtils.error("Test case: " + getTestName(iTestResult) + " is failed.");
        count_failedTCs = count_failedTCs + 1;

         //   CaptureHelpers.captureScreenshot(DriverManager.getDriver(), getTestName(iTestResult));
            ExtentReportManager.addScreenShot(Status.PASS, getTestName(iTestResult));

        

        if (VIDEO_RECORD.toLowerCase().trim().equals(YES)) {
            screenRecorder.stopRecording(true);
        }

        //Allure report screenshot file and log
        LogUtils.error("FAILED !! Screenshot for test case: " + getTestName(iTestResult));
        LogUtils.error(iTestResult.getThrowable());

        //Extent report screenshot file and log
        ExtentReportManager.addScreenShot(Status.FAIL, getTestName(iTestResult));
        ExtentReportManager.logMessage(Status.FAIL, iTestResult.getThrowable().toString());

        //AllureManager.takeScreenshotToAttachOnAllureReport();
        //AllureManager.saveTextLog(iTestResult.getThrowable().toString());

    }
//    @Override
//    public void onTestFailure(ITestResult iTestResult) {
//        LogUtils.error("Test case: " + getTestName(iTestResult) + " is failed.");
//        count_failedTCs++;
//
//        // Ensure the list is initialized
//        if (failedTests == null) {
//            failedTests = new ArrayList<>();
//        }
//
//        // Capture a screenshot if required
//        String screenshotPath = null;
//        if (SCREENSHOT_FAILED_STEPS.equals(YES)) {
//            screenshotPath = CaptureHelpers.captureScreenshot2(DriverManager.getDriver(), getTestName(iTestResult));
//        }
//
//        // Collect test case name, error details, and screenshot (if any)
//        String failureDetails = "<b><i>" + getTestName(iTestResult) + "</i></b> | Error: " 
//                                + iTestResult.getThrowable();
//        if (screenshotPath != null) {
//            failureDetails += " | <a href='" + screenshotPath + "'>Screenshot</a>";
//        }
//
//        // Add the failure details to the list
//        
//        failedTests.add(failureDetails);
//        
//        if (VIDEO_RECORD.toLowerCase().trim().equals(YES)) {
//            screenRecorder.stopRecording(true);
//        }
//
//        // Log the failure
//        LogUtils.error("FAILED !! Screenshot for test case: " + getTestName(iTestResult));
//        LogUtils.error(iTestResult.getThrowable());
//
//        // Add screenshot to Extent Report if applicable
//        if (screenshotPath != null) {
//            ExtentReportManager.addScreenShot(Status.FAIL, screenshotPath);
//        }
//        ExtentReportManager.logMessage(Status.FAIL, iTestResult.getThrowable().toString());
//    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LogUtils.warn("Test case: " + getTestName(iTestResult) + " is skipped.");
        count_skippedTCs = count_skippedTCs + 1;

        if (SCREENSHOT_SKIPPED_STEPS.equals(YES)) {
            CaptureHelpers.captureScreenshot(DriverManager.getDriver(), getTestName(iTestResult));
            failedTests = new ArrayList<>();
        }

        ExtentReportManager.logMessage(Status.SKIP, "Test case: " + getTestName(iTestResult) + " is skipped.");

        if (VIDEO_RECORD.toLowerCase().trim().equals(YES)) {
            screenRecorder.stopRecording(true);
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LogUtils.error("Test failed but it is in defined success ratio: " + getTestName(iTestResult));
        ExtentReportManager.logMessage("Test failed but it is in defined success ratio: " + getTestName(iTestResult));
    }

}
