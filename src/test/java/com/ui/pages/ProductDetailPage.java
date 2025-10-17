package com.ui.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility {
	private static final By SIZE_DROPDOWN_LOCATOR = By.id("group_1");
	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.name("Submit");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//a[@title='Proceed to checkout']");

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}

	public ProductDetailPage updateProductSize() {
		selectDropDownValueByVisibleText(SIZE_DROPDOWN_LOCATOR, "L");
		ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
		return productDetailPage;
	}

	public ProductDetailPage addToCart() {
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
		return productDetailPage;
	}

	public ShoppingCartPage proceedToCheckout() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());
		return shoppingCartPage;

	}

}
