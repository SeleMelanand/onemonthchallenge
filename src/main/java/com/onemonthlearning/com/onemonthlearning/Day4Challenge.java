package com.onemonthlearning.com.onemonthlearning;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Day4Challenge extends BaseTest {
	@Test(groups = { "seleniumProgram"})
	public void printBusCount() {
		/* In Redbus website, search for buses between bangalore and chennai and print
		 the count of buses getting displayed*/
		launchBrowser("chrome","https://www.redbus.in/");
		typeEnter(locateElement("id", "src"), "Bangalore");
		typeEnterTab(locateElement("id", "dest"), "Chennai");
		clickElement(locateElement("xpath", "//label[text()='Date']"));
		clickElement(locateElement("xpath", "//td[@class='next']"));
		clickElement(locateElement("xpath", "//table[@class='rb-monthTable first last']//tr[4]/td[1]"));
		// by normal selenium search
		//clickElement(locateElement("id", "search_btn"));
		
		/*Actions builder = new Actions(driver);        
		builder.sendKeys(Keys.ENTER);*/
		
		//clickElement(locateElement("xpath", "//button[text()='Search Buses']"));
		//clickElement(locateElement("xpath", "//button[@class='fl button' and @id='search_btn']"));
		
		//Click search by Actions
		//Actions builder = new Actions(driver);
		//builder.moveToElement(locateElement("id", "search_btn")).click();
		
		System.out.println("search option  selected ");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("overlay-container")));
		clickElement(locateElement("class", "close"));
		List<WebElement> busElement = driver.findElementsByXPath("//div[@class='clearfix bus-item-details']");
		int countOfBuses = busElement.size();
		System.out.println("Displayed bus count : " + countOfBuses+1);

	}

}
