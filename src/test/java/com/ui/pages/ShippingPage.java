package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippingPage extends BrowserUtility {
	private static final By TERMS_OF_SERVICE_CHECKBOX_LOCATOR = By.xpath("//label[@for='cgv']");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_SHIPPING_LOCATOR = By
			.xpath("//button//span[contains(text(),'Proceed to checkout')]");
	

	public ShippingPage(WebDriver driver) {
		super(driver);
	}

	public PaymentPage goToPaymentPage() {
		clickOn(TERMS_OF_SERVICE_CHECKBOX_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_SHIPPING_LOCATOR);
		PaymentPage paymentPage = new PaymentPage(getDriver());
		return paymentPage;

	}

}
