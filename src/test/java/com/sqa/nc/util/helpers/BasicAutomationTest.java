package com.sqa.nc.util.helpers;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

public class BasicAutomationTest {

	private String baseURL = "http://google.com";
	private Properties devProps;
	private String devPropsLocation = "src/main/resources/dev.properties";
	private Properties sharedMapUI;
	private String sharedMapUILocation = "src/main/resources/shared-map-ui.properties";

	@DataProvider
	public Object[][] dp () {
		return new Object[][] {
				new Object[] { 1, "aa" },
				new Object[] { 2, "bb" },
				new Object[] { 3, "cc" },
		};
	}

	@BeforeClass
	public void loadProperties () {
		this.sharedMapUI = ConProperties.loadProperties(this.sharedMapUILocation);
		//		this.sharedMapUI = ConProperties.loadProperties(this.devPropsLocation);
		this.devProps = ConProperties.loadProperties(this.devPropsLocation);

	}

	@Test (priority = 1)
	public void setUpTest () {
		//setup webdriver
		WebDriver driver = new FirefoxDriver();
		driver.get(this.baseURL);
	}

	@Test (dataProvider = "dp", priority = 69)
	public void test (Integer n, String s) {
		System.out.println("test: " + n);
	}

	@Test (priority = 0)
	public void testLogin () {
		// Test logging in into EBay...
		System.out.println("test login ing ");
		String baseURL = this.sharedMapUI.getProperty("baseurl");
		System.out.println(baseURL);
	}
}
