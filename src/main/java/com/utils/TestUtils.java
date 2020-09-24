package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Hashtable;

import java.util.List;

import java.util.Random;


import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.util.ArrayUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import com.browser.Driver;
import com.browser.DriverManager;
import com.constants.Constants;
import com.listener.ListenerClass;
import com.reports.ExtentReport;
import com.reports.LogStatus;




/*
 * All the utilities needed for the framework is placed in this class including excel utilities, screenshot capture.
 * We have used method overloading concept in getCellContent Method.
 */
public class TestUtils {

	public static String screenshotPath=ReadPropertyFile.get("ScreenshotPath");

	/*
	 * Takes screenshot
	 * Make sure parameter ScreenshotsRequired is Yes in TestRunDetails.properties
	 * 
	 */
	public static void takeScreenshot()  {

		if(ReadPropertyFile.get("ScreenshotsRequired").equalsIgnoreCase("yes")) {

			File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			try {
				if(screenshotPath.equals("")) {
					FileUtils.copyFile(scrFile, new File("./screenshots/" + ListenerClass.getTestcaseName()+"/"+ System.currentTimeMillis() + new Random().nextInt(20)+".png"));
				}else{
					FileUtils.copyFile(scrFile, new File(screenshotPath+"/screenshots/" + ListenerClass.getTestcaseName()+"/"+ System.currentTimeMillis() +new Random().nextInt(20)+ ".png"));	
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	/*
	 * Captures screenshot and returns the screenshot path
	 */
	public static String pullScreenshotPath()  {

		String destination=null;
		if(ReadPropertyFile.get("ScreenshotsRequired").equalsIgnoreCase("yes")) {
			File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			try {
				if(screenshotPath.equals("")) {
					destination=System.getProperty("user.dir")+"\\screenshots\\" +ListenerClass.getTestcaseName()+"\\"+ System.currentTimeMillis()+new Random().nextInt(20)+".png";
					FileUtils.copyFile(scrFile, new File(destination));
				}
				else {
					destination=screenshotPath+"\\screenshots\\" +ListenerClass.getTestcaseName().replaceAll(" ","")+"\\"+ System.currentTimeMillis() +new Random().nextInt(20)+".png";
					FileUtils.copyFile(scrFile, new File(destination));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		return destination;

	}

	/*
	 * Gives a base64 image which is used to append the screenshots in the extent report.
	 * Converting to base64 format avoids screenshots broken image if sent the report through email.
	 */
	public static String getBase64Image(String screenshotpath) {
		String base64 = null;
		try {
			InputStream is= new FileInputStream(screenshotpath);
			byte[] imageBytes = IOUtils.toByteArray(is);
			base64 = Base64.getEncoder().encodeToString(imageBytes);
		}
		catch (Exception e) {
		}
		return base64;
	}
}
