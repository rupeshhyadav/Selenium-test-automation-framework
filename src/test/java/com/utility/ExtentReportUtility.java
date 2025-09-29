package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	private static ExtentReports extentReports; // heavy lifting - dump the data and create html file
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // stores the information about
																						// tests;

	public static void setUpSparkReporter() {

		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentReport.html");// create
																													// style
																													// /
																													// look
																													// in
																													// html
		extentReports = new ExtentReports();
		extentReports.attachReporter(spark);

	}

	public static void createExtentTest(String testName) {
		ExtentTest test = extentReports.createTest(testName);
		extentTest.set(test);

	}

	public static ExtentTest getTest() {
		return extentTest.get();
	}

	public static void flushReports() {
		extentReports.flush();
	}

}
