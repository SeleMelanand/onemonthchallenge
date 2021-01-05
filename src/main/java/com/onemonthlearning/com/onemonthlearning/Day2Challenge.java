package com.onemonthlearning.com.onemonthlearning;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Day2Challenge extends BaseTest {
	@Test(groups = { "seleniumProgram"})
	public void furnitureSearch() {
		launchBrowser("chrome", "http://amazon.in/");
		selectValuedd(locateElement("id", "searchDropdownBox"), "Furniture");
		typeEnter(locateElement("id", "twotabsearchtextbox"), "chairs for computer table");
		List<WebElement> elementlist =elementListByXpath("//div[contains(@class,'a-section a-spacing-medium')]");
		
		List<WebElement> priceList = elementListByXpath("//span[@class='a-price'][1]/span[2]/span[2]");
		List<WebElement> ratingList = elementListByXpath("(//div[@class='a-section a-spacing-medium'])//div[3]//span/span");
		
		int temp = 0;
		int indexVal = 0;
		int val =0;
		for (int i = 0; i < elementlist.size(); i++) {
			System.out.println((priceList.get(i).isDisplayed()));
			System.out.println(ratingList.get(i).isDisplayed());
			if(priceList.get(i).isDisplayed()&&ratingList.get(i).isDisplayed()) {
			
			String priceVal = priceList.get(i).getText().replace(",", "");
			int priceValue = Integer.parseInt(priceVal);
			if (priceValue > temp) {
				temp = priceValue;
				indexVal = i;
			}
		}
		System.out.println(temp + " : " + indexVal);
		val = indexVal+1;
		System.out.println(val);
		}
		
		mouseOverToElement(
				locateElementByXpath("(//div[@class='a-section a-spacing-medium'])[" + val + "]//div[3]//span/span"));
		pageLoadedFully();
		String ratingCountText = getText(locateElementByXpath("//span[contains(@class,'totalRatingCount')]"));
		String[] ratingCountString = ratingCountText.split(" ");
		int ratingCount = Integer.parseInt(ratingCountString[0]);

		String percentval = getText(locateElementByXpath("//table[@id='histogramTable']//td[3]//a"));
		int fivestarpercent = Integer.parseInt(percentval.replace("%", ""));
		
		double percent = ratingCount/fivestarpercent;
		System.out.println(percent);
		
		
	
	}

}
