package com.ui.tests;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.Browser;
import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browsers;
import com.constants.ENV;
import com.ui.pages.HomePage;
import com.ui.pojos.User;
import com.utility.LoggerUtility;
import com.utility.PropertiesUtil;

@Listeners({ com.ui.listeners.TestListener.class })

public class LoginTest extends TestBase {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Test(description = "Verify valid user credentail login", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")

	public void loginTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Rupesh Yadav");

	}
//	@Test(description = "Verify valid user credential login", groups = { "e2e",
//	"sanity" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestCsvDataProvider")
//
//public void loginCSVTest(User user) {
//
//assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
//		"Rupesh Yadav");
//
//}
//	@Test(description = "Verify valid user credentail login", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestXlsxDataProvider")
//
//	public void loginXlsxTest(User user) {
//
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
//				"Rupesh Yadav");
//
//	}

}
