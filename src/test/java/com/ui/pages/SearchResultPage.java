package com.ui.pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {
	private static final By SEARCH_TEXT_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");
	private static final By PRODUCTS_NAMES_TEXT_LOCATOR = By.xpath("//h5[@itemprop='name']/a");

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	public String getSearchResultTitleText() {
		return getVisibleText(SEARCH_TEXT_TITLE_LOCATOR);

	}

	public boolean isSearchTextPresentInProductList(String searchKeyword) {
		List<String> allProductTextList = getAllVisibleText(PRODUCTS_NAMES_TEXT_LOCATOR);
		List<String> keywords = Arrays.asList(searchKeyword.toLowerCase().split(" "));
		boolean isTextMatched = allProductTextList.stream()
				.anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
		return isTextMatched;

	}

	public ProductDetailPage clickOnSelectedProductAt(int index) {
		clickOn(getAllElements(PRODUCTS_NAMES_TEXT_LOCATOR).get(index));
		ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
		return productDetailPage;

	}

}
