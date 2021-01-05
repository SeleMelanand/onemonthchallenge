package com.onemonthlearning.com.onemonthlearning;

import org.testng.annotations.Test;

public class Day6Challenge extends BaseTest {

	@Test(groups = { "seleniumProgram"})
	public void getProductCount() {
		launchBrowser("chrome", "https://www.myntra.com/");
		System.out.println(driver.manage().window().getSize());
		typeEnter(locateElement("xpath", "//div[@class='desktop-query']/input"), "Sunglasses");
		clickElement(locateElement("xpath", "//span[text()='Brand']/../div[2]"));
		typeEnter(locateElement("xpath", "//div[contains(@class,'FilterDirectory-expanded')]//input"), "pola");
		clickElement(locateElement("xpath", "//div[contains(@class,'FilterDirectory-expanded')]/div[2]//div"));
		clickElement(locateElement("xpath", "//span[contains(@class,'FilterDirectory-close sprites-remove')]"));
		clickElement(locateElement("xpath", "//ul[@class='gender-list']/li[1]//label"));
		clickElement(locateElement("xpath", "//div[@class='atsa-more']/span"));
		clickElement(locateElement("xpath", "//input[@value='Type']/../h4"));
		clickElement(locateElement("xpath", "//input[@value='Rectangle Sunglasses']/../div"));
		pagedown();
		mouseOverToElement(locateElement("xpath", "//li[@class='product-base'][1]"));
		mouseOverToElementAndClick(locateElement("xpath", "//li[@class='product-base'][1]/div[2]/span[2]"));
		int similarProductCount = elementCount("//div[@class='results-similarItemContainer']//li");
		System.out.println("Total number of similar products : "+similarProductCount);

	}
}
