package com.pages;

import com.constants.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage{

	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOut;

	@FindBy(xpath="//p[@class='cart_navigation clearfix']//span[contains(text(),'Proceed to checkout')]")
	private WebElement cartNavProceedToCheckOut;

	@FindBy(xpath="//input[@name='email_create']")
	private WebElement emailGuest;

	@FindBy(xpath="//button[@id='SubmitCreate']")
	private WebElement emailGuestCreate;

	@FindBy(xpath="(//input[@name='id_gender'])[1]")
	private WebElement personalInfoMr;

	@FindBy(xpath="//input[@name='customer_firstname']")
	private WebElement personalInfoFirstName;

	@FindBy(xpath="//input[@name='customer_lastname']")
	private WebElement personalInfoLastName;

	@FindBy(xpath="//input[@name='passwd']")
	private WebElement personalInfoPwd;

	@FindBy(xpath="//select[@name='days']")
	private WebElement personalInfoDOBDay;

	@FindBy(xpath="//select[@name='months']")
	private WebElement personalInfoDOBMonth;

	@FindBy(xpath="//select[@name='years']")
	private WebElement personalInfoDOBYear;

	@FindBy(xpath="//input[@name='firstname']")
	private WebElement addressFirstName;

	@FindBy(xpath="//input[@name='lastname']")
	private WebElement addressLastName;

	@FindBy(xpath="//input[@name='company']")
	private WebElement addressCompany;

	@FindBy(xpath="//input[@name='address1']")
	private WebElement addressLine1;

	@FindBy(xpath="//input[@name='address2']")
	private WebElement addressLine2;

	@FindBy(xpath="//input[@name='city']")
	private WebElement addressCity;

	@FindBy(xpath="//select[@name='id_state']")
	private WebElement addressState;

	@FindBy(xpath="//input[@name='postcode']")
	private WebElement addressPostCode;

	@FindBy(xpath="//select[@name='id_country']")
	private WebElement addressCountry;

	@FindBy(xpath="//textarea[@name='other']")
	private WebElement addressOtherInfo;

	@FindBy(xpath="//input[@name='phone']")
	private WebElement addressHomePhone;

	@FindBy(xpath="//input[@name='phone_mobile']")
	private WebElement addressMobilePhone;

	@FindBy(xpath="//input[@name='alias']")
	private WebElement addressAlias;

	@FindBy(xpath="//button[@name='submitAccount']")
	private WebElement addressSubmit;

	@FindBy(xpath="//button[@name='processAddress']")
	private WebElement addressProcess;

	@FindBy(xpath="//label[@for='cgv']")
	private WebElement termsAndConditions;

	@FindBy(xpath="//button[@name='processCarrier']")
	private WebElement processCarrier;

	@FindBy(xpath="//a[@class='bankwire']")
	private WebElement bankWire;

	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrder;

	@FindBy(xpath="//strong[contains(text(),'Your order on My Store is complete.')]")
	private WebElement orderConfirmation;

	public void proceedAsGuest(){
		click(proceedToCheckOut);
		click(cartNavProceedToCheckOut);
		sendkeys(emailGuest,getRandomEmail("5"));
		click(emailGuestCreate);
	}
	public void registerAddress(){
		click(personalInfoMr);
		sendkeys(personalInfoFirstName, Constants.PERSONALINFO_FIRSTNAME);
		sendkeys(personalInfoLastName,Constants.PERSONALINFO_LASTNAME);
		sendkeys(personalInfoPwd,Constants.PERSONALINFO_USERPWD);
		selectByValue(personalInfoDOBDay,Constants.PERSONALINFO_DOBDAY);
		selectByValue(personalInfoDOBMonth,Constants.PERSONALINFO_DOBMONTH);
		selectByValue(personalInfoDOBYear,Constants.PERSONALINFO_DOBYEAR);

		sendkeys(addressFirstName,Constants.ADDRESS_FIRSTNAME);
		sendkeys(addressLastName,Constants.ADDRESS_LASTNAME);
		sendkeys(addressCompany,Constants.ADDRESS_COMPANY);
		sendkeys(addressLine1,Constants.ADDRESS_LINE1);
		sendkeys(addressCity,Constants.ADDRESS_CITY);
		selectByVisibleText(addressState,Constants.ADDRESS_STATE);
		sendkeys(addressPostCode,Constants.ADDRESS_POSTALCODE);
		selectByVisibleText(addressCountry,Constants.ADDRESS_COUNTRY);
		sendkeys(addressOtherInfo,Constants.ADDRESS_OTHERINFO);
		sendkeys(addressHomePhone,Constants.ADDRESS_HOMEPHONE);
		sendkeys(addressMobilePhone,Constants.ADDRESS_MOBILEPHONE);
		sendkeys(addressAlias,Constants.ADDRESS_ALIAS);
		click(addressSubmit);
		click(addressProcess);
	}

	public void processShipping(){
		click(termsAndConditions);
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
