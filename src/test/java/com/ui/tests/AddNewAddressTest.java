package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojos.AddressPojo;
import com.utility.FakerUtility;
import com.utility.LoggerUtility;

public class AddNewAddressTest extends TestBase {
	Logger logger = LoggerUtility.getLogger(getClass());
	MyAccountPage myaccountPage;
	AddressPojo address;

	@BeforeMethod(description = "Valid first time user logs in to the application")
	public void setUp() {
		myaccountPage = homePage.goToLoginPage().doLoginWith("maren27445@aperiol.com", "Rup0101**");
		address = FakerUtility.getFakerData();
	}

	@Test(description="verify first time user is able to save to address",groups = {
			"e2e", "sanity" })
	public void addNewAddress() {
		String addressHeaderText = myaccountPage.goToAddressPage().saveAddress(address);
		Assert.assertEquals(addressHeaderText, "MY ADDRESS"+address.getAlias().toUpperCase());
	}

}
