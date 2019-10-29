package com.generic;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConst{
	public static WebDriver driver;
	public static Properties con; 
	public static FileInputStream fis;
	public static String browser = "";
	static {
		try {
		fis = new FileInputStream(CONFIG_PATH);
		con = new Properties();
		con.load(fis);
		browser =con.getProperty(browser);
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver = new ChromeDriver();
		}
		else
		{
			System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
			driver = new FirefoxDriver();
		}
	}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	@BeforeMethod
	public void openBrowser() {
		Scanner input = new Scanner(System.in);
		System.out.println("Specify the Browser: ");
		String browser = input.nextLine();
		
		driver.manage().window().maximize();
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
	@BeforeMethod
	public void IMPwait(){
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}
}
