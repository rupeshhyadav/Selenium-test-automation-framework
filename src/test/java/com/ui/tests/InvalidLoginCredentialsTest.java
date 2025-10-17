package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojos.InvalidUser;
import com.utility.LoggerUtility;

@Listeners({ com.ui.listeners.TestListener.class })
public class InvalidLoginCredentialsTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Test(description = "Verify invalid user credentail login", groups = { "e2e", "smoke", "negative" },dataProviderClass=com.ui.dataProviders.LoginDataProvider.class,dataProvider="InvalidLoginTestDataProvider")
	public void invalidLoginCredentialsTest(InvalidUser invalidUser) {
		//System.out.println(invalidUser.getInvalidEmailAddress());
		Assert.assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(invalidUser.getInvalidEmailAddress(), invalidUser.getInvalidPassword()).getErrorMessage(), "Authentication failed.");
		

	}

}
