package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browsers;

public abstract class BrowserUtility {
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {
			System.err.println("Invalid browser name!!!");

		}
	}

	public BrowserUtility(Browsers browserName) {
		if (browserName == Browsers.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName == Browsers.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName == Browsers.EDGE) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}

	}

	public BrowserUtility(Browsers browserName, boolean isHeadless) {
		if (browserName == Browsers.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				// options.addArguments("--disable-dev-shm-usage");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

		} else if (browserName == Browsers.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else if (browserName == Browsers.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		}

	}

	public void goToWebsite(String url) {
		logger.info("opening the website url");

		driver.get().get(url);

	}

	public void maximizeWindow() {
		logger.info("Maximizing the window");
		driver.get().manage().window().maximize();
	}

	public void quit() {
		logger.info("Quitting the session");
		driver.get().quit();
	}

	public void clickOn(By locator) {
		logger.info("Finding element to click");
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();

	}

	public void clickOn(WebElement element) {

		element.click();

	}

	public void enterText(By locator, String textToEnter) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(textToEnter);

	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(keyToEnter);

	}

	public String getVisibleText(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.getText();

	}

	public String getVisibleText(WebElement element) {
		return element.getText();

	}

	public List<String> getAllVisibleText(By locator) {
		List<WebElement> elementList = driver.get().findElements(locator);
		List<String> searchTextList = new ArrayList<String>();
		for (WebElement element : elementList) {
			searchTextList.add(getVisibleText(element));
		}
		return searchTextList;
	}

	public List<WebElement> getAllElements(By locator) {
		List<WebElement> elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return elementList;
	}

	public void selectDropDownValueByVisibleText(By locator, String visibleText) {
		WebElement dropDown = driver.get().findElement(locator);
		Select select = new Select(dropDown);
		select.selectByVisibleText(visibleText);
	}

	public void clearText(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
	}

	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;

	}

}
