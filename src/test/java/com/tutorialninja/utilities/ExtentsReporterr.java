package com.tutorialninja.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentsReporterr {
	public static  ExtentReports extentsReport()
	{
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile = new File("./test-output/extentReports/extentreport.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(extentReportFile);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Tutorial Ninja");
		extentReport.attachReporter(spark);
		
		return extentReport;
	}

}
