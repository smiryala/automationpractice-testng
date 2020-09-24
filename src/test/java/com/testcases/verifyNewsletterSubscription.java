package com.testcases;

import com.pages.HomePage;
import org.testng.annotations.Test;

public class verifyNewsletterSubscription extends BaseTest{

	private HomePage homepage;
	
	@Test(description = "Verify user is successfully able to subscribe to newsletter")
	public void verifyNewsletterSubscriptionE2E() {
		homepage=new HomePage();
		homepage.inputNewsLetterEmail();
		homepage.submitNewsLetterEmail();
		homepage.verifyNewsLetterEmailSubscription();
	}
}
