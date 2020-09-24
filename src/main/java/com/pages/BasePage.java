package com.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.browser.DriverManager;
import com.constants.Constants;
import com.reports.LogStatus;
import com.utils.TestUtils;

public class BasePage {
	
	protected BasePage(){
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	private static void explicitlyWait(WebElement element) {
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Constants.EXPLICITWAIT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void click(WebElement element)  {
		explicitlyWait(element);
		scrollIntoView(element);
		element.click();
		LogStatus.pass("Clicking is successfull on "+ element);
		LogStatus.pass("Screenshot below", TestUtils.pullScreenshotPath());
	}

	public static void jScriptClick(WebElement element) {
		explicitlyWait(element);
		highlightElement(element);
		explicitlyWait(element);
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].click();", element);
		LogStatus.pass("Clicking is successfull on "+ element);
		LogStatus.pass("Screenshot below", TestUtils.pullScreenshotPath());
	}

	public void sendkeys(WebElement element, String text)  {
		explicitlyWait(element);
		highlightElement(element);
		element.clear();
		element.sendKeys(text);
		LogStatus.pass(text + " is entered in to the "+ element);
		LogStatus.pass(text + " is entered in to the "+ element, TestUtils.pullScreenshotPath());
		
	}

	public void isVisible(WebElement element) {
		explicitlyWait(element);
		scrollIntoView(element);
		try
		{
			if(element.isDisplayed())
			{
				LogStatus.pass(element + " is displayed");
				LogStatus.pass(element + " is displayed"+ element, TestUtils.pullScreenshotPath());
			}
		}
		catch (Exception e) {
			LogStatus.fail(element + " is not displayed");
			LogStatus.fail(element + " is not displayed"+ element, TestUtils.pullScreenshotPath());
		}
	}

	public static String getText(WebElement element)  {
		explicitlyWait(element);
		highlightElement(element);
		LogStatus.pass("getText is successfull on "+ element);
		LogStatus.pass("Screenshot below", TestUtils.pullScreenshotPath());
		return element.getText();
	}

	public static void moveToElement(WebElement element) {
		Actions actions= new Actions(DriverManager.getDriver());
		actions.moveToElement(element).build().perform();
	}
	
	private static void highlightElement(WebElement element) {
		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static void scrollIntoView(WebElement element) {
		 JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void selectByValue(WebElement element,String text) {
		new Select(element).selectByValue(text);
		LogStatus.pass("Selected dropdown " +element + "with value " +text);
		LogStatus.pass("Screenshot below", TestUtils.pullScreenshotPath());
	}
	
	public static void selectByVisibleText(WebElement element,String text) {
		new Select(element).selectByVisibleText(text);
		LogStatus.pass("Selected dropdown " +element + "with text " +text);
		LogStatus.pass("Screenshot below", TestUtils.pullScreenshotPath());
	}

	public static String getRandomEmail(String nameLength) {
		return String.format("%s@%s.%s", RandomStringUtils.randomAlphabetic(Integer.parseInt(nameLength)),
				RandomStringUtils.randomAlphabetic(3), RandomStringUtils.randomAlphabetic(2)).toLowerCase();
	}
}
