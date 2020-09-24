package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.browser.DriverManager;
import org.testng.Assert;

public class HomePage extends BasePage {

	@FindBy(xpath="//div[@class='header-container']")
	WebElement header;
	
	@FindBy(xpath="//div[@class='footer-container']")
	WebElement footer;

	@FindBy(xpath="//a[@title='Women']")
	WebElement womenMenuItem;

	@FindBy(xpath="//a[@class='login']")
	WebElement signIn;

	@FindBy(xpath="//p[contains(@class,'alert')]")
	WebElement alertMessage;

	@FindBy(xpath="//input[@id='newsletter-input']")
	WebElement newsLetterInput;

	@FindBy(xpath="//button[@name='submitNewsletter']")
	WebElement submitNewsLetter;

	public void isHeaderDisplayed(){
		isVisible(header);
	}

	public void isFooterDisplayed(){
		isVisible(footer);
	}

	public void clickOnSignIn(){
		click(signIn);
	}

	public void clickOnWomenMenu(){
		click(womenMenuItem);
	}

	public void hoverOnWomenMenu(){
		moveToElement(womenMenuItem);
	}

	public void inputNewsLetterEmail(){
		sendkeys(newsLetterInput,getRandomEmail("5"));
	}

	public void submitNewsLetterEmail(){
		click(submitNewsLetter);
	}

	public void verifyNewsLetterEmailSubscription(){
		System.out.println("message:" + getText( alertMessage));
		Assert.assertTrue(getText(alertMessage).contains("Newsletter : You have successfully subscribed to this newsletter."),"Alert Message");
	}
}
