package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username") 
	private WebElement username;
	public void getUsername(String text) {
		username.sendKeys(text);
	}
	
	@FindBy(name="pwd")
	private WebElement passwd;
	public void getPassword(String text) {
		passwd.sendKeys(text);
	}

	@FindBy(id="loginButton") private WebElement loginBtn;
	public void setLoginBtn() {
		loginBtn.click();
	}
	
	@FindBy(id="keepLoggedInCheckBox") private WebElement pwdCb;
	public WebElement getRemeberPasswordCB() {
		return pwdCb;
	}

	public void setRemeberPasswordCB() {
		 pwdCb.click();
	}
}
