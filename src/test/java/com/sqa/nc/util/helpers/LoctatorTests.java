package com.sqa.nc.util.helpers;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.*;
import org.testng.annotations.*;

public class LoctatorTests {

	static WebDriver driver;

	@DataProvider
	public Object[][] data () {
		return new Object[][] {
				new Object[] { "a", "aa" },
				new Object[] { "b", "bb" },
				new Object[] { "c", "cc" },
		};
	}

	@BeforeClass (enabled = true, groups = "firefox")
	public void setUpFirefox () throws InterruptedException {
		driver = new FirefoxDriver();
	}

	@Test (priority = 1) //(dataProvider = "data")
	public void test1 () {
		List<WebElement> links = Locator.getLinks(this.driver);
		int i = 1;
		for (WebElement link : links) {
			String text = link.getText();
			if (text.equals("")) {
				text = "Non-text Element (" + i + ")";
				i++;
			}
			System.out.println(link.getText() + " - " + link.getAttribute("href"));
		}
	}

	@Test (priority = 0) //(dataProvider = "data")
	public void test2 () {
		String pageTitle = "MSN.com - Hotmail, Outlook, Skype, Bing, Latest News, Photos & Videos";
		driver.get("http://msn.com");
		Assert.assertEquals(driver.getTitle(), pageTitle, "Page load does not seem succesful.");
	}
}
