package com.pages;

import com.reports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import org.testng.asserts.SoftAssert;

public class WomenSummerDressesPage extends BasePage {
	public static SoftAssert soft = new SoftAssert();

	@FindBy(xpath="//a[@title='Summer Dresses']")
	WebElement womenSummerDressesLink;

	@FindBy(xpath="//span[contains(text(),'Summer Dresses') and @class='category-name']")
	WebElement womenSummerDressesPage;

	@FindBy(xpath="//a[contains(text(),'White')]")
	WebElement whiteColorFilter;

	@FindBy(xpath="//a[contains(text(),'White')]//span")
	WebElement whiteColorFilterCount;

	@FindBy(xpath="//div[@class='product-container']")
	List<WebElement> productContainers;

	@FindBy(xpath="(//a[@class='product_img_link'])[1]")
	WebElement firstProductImg;

	@FindBy(xpath="//a[@title='List']")
	WebElement listViewOfProducts;

	@FindBy(xpath="//select[@id='selectProductSort']")
	WebElement sortBy;

	@FindBy(xpath="//div[@class='product-container']//div[@class='content_price']/span[@itemprop='price']")
	List<WebElement> productPrices;

	@FindBy(xpath="//div[@class='product-container']//a[@class='product-name']")
	List<WebElement> productNames;

	@FindBy(xpath="(//span[text()='Add to cart'])[1]")
	WebElement addToCart;


	public void clickOnSummerDressesLink(){
		jScriptClick(womenSummerDressesLink);
	}

	public void verifySummareDressesPageDisplayed(){
		isVisible(womenSummerDressesPage);
	}

	public void clickOnColourFilter(){
		click(whiteColorFilter);
	}

	public void clickOnAddToCart(){
		click(addToCart);
	}

	public String getColourFilterCount(){
		return getText(whiteColorFilterCount).replaceAll("\\(","").replaceAll("\\)","");
	}

	public int getContainersCount(){
		return productContainers.size();
	}

	public void selectSortBy(String value){
		selectByVisibleText(sortBy,value);
	}

	public void verifyAscendingOrderProductNames(){
		for (int i = 0; i < productNames.size() - 1; i++) {

			String currentText = productNames.get(i).getText().toUpperCase();
			String nextText = productNames.get(i + 1).getText().toUpperCase();
			if (currentText.compareTo(nextText) < 0||currentText.compareTo(nextText) == 0) {
			} else {
				soft.fail("Failed Ascending Order A:Z ++ Current: " +currentText +" Next: " +nextText);
			}
		}
	}

	public void verifyDescendingOrderProductNames(){
		for (int i = 0; i < productNames.size()-1; i++) {
			String currentText = productNames.get(i).getText().toUpperCase();
			String nextText = productNames.get(i + 1).getText().toUpperCase();
			if (nextText.compareTo(currentText) < 0||nextText.compareTo(currentText)==0) {
			} else {
				soft.fail("Failed Descending Order Z:A ++ Current: " +currentText +" Next: "+ nextText);
			}
		}
	}

	public void verifyAscendingOrderProductPrice(){
		for (int i = 1; i < productPrices.size()-1; i++) {
			String currentText = productPrices.get(i).getText().toUpperCase();
			String nextText = productPrices.get(i + 2).getText().toUpperCase();
			if (currentText.compareTo(nextText) < 0||currentText.compareTo(nextText) == 0) {
			} else {
				soft.fail("Failed Ascending Order Product Prices ++ Current : " +currentText +" Next: "+ nextText);
			}
			i++;
		}
	}

	public void verifyDescendingOrderProductPrice(){
		for (int i = 1; i < productPrices.size()-1; i++) {
			String currentText = productPrices.get(i).getText().toUpperCase();
			String nextText = productPrices.get(i + 2).getText().toUpperCase();
			if (nextText.compareTo(currentText) < 0||nextText.compareTo(currentText)==0) {
			} else {
				soft.fail("Failed Descending Order Product Prices ++ Current:" +currentText +" Next: "+ nextText);
			}
			i++;
		}
	}

	public void verifyAscendingOrder(String elemType){
		List<WebElement> element = null;
		if(elemType.equals("ProductPrice"))
			element = productPrices;
		else
			element = productNames;

		for (int i = 1; i < element.size(); i++) {
			System.out.println(element.get(i).getText().toUpperCase());
			LogStatus.info(element.get(i).getText().toUpperCase());
			i++;
		}

		for (int i = 0; i < element.size() - 1; i++) {
			String currentText = element.get(i).getText().toUpperCase();
			String nextText = element.get(i + 1).getText().toUpperCase();
			if (currentText.compareTo(nextText) < 0||currentText.compareTo(nextText) == 0) {
			} else {
				soft.fail("Failed Ascending Order "+elemType+" ++ Current : " +currentText +" Next: "+ nextText);
			}
		}
	}

	public void verifyDescendingOrder(String elemType){
		List<WebElement> element = null;
		if(elemType.equals("ProductPrice"))
			element = productPrices;
		else
			element = productNames;

		for (int i = 1; i < element.size(); i++) {
			System.out.println(element.get(i).getText().toUpperCase());
			LogStatus.info(element.get(i).getText().toUpperCase());
			i++;
		}


		for (int i = 0; i < element.size() - 1; i++) {
			String currentText = element.get(i).getText().toUpperCase();
			String nextText = element.get(i + 1).getText().toUpperCase();
			if (nextText.compareTo(currentText) < 0||nextText.compareTo(currentText)==0) {
			} else {
				soft.fail("Failed Descending Order "+elemType+" ++ Current:" +currentText +" Next: "+ nextText);
			}
		}
	}

	public void clickOnListViewOfProducts(){
		click(listViewOfProducts);
	}
}
