package com.testcases;

import org.testng.annotations.Test;
import com.pages.HomePage;

public class verifyHeaderAndFooterInMultiplePages extends BaseTest{

	private HomePage homepage;
	
	@Test(description = "Navigate to multiple pages of the website and verify for header and footer availability")
	public void verifyHeaderAndFooter() {
		homepage=new HomePage();
		homepage.isHeaderDisplayed();
		homepage.isFooterDisplayed();

		homepage.clickOnSignIn();
		homepage.isHeaderDisplayed();
		homepage.isFooterDisplayed();

		homepage.clickOnWomenMenu();
		homepage.isHeaderDisplayed();
		homepage.isFooterDisplayed();
	}
}
