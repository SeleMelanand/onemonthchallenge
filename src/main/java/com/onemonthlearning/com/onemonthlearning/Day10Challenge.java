package com.onemonthlearning.com.onemonthlearning;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day10Challenge extends BaseTest {
	@Test(groups = { "seleniumProgram"})
	public void searchProductAndSort() {
		launchBrowser("chrome", "https://www.ajio.com/");
		// clickElement(locateElementByXpath("//button[text()='Allow Location']"));
		mouseOverToElement(locateElementByXpath("//a[text()='WOMEN']"));
		mouseOverToElement(locateElementByXpath("//a[text()='WOMEN']/../div/ul/li[2]/a"));
		List<WebElement> productlist = elementListByXpath(
				"//a[text()='WOMEN']/../div/ul/li[2]//div/div/div/div/div[2]//a");
		int updatedLowerCount = 0;
		String lessLowerCaseName = null;

		for (WebElement productname : productlist) {
			int lowercount = 0;

			int displayTextSize = productname.getText().length();

			for (int i = 0; i < displayTextSize; i++) {
				char chr = productname.getText().charAt(i);
				if (chr >= 'a' && chr <= 'z')
					lowercount++;
			}

			if (lowercount > updatedLowerCount) {
				lessLowerCaseName = productname.getText();
				updatedLowerCount = lowercount;
			}

		}
		System.out.println(lessLowerCaseName + " :: " + lessLowerCaseName.length());

		for (WebElement selectProductName : productlist) {
			if (selectProductName.getText().equalsIgnoreCase(lessLowerCaseName)) {
				clickElement(selectProductName);
				break;
			}

		}
		waitForSpecElement(locateElement("class", "header2"));
		String itemCount = getText(locateElementByXpath("//div[@class='filter-container']/div/div[1]"));
		String intialItemVal = itemCount.split(" ")[0].replace(",", "");
		System.out.println(intialItemVal);

		clickElement(locateElementByXpath("//span[text()='size & fit']"));

		clickElement(locateElementByXpath("//input[@id=\"S\"]/../label"));
		waitForSpecElement(locateElement("class", "header2"));
		String itemCountAfterFilter = getText(locateElementByXpath("//div[@class='filter-container']/div/div[1]"));
		String ItemValAfterFilter = itemCountAfterFilter.split(" ")[0].replace(",", "");
		System.out.println(ItemValAfterFilter);
		Assert.assertTrue(Integer.parseInt(ItemValAfterFilter) < Integer.parseInt(intialItemVal));

		selectValuedd(locateElementByXpath("//div[@class='filter-dropdown']/select"), "Discount");

	}

}
