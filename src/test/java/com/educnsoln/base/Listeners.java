package com.educnsoln.base;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.educnsoln.runner.TestRunner;

//import selenium_Learning.ScreenshotCaptureDemo;
//import testNG_Learning.TestNGDataProviderDemo;

public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("============On test Start=========");
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("============On test failure=========");
		TestRunner.test.log(Status.FAIL, "Test is failed").addScreenCaptureFromPath(CommonFunctions.getScreenshot(TestRunner.driver, "LoginFilure"));		
			
					
		/*
		 * try { ScreenshotCaptureDemo.getScreenshot(TestNGDataProviderDemo.driver,
		 * "onFailure"); } catch(IOException e) { e.printStackTrace(); }
		 */
	}
	
	

	@Override
	public void onTestSuccess(ITestResult result) {
	
		TestRunner.test.log(Status.INFO, "======Test is Scucesfull=====");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("============On test Skipped=========");	
		//TestRunner.test.log(Status.INFO, "============Test is skipped============");

	}

}
