package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends MenuPage{
	
	private By oHomePage = By.xpath("//div[text()='App Engine Studio']");
	
	
	public boolean validateHomePage() throws Exception {
		boolean result = false;
		Thread.sleep(5000);
		WebElement element = executeJSAndReturnWebElement(headerLogo);
		if(verifyDisplayedwithReturn(element)){
			result = true;
		}
		return result;
	}
	
	
}
