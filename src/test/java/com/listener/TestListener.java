package com.listener;

import java.io.PrintWriter;

import java.io.StringWriter;

import org.testng.ITestListener;

import org.testng.ITestResult;

import com.libraries.SeleniumWrapper;

public class TestListener extends SeleniumWrapper implements ITestListener{

public void onTestFailure(ITestResult result) {

if(result.getThrowable() != null) {

StringWriter writer = new StringWriter();

PrintWriter printWriter = new PrintWriter(writer);

result.getThrowable().printStackTrace(printWriter);

System.out.println(writer.toString());

reportStep(writer.toString(),"FAIL");

}

}

}