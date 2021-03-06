package com.facebook.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

	private static PropertyManager instance;
	private static String propertyFilePath = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\configuration.properties";
	private static String fuserName;
	private static String fpassword;
	private static String PostText;
	private static String DisplayName;
	private static String BASEURL;
	private static String WUserName;
	private static String WEmailDomain;
	private static String WPassword;
	private static String WDay;
	private static String WMonth;
	private static String WYear;
	private static String WGender;
	private static String WLName;

	// Create a Singleton instance. We need only one instance of Property
	// Manager.
	public static PropertyManager getInstance() {
		if (instance == null) {
			instance = new PropertyManager();
			instance.loadData();
		}

		return instance;
	}

	private void loadData() {

		Properties prop = new Properties();

		try {
			prop.load(new FileInputStream(propertyFilePath));
			// prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
		} catch (IOException e) {
			System.out.println("Configuration properties file cannot be found");
		}

		// Get properties from configuration.properties
		fuserName = prop.getProperty("fuserName");
		fpassword = prop.getProperty("fpassword");
		PostText = prop.getProperty("PostText");
		DisplayName = prop.getProperty("DisplayName");
		BASEURL = prop.getProperty("BASEURL");
		WUserName = prop.getProperty("WUserName");
		WPassword = prop.getProperty("WPassword");
		WDay = prop.getProperty("WDay");
		WMonth = prop.getProperty("WMonth");
		WYear = prop.getProperty("WYear");
		WGender = prop.getProperty("WGender");
		WLName = prop.getProperty("WLName");
		WEmailDomain = prop.getProperty("WEmailDomain");
	}

	public String getDay() {
		return WDay;
	}

	public String getMonth() {
		return WMonth;
	}

	public String getYear() {
		return WYear;
	}

	public String getGender() {
		return WGender;
	}

	public String getLastName() {
		return WLName;
	}

	public String getBaseUrl() {
		return BASEURL;
	}

	public String getFacebookUserName() {
		return fuserName;
	}

	public String getFacebookPassword() {
		return fpassword;
	}

	public String getPostData() {
		return PostText;
	}

	public String getFacebookName() {
		return DisplayName;
	}

	public String getWalletUsername() {
		return WUserName;
	}

	public String getPassword() {
		return WPassword;
	}

	public String getEmailDomain() {
		return WEmailDomain;
	}

}