package com.utils;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.apache.poi.util.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.browser.DriverManager;
import com.listener.ListenerClass;


/*
 * All the utilities needed for the framework is placed in this class including excel utilities, screenshot capture.
 * We have used method overloading concept in getCellContent Method.
 */
public class TestUtils {

	private static final String screenshotPath=ReadPropertyFile.get("ScreenshotPath");

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
		catch (Exception ignored) {
		}
		return base64;
	}
}
