package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility{
	private static final By PAY_BY_BANK_WIRE_LOCATOR = By.xpath("//a[@class='bankwire']");
	private static final By CONFIRM_MY_ORDER_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'I confirm my order')]");

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	public OrderConfirmationPage payByBankWireAndConfirmOrder() {
		clickOn(PAY_BY_BANK_WIRE_LOCATOR);
		clickOn(CONFIRM_MY_ORDER_BUTTON_LOCATOR);
		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(getDriver());
		return orderConfirmationPage;
	}

}
