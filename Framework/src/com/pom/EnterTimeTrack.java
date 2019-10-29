package com.pom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.generic.IAutoConst;

public class EnterTimeTrack implements IAutoConst{
	public EnterTimeTrack(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void verifyHomePage(WebDriver driver, long ETO, String title) {
		try {
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.titleContains(title));
			Reporter.log("Home Page is Displayed");
		}
		catch (Exception e) {
			Reporter.log("Home Page is not displayed");
			e.printStackTrace();
			Assert.fail();
		}
	}
}
