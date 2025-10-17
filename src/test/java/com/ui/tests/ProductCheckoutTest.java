package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.SearchResultPage;
import com.utility.LoggerUtility;

public class ProductCheckoutTest extends TestBase {
	Logger logger = LoggerUtility.getLogger(getClass());
	String searchKeyword = "Printed Summer Dress";
	SearchResultPage searchResultPage;

	@BeforeMethod(description = "Valid user logs in to the application")
	public void setUp() {
		searchResultPage = homePage.goToLoginPage().doLoginWith("maren27445@aperiol.com", "Rup0101**")
				.searchForAProdcut(searchKeyword);
	}

	@Test(description = "verify that user is able to checkout the selected product", groups = { "e2e", "sanity" })
	public void checkoutTest() {
		String orderSummaryText = searchResultPage.clickOnSelectedProductAt(2).updateProductSize().addToCart().proceedToCheckout()
				.goToConfirmAddressPage().goToShippingPage().goToPaymentPage().payByBankWireAndConfirmOrder()
				.getOrderSuccessText();
		Assert.assertTrue(orderSummaryText.contains("complete"));

	}

}
