package com.educnsoln.utilities;

import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerator {
	
	static String homepath = System.getProperty("user.dir");
	static ExtentReports report;	
	public static ExtentReports extentReportsetup() {
		
		ExtentSparkReporter htmlreporter=new ExtentSparkReporter(homepath+"\\src\\test\\resources\\Reports\\Extentreport.html");
		htmlreporter.config().setDocumentTitle("Execution report");
		htmlreporter.config().setTheme(Theme.DARK);	
		
		report=new ExtentReports();
		report.attachReporter(htmlreporter);
		return report;	
	}
	
	
}