package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ConfirmAddressPage extends BrowserUtility{
	private static final By PROCEED_TO_CHECKOUT_BUTTON_CONFIRM_ADDRESS_LOCATOR = By.xpath("//button//span[contains(text(),'Proceed to checkout')]");

	public ConfirmAddressPage(WebDriver driver) {
		super(driver);
	}
	
	public ShippingPage goToShippingPage() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_CONFIRM_ADDRESS_LOCATOR);
		ShippingPage shippingPage = new ShippingPage(getDriver());
		return shippingPage;
	}

}
