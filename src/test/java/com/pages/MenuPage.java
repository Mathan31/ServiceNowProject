package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;

public class MenuPage extends BaseClass{
	
	public String headerLogo = "return document.querySelector(\"body > macroponent-f51912f4c700201072b211d4d8c26010\").shadowRoot.querySelector(\"div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-polaris-layout\").shadowRoot.querySelector(\"div.sn-polaris-layout.polaris-enabled > div.layout-main > div.header-bar > sn-polaris-header\").shadowRoot.querySelector(\"#header-logo-image\")";
	
	
	public MenuPage clickOnAllMenu() {
		WebElement oAll;
		oAll = getDriver().findElement(By.xpath("//body/macroponent-f51912f4c700201072b211d4d8c26010")).getShadowRoot()
				          .findElement(By.cssSelector("div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-polaris-layout")).getShadowRoot()
				          .findElement(By.cssSelector("div.sn-polaris-layout.polaris-enabled > div.layout-main > div.header-bar > sn-polaris-header")).getShadowRoot()
				          .findElement(By.cssSelector("#d6e462a5c3533010cbd77096e940dd8c"));
		if(oAll.isDisplayed()) {
			oAll.click();
		}
		return this;
			
	}
	
	public MenuPage typeFilter(String serviceName) throws Exception {
		Thread.sleep(2000);
		WebElement oFilter;
		oFilter = getDriver().findElement(By.xpath("//body/macroponent-f51912f4c700201072b211d4d8c26010")).getShadowRoot()
				          .findElement(By.cssSelector("div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-polaris-layout")).getShadowRoot()
				          .findElement(By.cssSelector("div.sn-polaris-layout.polaris-enabled > div.layout-main > div.header-bar > sn-polaris-header")).getShadowRoot()
				          .findElement(By.cssSelector("nav > div > sn-polaris-menu:nth-child(1)")).getShadowRoot()
				          .findElement(By.cssSelector("#filter"));
		oFilter.sendKeys(serviceName);
		
		return this;	
	}
	
	public CreateChangeRequestPage clickOnCreateService() throws Exception {
		Thread.sleep(2000);
		WebElement oCreate;
		oCreate = getDriver().findElement(By.xpath("//body/macroponent-f51912f4c700201072b211d4d8c26010")).getShadowRoot()
		          .findElement(By.cssSelector("div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-polaris-layout")).getShadowRoot()
		          .findElement(By.cssSelector("div.sn-polaris-layout.polaris-enabled > div.layout-main > div.header-bar > sn-polaris-header")).getShadowRoot()
		          .findElement(By.cssSelector("nav > div > sn-polaris-menu:nth-child(1)")).getShadowRoot()
		          .findElement(By.cssSelector("nav > div.sn-polaris-nav.d6e462a5c3533010cbd77096e940dd8c.can-animate > div.super-filter-container.all-results-open > div.all-results-section.section-open.results-section > div > div.sn-polaris-tab-content.-left.is-visible.can-animate > div > sn-collapsible-list:nth-child(1)")).getShadowRoot()
		          .findElement(By.cssSelector("#\\33 23bb07bc611227a018aea9eb8f3b35e > span > span"));
		oCreate.click();
		
		return new CreateChangeRequestPage();
			
	}
	
}










