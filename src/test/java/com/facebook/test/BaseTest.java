package com.facebook.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.facebook.pages.BasePageGenerator;
import com.facebook.util.PropertyManager;
import com.facebook.util.Utility;
import com.github.javafaker.Faker;

public class BaseTest {

	public WebDriver driver;
	public WebDriverWait wait;
	public BasePageGenerator page;
	String BaseURL;
	Faker faker;
	public String firstName;
	public String emailID;
	public String lastName;
	public String password;
	public String day;
	public String month;
	public String year;
	public String gender;

	@BeforeMethod
	public void setup() {

		String chromePath = "./Chrome/";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", chromePath
				+ "chromedriver.exe");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, 15);
		page = new BasePageGenerator(driver);
		BaseURL = PropertyManager.getInstance().getBaseUrl();
		faker = new Faker();
		firstName = faker.name().firstName();
		//emailID = Utility.randomEmail(8);
		emailID = Utility.randomEmailFaker();
		lastName = faker.name().lastName();
		password= PropertyManager.getInstance().getPassword();
		day = PropertyManager.getInstance().getDay();
		month = PropertyManager.getInstance().getMonth();
		year = PropertyManager.getInstance().getYear();
		gender = PropertyManager.getInstance().getGender();

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
