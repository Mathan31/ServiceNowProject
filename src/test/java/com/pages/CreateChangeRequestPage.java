package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CreateChangeRequestPage extends MenuPage{
	

	private By oCreateChangeReqText = By.xpath("//h1[text()='Create a change request']");
	private By oNormalModule = By.xpath("//div[@uib-tooltip='Normal']");
	private By oChangeRequestFormTitle = By.xpath("//div[@aria-label='Change Request form section']");
	private By oShortDesc = By.xpath("//input[@id='change_request.short_description']");
	private By oDescription = By.xpath("//textarea[@id='change_request.description']");
	private By oSubmit = By.xpath("//button[@id='sysverb_insert_bottom']");
	private By oServiceSearch = By.xpath("//button[@id='lookup.change_request.business_service']/span");
	private String sServiceSearchJS = "arguments[0].click();";
	private By oServiceAllLink = By.xpath("//table[@id='cmdb_ci_service_table']/tbody/tr[1]/td[3]/a[text()='All']");
	
	
	public CreateChangeRequestPage switchToMainframe() throws Exception {
		Thread.sleep(3000);
		WebElement oMainFrame;
		oMainFrame = getDriver().findElement(By.xpath("//body/macroponent-f51912f4c700201072b211d4d8c26010")).getShadowRoot()
		          .findElement(By.cssSelector("#gsft_main"));
		new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(oMainFrame));
		return this;
	}
	
	public CreateChangeRequestPage validateChangeRequestElements() {
		boolean result = false;
		if(verifyDisplayedwithReturn(oCreateChangeReqText, "Change Request Text")){
			result = true;
		}
		Assert.assertTrue(result);
		return this;
	}
	
	public CreateChangeRequestPage clickOnNormalModule() {
		click(oNormalModule, "Normal Module");
		return this;
	}
	
	public CreateChangeRequestPage validateChangeRequestFormTitle() {
		boolean result = false;
		if(verifyDisplayedwithReturn(oChangeRequestFormTitle, "Change Request Form Title")){
			result = true;
		}
		Assert.assertTrue(result);
		return this;
	}
	
	public CreateChangeRequestPage clickOnServiceSearch() throws Exception {
		//click(oServiceSearch, "Service Search");
		executeJSClick(sServiceSearchJS,oServiceSearch);
		Thread.sleep(2000);
		return this;
	}
	
	public CreateChangeRequestPage clickOnServiceAllLink() throws Exception {
		waitForNewWindow(2);
		switchToWindow(1);
		String title = getTitle();
		System.out.println(title);
		clickAndSwitch(oServiceAllLink);
		switchToMainframe();
		return this;
	}
	
	
	public CreateChangeRequestPage enterShortDesc(String shortDesc) {
		type(oShortDesc, shortDesc);
		return this;
	}
	
	
	public CreateChangeRequestPage enterDescription(String description) {
		type(oDescription, description);
		return this;
	}
	
	public CreateChangeRequestPage clickOnSubmit() {
		click(oSubmit, "Change Submit");
		return this;
	}
	
	
}
