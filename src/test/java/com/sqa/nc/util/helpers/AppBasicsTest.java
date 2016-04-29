/**
 *   File Name: AppBasicsTest.java<br>
 *
 *   Cui, Nicolas<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Apr 2, 2016
 *
 */
package com.sqa.nc.util.helpers;

import org.testng.annotations.*;

/**
 * AppBasicsTest //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Cui, Nicolas
 * @version 1.0.0
 * @since 1.0
 */
public class AppBasicsTest {

	static String appName = "NC Test";
	static String username;

	@BeforeClass
	public static void setUpBeforeClass () throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass () throws Exception {
	}

	@BeforeMethod
	public void setUp () throws Exception {
	}

	@AfterMethod
	public void tearDown () throws Exception {
	}


	@Test (enabled = false, priority = 100)
	public void testFarewellUser () {
		AppBasics.farewellUser(username, appName);
	}

	@Test (priority = 1)
	public void testWelcomeUser () {
		username = AppBasics.welcomeUserAndGetUsername(appName);
	}
}
