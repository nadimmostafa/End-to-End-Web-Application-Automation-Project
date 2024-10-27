package org.nadim.listeners;

import java.io.File;
import java.io.IOException;

import org.nadim.utility.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	static ExtentReports extentReport;

	// if ExtentReports instance is already available then we don't create again
	// because creating each instance create one report file but one project we
	// should have one report only for that below code and call this method
	public static ExtentReports createInstance() {
		if (extentReport == null) {
			extentReport = createReport();
			return extentReport;
		} else {
			return extentReport;
		}
	}

	public static ExtentReports createReport() {

		File file = new File(System.getProperty("user.dir") + "/reports/testReport"+Utility.getDateTime()+".html");

		// check file is exist or not if not then create
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Automation Report");
		spark.config().setDocumentTitle("Sprint-1 Report");
		spark.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
		
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(spark);

		return extentReport;
	}
}
