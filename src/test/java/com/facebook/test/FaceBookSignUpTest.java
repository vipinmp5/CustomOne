package com.facebook.test;
import static org.testng.Assert.assertTrue;





import org.testng.annotations.Test;

import com.facebook.pages.*;
import com.facebook.util.PropertyManager;
import com.facebook.util.Utility;

@Module(module = "WalletHub")
public class FaceBookSignUpTest extends BaseTest {

	
	@Test
	@TestInfo(risk=TestInfo.Risk.MEDIUM)
	public void validCredentialsSignUpTest() {
		  
			page.GetInstance(FacebookLoginPage.class).getBaseURL();
			page.GetInstance(FacebookLoginPage.class).
					EnterFirstName(firstName)
					.EnterLastName(lastName)
					.EnterEmail(emailID)
					.EnterConfirmationEmail(emailID)
			        .EnterNewPassword(password)
			        .selectDay(day)
			        .selectMonth(month)
			        .selectYear(year)
			        .selectGender(gender)
			        .clickSignUpButton()
			        .VerifyConfirmPage("Confirm your email address");
			
			
		}
		
		
		

		
	
}
