package com.ui.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {
	private static final By USERNAME_TEXT_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
	private static final By SEARCH_BOX_LOCATOR = By.xpath("//form[@id='searchbox']/input[@id='search_query_top']");
	private static final By ADD_ADDRESS_LINK_LOCATOR = By.xpath("//span[contains(text(),'Add my first address')]");

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public String getUserName() {
		return getVisibleText(USERNAME_TEXT_LOCATOR);
	}

	public SearchResultPage searchForAProdcut(String productName) {
		enterText(SEARCH_BOX_LOCATOR, productName);
		enterSpecialKey(SEARCH_BOX_LOCATOR, Keys.ENTER);
		SearchResultPage searchResultPage = new SearchResultPage(getDriver());
		return searchResultPage;
	}

	public AddressPage goToAddressPage() {
		clickOn(ADD_ADDRESS_LINK_LOCATOR);
		AddressPage addressPage = new AddressPage(getDriver());
		return addressPage;
	}

}
