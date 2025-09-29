package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " PASSED");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " PASSED");

	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReportUtility.getTest().log(Status.FAIL,
				result.getMethod().getMethodName() + result.getThrowable().getMessage() + "FAILED");
		Object testClass = result.getInstance();
		BrowserUtility browserutility = ((TestBase)testClass).getInstance();
		logger.info("Capturing screenshot-------");
		String screenshotPath = browserutility.takeScreenShot(result.getMethod().getMethodName());
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);

	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " SKIPPED");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");

	}

	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
		ExtentReportUtility.setUpSparkReporter();
	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed");
		ExtentReportUtility.flushReports();

	}
}
