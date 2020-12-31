package com.onemonthlearning.com.onemonthlearning;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day14JavaChallenge extends BaseTest {

	@Test
	public void specificWatchSearch() {

		launchBrowser("chrome", "https://www.snapdeal.com/");
		mouseOverToElement(locateElementByXpath("//span[text()='All Offers']"));
		mouseOverToElementAndClick(locateElementByXpath("//span[text()='Watches']"));
		pagedown();

		List<WebElement> watchPictureList = elementListByXpath("//picture[@class='picture-elem']//img");
		int picCount = watchPictureList.size();
	    LocalDate currentdate =takeSystemDate();

		for (int i = 0; i < picCount; i++) {
			String name = "image"+i+currentdate.toString().replace("-", "");
			takeElementScreenShot(name, watchPictureList.get(i));
		}
		String watchName = getText(locateElementByXpath("//div[text()='TRENDING']/../following-sibling::div[1]//a/p"));
		Assert.assertTrue(watchName.contains("Watch"));
		/*int lastButOneCount = picCount - 1;
		clickElement(locateElementByXpath("(//div[contains(@class,'comp-animated-icon')])[" + lastButOneCount + "]"));
		Assert.assertTrue(
				locateElement("xpath", "//form[@id='commonView']/../header").getText().contains("sign up on snapdeal"));
		clickElement(locateElement("id", "close-pop"));
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Mens Watches"));*/

		
		
	}

}
