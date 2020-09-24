package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import org.testng.asserts.SoftAssert;

public class WomenSummerDressesPage extends BasePage {
	public static final SoftAssert soft = new SoftAssert();

	@FindBy(xpath="//a[@title='Summer Dresses']")
	private WebElement womenSummerDressesLink;

	@FindBy(xpath="//span[contains(text(),'Summer Dresses') and @class='category-name']")
	private WebElement womenSummerDressesPage;

	@FindBy(xpath="//a[contains(text(),'White')]")
	private WebElement whiteColorFilter;

	@FindBy(xpath="//a[contains(text(),'White')]//span")
	private WebElement whiteColorFilterCount;

	@FindBy(xpath="//div[@class='product-container']")
	private List<WebElement> productContainers;

	@FindBy(xpath="(//a[@class='product_img_link'])[1]")
	private WebElement firstProductImg;

	@FindBy(xpath="//a[@title='List']")
	private WebElement listViewOfProducts;

	@FindBy(xpath="//select[@id='selectProductSort']")
	private WebElement sortBy;

	@FindBy(xpath="//div[@class='product-container']//div[@class='content_price']/span[@itemprop='price']")
	private List<WebElement> productPrices;

	@FindBy(xpath="//div[@class='product-container']//a[@class='product-name']")
	private List<WebElement> productNames;

	@FindBy(xpath="(//span[text()='Add to cart'])[1]")
	private WebElement addToCart;


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

	public void clickOnListViewOfProducts(){
		click(listViewOfProducts);
	}
}
