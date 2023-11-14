package com.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends MenuPage{
	
	private By oUsernameText = By.id("user_name");
	private By oPasswordText = By.id("user_password");
	private By oLoginInBtn = By.xpath("//button[text()='Log in']");
	
	public LoginPage validateLoginElements() {
		boolean result = false;
		if(verifyDisplayedwithReturn(oUsernameText, "UserName") && verifyDisplayedwithReturn(oPasswordText, "Password") && verifyDisplayedwithReturn(oLoginInBtn, "Password")){
			result = true;
		}
		Assert.assertTrue(result);
		return this;
	}
	
	public LoginPage enterUserName(String uName) {
		type(oUsernameText, uName);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		type(oPasswordText, password);
		return this;
	}
	
	public HomePage clickOnLogin() {
		click(oLoginInBtn, "Login Button");
		return new HomePage();
	}
	
	public void doLogin(String userName,String password) { 
		 validateLoginElements()
		.enterUserName(userName)
		.enterPassword(password)
		.clickOnLogin();
		//.validateHomePage();
	}

}
