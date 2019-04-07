package com.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.facebook.util.Log;

public class FacebookLoginPage extends BasePage
{
	public FacebookLoginPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(how=How.ID,using="email")
	public WebElement UserName;
	
	@FindBy(how=How.ID,using="pass")
	public WebElement Password;
	
	@FindBy(how=How.XPATH,using="//input[@value='Log In']")
	public WebElement LogIn;
	
	@FindBy(how=How.CSS,using="input[name=firstname]")
	public WebElement FirstName;
	
	@FindBy(how=How.CSS,using="input[name=lastname]")
	public WebElement LastName;
	
	@FindBy(how=How.CSS,using="input[name=reg_email__]")
	public WebElement EmalOrPhone;
	
	@FindBy(how=How.CSS,using="input[name=reg_email_confirmation__]")
	public WebElement ConfirmEmailOrPhone;
	
	@FindBy(how=How.CSS,using="input[name=reg_passwd__]")
	public WebElement NewPassword;
	
	@FindBy(how=How.CSS,using="select[name=birthday_day]")
	public WebElement BirthDay;
	
	@FindBy(how=How.CSS,using="select[name=birthday_month]")
	public WebElement BirthMonth;
	
	@FindBy(how=How.CSS,using="select[name=birthday_year]")
	public WebElement BirthYear;
	
	@FindBy(how=How.CSS,using="input[type=radio][value='1']")
	public WebElement Female;
	
	@FindBy(how=How.CSS,using="input[type=radio][value='2']")
	public WebElement Male;
	
	@FindBy(how=How.CSS,using="button[name=websubmit]")
	public WebElement SignUp;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Please enter a valid mobile number or email address.')]")
	public WebElement invalidEmailAddressTextMessage;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Please choose a gender. You can change who can see this later.')]")
	public WebElement genderMissingErrorMessage;
	
	@FindBy(how=How.CSS,using="#reg_error_inner")
	public WebElement registrationErrorMessage;


	public FacebookHomePage LoginToFaceBookAccount(String facebookMail,String Password)
	{
		writeText(UserName, facebookMail);
		writeText(Password,Password);
		click(LogIn);
		 return GetInstance(FacebookHomePage.class);
	}
	
	public void getBaseURL(){
		driver.get("http://www.facebook.com/");
	}
	
	public FacebookLoginPage EnterFirstName(String firstName){
		writeText(this.FirstName, firstName);
		return GetInstance(FacebookLoginPage.class);
	}
	
	public FacebookLoginPage EnterLastName(String lname){
		writeText(this.LastName, lname);
		return GetInstance(FacebookLoginPage.class);
	}
	
	public FacebookLoginPage EnterEmail(String email){
		writeText(this.EmalOrPhone, email);
		return GetInstance(FacebookLoginPage.class);
	}
	
	public FacebookLoginPage EnterConfirmationEmail(String email){
		writeText(this.ConfirmEmailOrPhone, email);
		return GetInstance(FacebookLoginPage.class);
	}
	
	public FacebookLoginPage EnterNewPassword(String password){
		writeText(this.NewPassword, password);
		return GetInstance(FacebookLoginPage.class);
	}
	
	public FacebookLoginPage selectDay(String day){
		selectElement(BirthDay,day);
		return GetInstance(FacebookLoginPage.class);
	}
	
	public FacebookLoginPage selectMonth(String month){
		selectElement(BirthMonth,month);
		return GetInstance(FacebookLoginPage.class);
	}
	
	public FacebookLoginPage selectYear(String year){
		selectElement(BirthYear,year);
		return GetInstance(FacebookLoginPage.class);
	}
	
	public FacebookLoginPage selectGender(String gender){
		if(gender=="male"){
			this.Male.click();
		}
		else{
			this.Female.click();
		}
		return GetInstance(FacebookLoginPage.class);
	}
	
	public FacebookConfirmEmailPage clickSignUpButton(){
		this.SignUp.click();
		return GetInstance(FacebookConfirmEmailPage.class);
	}
}


