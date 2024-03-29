package com.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConst{
	public static WebDriver driver;
	public static Properties con; 
	public static FileInputStream fis;
	public static String browser = " ";
	static int row =1;
	static int col = 0;
	
	static { 
		try {
		fis = new FileInputStream(CONFIG_PATH);
		con = new Properties();
		con.load(fis);	
		browser =con.getProperty("browser");
		if (browser.contains("chrome")) 
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
		}
		else
		{
			System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
		}
	}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	@BeforeMethod
	public void openBrowser() {
		if (browser.contains("chrome")) 
		{
			driver = new ChromeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.get(URL);
	}
	@AfterMethod
	public static void afterMethod(ITestResult result) throws EncryptedDocumentException, InvalidFormatException, IOException {
		int status = result.getStatus();
		String testcase = result.getName();
		int testcasestatus = result.getStatus();
		if (status == 1) {
			Reporter.log(testcase+" is pass ", true);
			Excel.report(testcase, REPORT_PATH, SHEET, row, col, status);
			row++;
			col=0;
		}
		else
		{
			try {
			CaptureScreenshot.getScreenshot(driver, testcase);
			Excel.report(testcase, REPORT_PATH, SHEET, row, col, status);
			row++;
			col=0;
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			Reporter.log(testcase+" is fail ",true);
		}
		driver.close();
	}
}
