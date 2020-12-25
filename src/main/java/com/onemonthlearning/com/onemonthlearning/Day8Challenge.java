package com.onemonthlearning.com.onemonthlearning;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day8Challenge extends BaseTest {
	
	public int searchCount(WebElement ele) {
		
		String intialResult = getText(ele);
		String[] resultSplit = intialResult.split(" ");
		int count = Integer.parseInt(resultSplit[5].replace(",", ""));
		System.out.println(count);
		return count;
		
	}

	@Test
	public void compareProducts() {
		launchBrowser("chrome", "https://www.flipkart.com/");
		clickElement(locateElement("xpath", "//body[@class='fk-modal-visible']/div[2]//button"));
		typeEnter(locateElement("xpath", "//input[@title='Search for products, brands and more']"), "Home Theaters");
		pageLoadedFully();
		int intialCount = searchCount(locateElement("xpath", "//span[text()='Sort By']/../../span"));
		clickElement(locateElement("xpath", "//div[@title='4★ & above']//label/div[1]"));
		pageLoadedFully();
		int countAfterFilter = searchCount(locateElement("xpath", "//span[text()='Sort By']/../../span"));
		Assert.assertTrue(countAfterFilter<intialCount);
		clickElement(locateElement("xpath", "//div[text()='Price -- High to Low']"));
		List<WebElement> priceList = elementListByXpath("//a[@target='_blank']/following-sibling::a[2]/div[1]/div[1]");
		
		
		
		
		
		
		/*String color = locateElement("xpath", "//div[text()='Price -- High to Low']").getCssValue("color");
		System.out.println(color);
		
		//Converting the color code of the text
		String[] hexValue = color.replace("rgba(","").replace(")", "").split(",");    
		hexValue[0]=hexValue[0].trim();
		int hexValue0 = Integer.parseInt(hexValue[0]);
		
		hexValue[1]=hexValue[1].trim();
		int hexValue1 = Integer.parseInt(hexValue[1]);
		
		hexValue[2]=hexValue[2].trim();
		int hexValue2 = Integer.parseInt(hexValue[2]);
		String actualcolor = String.format("%02x%02x%02x", hexValue0,hexValue1,hexValue2);
		System.out.println(actualcolor);*/

		

		
	
	}
}
