package com.testcases;

import com.pages.HomePage;
import com.pages.OrderPage;
import com.pages.WomenSummerDressesPage;
import org.testng.annotations.Test;

public class verifyCheckOutJourney extends BaseTest{

	private WomenSummerDressesPage summerdresspage;
	private HomePage homepage;
	private OrderPage orderpage;
	
	@Test(description = "Verify guest user is able to successfully checkout the cart")
	public void verifyCheckOutJourneyE2E() {
		homepage =new HomePage();
		summerdresspage=new WomenSummerDressesPage();
		orderpage=new OrderPage();

		homepage.hoverOnWomenMenu();
		summerdresspage.clickOnSummerDressesLink();
		summerdresspage.verifySummareDressesPageDisplayed();
		summerdresspage.clickOnListViewOfProducts();
		summerdresspage.clickOnAddToCart();
		orderpage.proceedAsGuest();
		orderpage.registerAddress();
		orderpage.processShipping();
		orderpage.processPayment();
		orderpage.verifyConfirmOrder();
	}
}
