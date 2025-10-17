package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browsers;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LamdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLamdaTest;

	@Parameters({ "browser", "isLamdaTest", "isHeadless" })
	@BeforeMethod(description = "Load the home page of the website")
	public void setUp(@Optional("chrome") String browser, @Optional("false") boolean isLamdaTest,
			@Optional("false") boolean isHeadless, ITestResult result) {
		WebDriver lamdaDriver;
		this.isLamdaTest = isLamdaTest;
		if (isLamdaTest) {
			lamdaDriver = LamdaTestUtility.initializeLambaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lamdaDriver);

		} else {

			homePage = new HomePage(Browsers.valueOf(browser.toUpperCase()), isHeadless);
		}

	}

	public BrowserUtility getInstance() {
		return homePage;

	}

	@AfterMethod(description = "Tear down the browser")
	public void tearDown() {
		if (isLamdaTest) {
			LamdaTestUtility.quitSession();
		} else {
			homePage.quit();
		}

	}

}
