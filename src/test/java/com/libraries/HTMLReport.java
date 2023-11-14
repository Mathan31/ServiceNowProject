package com.libraries;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.config.ConfigurationManager;

public abstract class HTMLReport {
	
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public ExtentTest test,node;
	public String authors,category;
	public static ThreadLocal<ExtentTest> tlNode = new ThreadLocal<ExtentTest>();
	private String folderName = "";
	private static String fileName = "result.html";
	private static String pattern = "dd-MMM-yyyy HH-mm-ss";
	
	public static String createFolder(String folderName) {
		String date = new SimpleDateFormat(pattern).format(new Date());
		folderName = folderName+"/"+date;
		File folder = new File("./"+folderName);
		if(!folder.exists()) {
			folder.mkdir();
		}
		return folderName;
	}
	
	public synchronized void startReport() {
		folderName = createFolder("report");
		spark = new ExtentSparkReporter("./"+folderName+"/"+fileName);
		spark.config().setTheme(Theme.STANDARD);
		if(ConfigurationManager.configuration().theme().equalsIgnoreCase("dark")) {
			spark.config().setTheme(Theme.DARK);
		}
		spark.config().setDocumentTitle(ConfigurationManager.configuration().title());
		spark.config().setEncoding("utf-8");
		spark.config().setReportName(ConfigurationManager.configuration().reportName());
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}
	
	public void endReport() {
		extent.flush();
	}
	
	public ExtentTest getNode() {
		return tlNode.get();
	}
	
	public synchronized ExtentTest startTestCase(String testCaseName, String testDescription) {
		test = extent.createTest(testCaseName, testDescription);
		test.assignAuthor(authors);
		test.assignCategory(category);
		return test;
	}

	public synchronized ExtentTest startTestcase(String nodes) {
		//getNode() = test.createNode(nodes);
		tlNode.set(test.createNode(nodes));
		return getNode();
	}
	
	public synchronized void reportStep(String desc,String status) {
		if(status.equalsIgnoreCase("pass")){
			getNode().pass(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
			} else if(status.equalsIgnoreCase("fail")) {
				getNode().fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());	
			} else {
				getNode().info(desc);	
			}
	}
	
	public abstract String takeScreenshot();

}
