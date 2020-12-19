package com.onemonthlearning.com.onemonthlearning;

import java.util.NoSuchElementException;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseTest {
	public static RemoteWebDriver driver;

	public RemoteWebDriver launchBrowser(String browser) {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browser);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		/*if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver(options);
		} else {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}*/
		switch(browser) {
		case ("chrome"):
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			return driver = new ChromeDriver(options);
		case ("edge"):
			System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
			return driver = new EdgeDriver();
		}
	
	
		
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

		}catch (WebDriverException e) {
			System.out.println("Exception occured on locate elements : "+ locValue);

		}
		return null;
	}
	
	public void typeEnterTab(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			ele.sendKeys(Keys.ENTER);
			ele.sendKeys(Keys.TAB);
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
		} catch (InvalidElementStateException e) {
			System.out.println("Invalid element exception occured on element type");
		} catch (WebDriverException e) {
			System.out.println("Invalid element exception occured on element type");

		}
	}
	
	
	public void clickElement(WebElement ele) {
		try {
			ele.click();
		} catch (InvalidElementStateException e) {
			System.out.println("Exception occured on element click : "+ ele);
		} catch (WebDriverException e) {
			System.out.println("Exception occured on element click: "+ ele);

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
	
}
