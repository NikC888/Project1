package com.sqa.nc.basicproject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.opera.*;
import org.testng.annotations.*;

public class GmailTest {

	// base url to do tests
	String baseUrl;// = "https://www.google.com/intl/en/mail/help/about.html";
	// webdriver instance, core component of selenium
	WebDriver driver;

	@DataProvider
	public Object[][] gmailAccounts () {
		return new Object[][] {
				new Object[] { "a", "aa" },
				new Object[] { "b", "bb" },
				new Object[] { "c", "cc" },
		};
	}

	@Test (dataProvider = "gmailAccounts")
	public void GmailTest (String username, String password) throws Exception {
		//goes to the baseURL plus any specific pages
		this.driver.get(this.baseUrl);
		// find element by "something" and then click it
		this.driver.findElement(By.id("Email")).sendKeys("isuzashi@gmail.com");
		this.driver.findElement(By.id("next")).click();
		this.driver.findElement(By.id("Passwd")).sendKeys("test password");
		this.driver.findElement(By.id("signin")).click();
		//
		this.driver.findElement(By.xpath("(//input[@value='Sign In'])[2]")).click();
		this.driver.findElement(By.id("ctl00__powerSearchControl__ptbKeywords")).clear();
		this.driver.findElement(By.id("ctl00__powerSearchControl__ptbKeywords")).sendKeys("QA engineer");
		//.clear - clears text space within  a text box
		//.sendKeys - send "text goes here" to text box
		this.driver.findElement(By.id("ctl00__powerSearchControl__btnSearch")).click();
		String resultMessage = this.driver.findElement(By.cssSelector("div#main h1")).getText();
		System.out.println("Message: " + resultMessage);
		this.driver.findElement(By.cssSelector("a[title=\"Sign Out\"]")).click();
		//Assert.assertEquals(resultMessage + " Jobs", keywords + " Jobs");
	}

	@BeforeClass (enabled = false, groups = "chrome")
	public void setUpChrome () throws InterruptedException {
		// set the class variable driver to the value of the chosen browser type, firefox
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		this.driver = new ChromeDriver();
		// specify the base url and store it in a string variable
		this.baseUrl = "https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier";
		// set implicit wait to 30 seconds
		Thread.sleep(1000);
	}

	@BeforeClass (enabled = true, groups = "edge")
	public void setUpEdge () throws InterruptedException {
		// set the class variable driver to the value of the chosen browser type, firefox
		System.setProperty("webdriver.edge.driver", "drivers/MicrosoftWebDriver.exe");
		this.driver = new EdgeDriver();
		// specify the base url and store it in a string variable
		this.baseUrl = "https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier";
		// set implicit wait to 30 seconds
		Thread.sleep(1000);
	}

	@BeforeClass (enabled = false, groups = "firefox")
	public void setUpFirefox () throws InterruptedException {
		this.driver = new FirefoxDriver();
		// specify the base url and store it in a string variable
		this.baseUrl = "https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier";
		// set implicit wait to 30 seconds
		Thread.sleep(1000);
	}

	@BeforeClass (enabled = false, groups = "ghostDriver")
	public void setUpGhostDriver () throws InterruptedException {
		// set the class variable driver to the value of the chosen browser type, firefox
		System.setProperty("webdriver.ghostdriver.driver", "drivers/phantomjs.exe");
		//this.driver = new PhantomJSDriver();
		// specify the base url and store it in a string variable
		this.baseUrl = "https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier";
		// set implicit wait to 30 seconds
		Thread.sleep(1000);
	}

	@BeforeClass (enabled = false, groups = "opera")
	public void setUpOpera () throws InterruptedException {
		// set the class variable driver to the value of the chosen browser type, firefox
		System.setProperty("webdriver.opera.driver", "drivers/operadriver.exe");
		this.driver = new OperaDriver();
		// specify the base url and store it in a string variable
		this.baseUrl = "https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier";
		// set implicit wait to 30 seconds
		Thread.sleep(1000);
	}
}
