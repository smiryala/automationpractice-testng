package com.browser;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
private static final ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setWebDriver(WebDriver driver) {
		dr.set(driver);
	}

}
