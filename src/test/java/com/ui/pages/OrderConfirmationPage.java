package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class OrderConfirmationPage extends BrowserUtility {
	private static final By ORDER_SUCCESS_TEXT_LOCATOR = By.xpath("//p[contains(@class, 'alert-success')]");

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
	}

	public String getOrderSuccessText() {
		return getVisibleText(ORDER_SUCCESS_TEXT_LOCATOR);
	}

}
