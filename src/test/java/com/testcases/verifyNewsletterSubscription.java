package com.testcases;

import com.pages.HomePage;
import com.pages.SignInPage;
import org.testng.annotations.Test;

public class verifyNewsletterSubscription extends BaseTest{
	
	SignInPage loginpage;
	HomePage homepage;
	
	@Test(description = "Verify user able to subscribe to newsletter")
	public void verifyNewsletterSubscription() {
		homepage=new HomePage();
		homepage.inputNewsLetterEmail();
		homepage.submitNewsLetterEmail();
		homepage.verifyNewsLetterEmailSubscription();
	}
}
