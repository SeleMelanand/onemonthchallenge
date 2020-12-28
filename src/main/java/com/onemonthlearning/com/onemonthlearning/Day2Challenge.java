package com.onemonthlearning.com.onemonthlearning;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Day2Challenge extends BaseTest {
	@Test
	public void furnitureSearch() {
		launchBrowser("chrome", "http://amazon.in/");
		selectValuedd(locateElement("id", "searchDropdownBox"), "Furniture");
		typeEnter(locateElement("id", "twotabsearchtextbox"), "chairs for computer table");
		List<WebElement> pricelist = elementListByXpath("//span[@class='a-price'][1]/span[2]/span[2]");
		int temp = 0;
		for (int i = 0; i < pricelist.size(); i++) {
			String priceVal = pricelist.get(i).getText().replace(",", "");
			//System.out.println(priceVal);
			
			int priceValue = Integer.parseInt(priceVal);
			if(priceValue>temp) {
				temp = priceValue;
			}
		}
		System.out.println(temp);
	}

}
