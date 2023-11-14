package com.base;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.config.ConfigurationManager;
import com.libraries.SeleniumWrapper;
import com.pages.LoginPage;
import com.utilities.ExcelReader;

public class BaseClass extends  SeleniumWrapper{
	
	public WebDriver driver; //545642121
	public String browser = ConfigurationManager.configuration().browser(); //1 - Chrome,2 - FF,3 - Edge,4 - IE
	public String sURL = ConfigurationManager.configuration().url();
	public String excelFile = "";
	public String testName,testDescription,module;
	
	@BeforeSuite
	public void reportInitialization() {
		startReport();
	} 
	
	@AfterSuite
	public void flushReport() {
		endReport();
	}
	
	@BeforeClass
	public void invokeBrowser() {
		switch (browser) {
		case "Chrome":
			System.out.println("User option is : "+browser+",So invoking Chrome browser");
			driver = new ChromeDriver();
			break;
		case "Firefox":
			System.out.println("User option is : "+browser+",So invoking Firefox browser");
			driver = new FirefoxDriver();
			break;
		case "Edge":
			System.out.println("User option is : "+browser+",So invoking Edge browser");
			driver = new EdgeDriver();
			break;
		case "IE":
			System.out.println("User option is : "+browser+",So invoking IE browser");
			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("User option is wrong: "+browser+",So invoking the default Chrome browser");
			driver = new ChromeDriver();
			break;
		}
		tlDriver.set(driver);
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		getDriver().manage().window().maximize();
		getDriver().get(sURL);
		startTestCase(testName, testDescription);
		startTestcase(module);
		new LoginPage().doLogin(ConfigurationManager.configuration().username(), ConfigurationManager.configuration().password());
	}
	
	@AfterClass
	public void closeBrowser() {
		getDriver().quit();
	}
	
	@DataProvider(name = "TestData")
	public Object[][] getExcelData(){
		Object[][] datas = ExcelReader.getValueFromExcel(excelFile);
		return datas;
	}

	
}
