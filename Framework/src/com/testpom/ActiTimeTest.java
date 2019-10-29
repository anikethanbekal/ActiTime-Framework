package com.testpom;

import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.generic.Excel;
import com.pom.EnterTimeTrack;
import com.pom.LoginPage;

public class ActiTimeTest extends BaseTest{
	@Test
	public static void ValidLogin() {
		String un =Excel.getData(EXECEL_PATH, SHEET, 1, 0);
		String passwd =Excel.getData(EXECEL_PATH, SHEET, 1, 1);
		String title =Excel.getData(EXECEL_PATH, SHEET, 1, 2);
		
		LoginPage l = new LoginPage(driver);
		l.getUsername("admin");
		l.getPassword("manager");		
		l.setLoginBtn();
		
		EnterTimeTrack et =  new EnterTimeTrack(driver);
		et.verifyHomePage(driver, 5, title);
	}
}
