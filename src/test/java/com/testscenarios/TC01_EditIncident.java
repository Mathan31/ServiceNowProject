package com.testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.MenuPage;

public class TC01_EditIncident extends BaseClass{
	
	@BeforeTest
	public void testSetup() {
		excelFile = "TC01";
		authors = "Yalini";
		category = "Smoke";
		testName = "Edit incident Test";
		testDescription = "Edit incident validation";
		module = "Edit incident";
}
	
	@Test
	public void validationEditIncident() throws Exception {
		boolean result = new HomePage()
		.validateHomePage();
		Assert.assertTrue(result);
		
		new MenuPage()
		.clickOnAllMenu()
		.typeFilter("Change")
		.clickOnCreateService()
		.switchToMainframe()
		.validateChangeRequestElements()
		.clickOnNormalModule()
		.validateChangeRequestFormTitle()
		.clickOnServiceSearch()
		.clickOnServiceAllLink()
		.enterShortDesc("Automation Short Description")
		.enterDescription("Automation Description")
		.clickOnSubmit();
	}

}
