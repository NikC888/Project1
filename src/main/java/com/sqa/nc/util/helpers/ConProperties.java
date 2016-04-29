/**
 *   File Name: AppBasics.java<br>
 *
 *   Cui, Nicolas<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Apr 2, 2016
 *
 */
package com.sqa.nc.util.helpers;

import java.io.*;
import java.util.*;

/**
 * AppBasics //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Cui, Nicolas
 * @version 1.0.0
 * @since 1.0
 */
public class ConProperties {


	// method to load properties
	public static Properties loadProperties (String fileLocation) {
		Properties props = new Properties();
		try {
			InputStream is = new FileInputStream(fileLocation);
			props.load(is);
		} catch (Exception e) {
		}
		return props;
	}

	public static void main (String[] args) throws IOException {
		ConProperties read = new ConProperties();
		read.nonStaticEvalTextDataLines("data02.properties");
		Properties props = ConProperties.loadProperties("src/main/resources/data01.properties");

	}

	public ArrayList<String> nonStaticEvalTextDataLines (String textFileLoadLocation) throws IOException {
		System.out.println("-----------non static ver -------------------------------");
		Properties prop = new Properties();
		InputStream inputStream;
		inputStream = getClass().getClassLoader().getResourceAsStream(textFileLoadLocation);
		//		this.inputStream = getClass().getClassLoader().getResourceAsStream("data01.properties");
		if (inputStream != null) {
			prop.load(inputStream);
		}
		// get the property value and print it out
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		String memberID = prop.getProperty("memberid");
		String role = prop.getProperty("role");
		String department = prop.getProperty("department");
		System.out.println("Username: " + username + "\nPassword: " + password + "\nMemberID: " + memberID + "\nrole: " + role
				+ "\ndepartment: " + department);
		inputStream.close();
		return null;
	}
}
