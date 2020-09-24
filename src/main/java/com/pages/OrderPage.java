package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage{

	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOut;

	@FindBy(xpath="//p[@class='cart_navigation clearfix']//span[contains(text(),'Proceed to checkout')]")
	WebElement cartNavProceedToCheckOut;

	@FindBy(xpath="//input[@name='email_create']")
	WebElement emailGuest;

	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement emailGuestCreate;

	@FindBy(xpath="(//input[@name='id_gender'])[1]")
	WebElement personalInfoMr;

	@FindBy(xpath="//input[@name='customer_firstname']")
	WebElement personalInfoFirstName;

	@FindBy(xpath="//input[@name='customer_lastname']")
	WebElement personalInfoLastName;

	@FindBy(xpath="//input[@name='passwd']")
	WebElement personalInfoPwd;

	@FindBy(xpath="//select[@name='days']")
	WebElement personalInfoDOBDay;

	@FindBy(xpath="//select[@name='months']")
	WebElement personalInfoDOBMonth;

	@FindBy(xpath="//select[@name='years']")
	WebElement personalInfoDOBYear;

	@FindBy(xpath="//input[@name='firstname']")
	WebElement addressFirstName;

	@FindBy(xpath="//input[@name='lastname']")
	WebElement addressLastName;

	@FindBy(xpath="//input[@name='company']")
	WebElement addressCompany;

	@FindBy(xpath="//input[@name='address1']")
	WebElement addressLine1;

	@FindBy(xpath="//input[@name='address2']")
	WebElement addressLine2;

	@FindBy(xpath="//input[@name='city']")
	WebElement addressCity;

	@FindBy(xpath="//select[@name='id_state']")
	WebElement addressState;

	@FindBy(xpath="//input[@name='postcode']")
	WebElement addressPostCode;

	@FindBy(xpath="//select[@name='id_country']")
	WebElement addressCountry;

	@FindBy(xpath="//textarea[@name='other']")
	WebElement addressOtherInfo;

	@FindBy(xpath="//input[@name='phone']")
	WebElement addressHomePhone;

	@FindBy(xpath="//input[@name='phone_mobile']")
	WebElement addressMobilePhone;

	@FindBy(xpath="//input[@name='alias']")
	WebElement addressAlias;

	@FindBy(xpath="//button[@name='submitAccount']")
	WebElement addressSubmit;

	@FindBy(xpath="//button[@name='processAddress']")
	WebElement addressProcess;

	@FindBy(xpath="//label[@for='cgv']")
	WebElement cgv;

	@FindBy(xpath="//button[@name='processCarrier']")
	WebElement processCarrier;

	@FindBy(xpath="//a[@class='bankwire']")
	WebElement bankWire;

	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrder;

	@FindBy(xpath="//strong[contains(text(),'Your order on My Store is complete.')]")
	WebElement orderConfirmation;

	public void proceedAsGuest(){
		click(proceedToCheckOut);
		click(cartNavProceedToCheckOut);
		sendkeys(emailGuest,getRandomEmail("5"));
		click(emailGuestCreate);
	}
	public void registerAddress(){
		click(personalInfoMr);
		sendkeys(personalInfoFirstName,"First Name");
		sendkeys(personalInfoLastName,"Last Name");
		sendkeys(personalInfoPwd,"P@ssword");
		selectByValue(personalInfoDOBDay,"2");
		selectByValue(personalInfoDOBMonth,"2");
		selectByValue(personalInfoDOBYear,"1985");

		sendkeys(addressFirstName,"Address FName");
		sendkeys(addressLastName,"Address LName");
		sendkeys(addressCompany,"Address Company");
		sendkeys(addressLine1,"Address line1");
		sendkeys(addressCity,"Address line1");
		selectByVisibleText(addressState,"Alabama");
		sendkeys(addressPostCode,"12345");
		selectByVisibleText(addressCountry,"United States");
		sendkeys(addressOtherInfo,"test");
		sendkeys(addressHomePhone,"12345678");
		sendkeys(addressMobilePhone,"12345648");
		sendkeys(addressAlias,"111");
		click(addressSubmit);
		click(addressProcess);
	}

	public void processShipping(){
		click(cgv);
		click(processCarrier);
	}

	public void processPayment(){
		click(bankWire);
		click(confirmOrder);
	}

	public void verifyConfirmOrder(){
		isVisible(orderConfirmation);
	}
}
