package com.onemonthlearning.com.onemonthlearning;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseTest {
	public static RemoteWebDriver driver;

	public RemoteWebDriver launchBrowser(String browser, String url) {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browser);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("gecko")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Browser launched and maximises successfully.");

		return null;

	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
			case ("id"):
				return driver.findElementById(locValue);
			case ("link"):
				return driver.findElementByLinkText(locValue);
			case ("xpath"):
				return driver.findElementByXPath(locValue);
			case ("name"):
				return driver.findElementByName(locValue);
			case ("class"):
				return driver.findElementByClassName(locValue);
			case ("tag"):
				return driver.findElementByTagName(locValue);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Exception occured on locate elements : " + locValue);

		} catch (WebDriverException e) {
			System.out.println("Exception occured on locate elements : " + locValue);

		}
		return null;
	}

	public void typeEnterTab(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			ele.sendKeys(Keys.ENTER);
			ele.sendKeys(Keys.TAB);
			System.out.println("Successfully typed in Element : " + ele);
		} catch (InvalidElementStateException e) {
			System.out.println("Invalid element exception occured on element type");

		} catch (WebDriverException e) {
			System.out.println("Invalid element exception occured on element type");

		}
	}

	public void typeEnter(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			ele.sendKeys(Keys.ENTER);
			System.out.println("Successfully typed in Element : " + ele);
		} catch (InvalidElementStateException e) {
			System.out.println("Invalid element exception occured on element type");
		} catch (WebDriverException e) {
			System.out.println("Invalid element exception occured on element type");

		}
	}

	public void clickElement(WebElement ele) {
		try {
			ele.click();
			System.out.println("Element Clicked Successfully: " + ele);
		} catch (InvalidElementStateException e) {
			System.out.println("Exception occured on element click : " + ele);
		} catch (WebDriverException e) {
			System.out.println("Exception occured on element click: " + ele);

		}
	}

	public String getText(WebElement ele) {
		String bReturn = "";
		try {
			bReturn = ele.getText();
			System.out.println(bReturn);
		} catch (WebDriverException e) {
			System.out.println("Exception occured on get text");
		}
		return bReturn;
	}

	public void mouseOverToElement(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

	}

	public void mouseOverToElementAndClick(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().build().perform();
	}

	public void pagedown() {
		// To scroll the page till the element is found
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		// js.executeScript("arguments[0].scrollIntoView();", ele);

	}

	public int elementCount(String locatorvalue) {
		List<WebElement> elementlist = driver.findElementsByXPath(locatorvalue);
		int eleCount = elementlist.size();
		return eleCount;
	}

	public void pageLoadedFully() {
		// getthe state whether page is loading or not
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String states = null;
		do {
			states = js.executeScript("return document.readyState").toString();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("Exception occured while pageis loading.."+ e);
			}
			System.out.println("pageloaded!!!: " + states);
		} while (states == "complete");
		System.out.println("pageloaded sucessfully");

	}
	
	public List<WebElement> elementListByXpath(String xpathValue) {
		List<WebElement> elementList = driver.findElementsByXPath(xpathValue);
		return elementList;
		
	}
	
	
}
