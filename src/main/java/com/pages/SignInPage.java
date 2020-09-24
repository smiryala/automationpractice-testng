package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.browser.Driver;
import com.listener.ListenerClass;
import com.reports.ExtentReport;
import com.utils.ReadPropertyFile;

import com.utils.TestUtils;

public class SignInPage extends BasePage{

	@FindBy(xpath="//div[@class='header-container']")
	WebElement header;

	@FindBy(xpath="//div[@class='footer-container']")
	WebElement footer;
//span[contains(text(),'Proceed to checkout')]
}
