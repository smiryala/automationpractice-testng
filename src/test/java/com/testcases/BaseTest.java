package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.browser.Driver;
import com.browser.DriverManager;
import com.reports.ExtentReport;

public class BaseTest {

	@BeforeMethod
	public void setUp() {
		try {
			Driver.initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void wrapUp() {
		DriverManager.getDriver().close();
	}

	@BeforeSuite
	public void beforeSuite() {
		ExtentReport.initialize();
	}

	@AfterSuite
	public void afterSuite() {
		ExtentReport.report.flush();
//		File htmlFile = new File(ExtentReport.extentreportpath);
//		Desktop.getDesktop().browse(htmlFile.toURI());
	}
}
