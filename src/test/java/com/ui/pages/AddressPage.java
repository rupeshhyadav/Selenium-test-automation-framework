package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojos.AddressPojo;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {
	private static final By ADDRESS_1_FIELD_LOCATOR = By.id("address1");
	private static final By CITY_FIELD_LOCATOR = By.id("city");
	private static final By STATE_FIELD_LOCATOR = By.id("id_state");
	private static final By POSTALCODE_FIELD_LOCATOR = By.id("postcode");
	private static final By COUNTRY_FIELD_LOCATOR = By.id("id_country");
	private static final By HOMEPHONE_FIELD_LOCATOR = By.id("phone");
	private static final By SUBMITADDRESS_BUTTON_LOCATOR = By.id("submitAddress");
	private static final By ADDRESS_ALIAS_FIELD_LOCATOR = By.id("alias");
	private static final By ADDRESS_HEADING_TEXT_LOCATOR = By.className("page-subheading");

	public AddressPage(WebDriver driver) {
		super(driver);
	}

	public String saveAddress(AddressPojo address) {
		enterText(ADDRESS_1_FIELD_LOCATOR, address.getAddress1());
		enterText(CITY_FIELD_LOCATOR, address.getCity());
		selectDropDownValueByVisibleText(STATE_FIELD_LOCATOR, address.getState());
		enterText(POSTALCODE_FIELD_LOCATOR, address.getPostalCode());
		enterText(HOMEPHONE_FIELD_LOCATOR, address.getHomePhoneNumber());
		//clearText(ADDRESS_ALIAS_FIELD_LOCATOR);
		enterText(ADDRESS_ALIAS_FIELD_LOCATOR, address.getAlias());
		clickOn(SUBMITADDRESS_BUTTON_LOCATOR);
		return getVisibleText(ADDRESS_HEADING_TEXT_LOCATOR);

	}

}
