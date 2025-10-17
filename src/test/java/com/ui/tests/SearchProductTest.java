package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.utility.LoggerUtility;

public class SearchProductTest extends TestBase {
	Logger logger = LoggerUtility.getLogger(getClass());
	private MyAccountPage myAccountPage;
	String searchKeyword = "Printed Summer Dress";

	@BeforeMethod(description = "Valid user logs in to the application")
	public void setUp() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("maren27445@aperiol.com", "Rup0101**");

	}

	@Test(description = "Verify if logged in user is able to search for a product and correct search results are displayed", groups = {
			"e2e", "sanity" })
	public void verifyProductSearchTest() {
		boolean isSearchTextMatched = myAccountPage.searchForAProdcut(searchKeyword).isSearchTextPresentInProductList(searchKeyword);
		Assert.assertEquals(isSearchTextMatched, true);

	}

}
