package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browsers;
import com.constants.ENV;
import com.utility.BrowserUtility;
import com.utility.JsonUtil;
import com.utility.LoggerUtility;
import com.utility.PropertiesUtil;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign\")]");

	public HomePage(Browsers browserName, boolean isHeadless) {
		super(browserName, isHeadless);
		goToWebsite(JsonUtil.readFromJson(ENV.QA).getUrl());
	}

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JsonUtil.readFromJson(ENV.QA).getUrl());

	}

	public LoginPage goToLoginPage() {
		logger.info("Trying to click to go to Sign in Page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;

	}

}
