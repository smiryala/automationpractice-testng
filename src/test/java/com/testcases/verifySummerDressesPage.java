package com.testcases;

import com.pages.HomePage;
import com.pages.WomenSummerDressesPage;
import org.testng.annotations.Test;

import java.util.Objects;

import static com.pages.WomenSummerDressesPage.soft;

public class verifySummerDressesPage extends BaseTest{
	
	private HomePage homepage;
	private WomenSummerDressesPage summerdresspage;
	
	@Test(description = "Validate summer dresses listing page by verifying the filters and sortby functionality")
	public void verifySummerDressListingPage() {
		homepage =new HomePage();
		summerdresspage=new WomenSummerDressesPage();

		homepage.hoverOnWomenMenu();
		summerdresspage.clickOnSummerDressesLink();
		summerdresspage.verifySummareDressesPageDisplayed();

		summerdresspage.clickOnColourFilter();
		String filterCount = summerdresspage.getColourFilterCount();
		String containersCount = Integer.toString(summerdresspage.getContainersCount());
		soft.assertTrue(Objects.equals(filterCount, containersCount),"Color filter is not working as expected");

		summerdresspage.selectSortBy("Price: Lowest first");
		summerdresspage.verifyAscendingOrderProductPrice();

		summerdresspage.selectSortBy("Price: Highest first");
		summerdresspage.verifyDescendingOrderProductPrice();

		summerdresspage.selectSortBy("Product Name: A to Z");
		summerdresspage.verifyAscendingOrderProductNames();

		summerdresspage.selectSortBy("Product Name: Z to A");
		summerdresspage.verifyDescendingOrderProductNames();

		soft.assertAll();
	}
}
