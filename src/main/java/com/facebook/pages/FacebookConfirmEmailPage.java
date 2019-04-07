package com.facebook.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.facebook.util.Log;

public class FacebookConfirmEmailPage extends BasePage
{
	
	public FacebookConfirmEmailPage(WebDriver driver)
	{
		super(driver);
	}
	
	 
	  @FindBy(how = How.CSS, using = "h2.uiHeaderTitle")
	    public WebElement confirmEmail;
	 
	  
	  public FacebookConfirmEmailPage VerifyConfirmPage(String confirmText)
	  {
		  try
		  {
			  Assert.assertEquals(readText(confirmEmail),confirmText);
			  return GetInstance(FacebookConfirmEmailPage.class);
			  
		  }
		  catch(Exception e)
		  {
			  Log.fatal("ProfileName Displayed is "+confirmEmail.getText()+" Exception "+ e.getMessage());
			  
			   return null;
		  }
		  
		   
	  }
	  
	 
	  
	  
}



