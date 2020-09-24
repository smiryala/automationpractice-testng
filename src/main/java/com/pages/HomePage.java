package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

	@FindBy(xpath="//div[@class='header-container']")
	private WebElement header;
	
	@FindBy(xpath="//div[@class='footer-container']")
	private WebElement footer;

	@FindBy(xpath="//a[@title='Women']")
	private WebElement womenMenuItem;

	@FindBy(xpath="//a[@class='login']")
	private WebElement signIn;

	@FindBy(xpath="//p[contains(@class,'alert')]")
	private	WebElement alertMessage;

	@FindBy(xpath="//input[@id='newsletter-input']")
	private	WebElement newsLetterInput;

	@FindBy(xpath="//button[@name='submitNewsletter']")
	private	WebElement submitNewsLetter;

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
		Assert.assertTrue(getText(alertMessage).contains("Newsletter : You have successfully subscribed to this newsletter."),"Alert Message");
	}
}
