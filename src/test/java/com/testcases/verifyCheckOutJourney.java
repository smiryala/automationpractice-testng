package com.testcases;

import com.pages.HomePage;
import com.pages.OrderPage;
import com.pages.SignInPage;
import com.pages.WomenSummerDressesPage;
import org.testng.annotations.Test;

public class verifyCheckOutJourney extends BaseTest{

	WomenSummerDressesPage summerdresspage;
	HomePage homepage;
	OrderPage orderpage;
	
	@Test(description = " Verify the checkout journey by adding any product to the cart.")
	public void verifyCheckOutJourney() {
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
