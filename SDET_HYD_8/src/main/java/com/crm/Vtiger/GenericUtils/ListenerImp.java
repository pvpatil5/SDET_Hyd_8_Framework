package com.crm.Vtiger.GenericUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImp implements ITestListener{

	ExtentTest test;
	ExtentReports	reports;
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" GOT PASSED");

	}

	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, result.getMethod().getMethodName()+" GOT failed");
		test.log(Status.FAIL, result.getThrowable());
		try {

			String path = BaseClass.takingScreenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			e.printStackTrace();
		}



	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	public void onStart(ITestContext context) {
	
		ExtentSparkReporter reporter = new ExtentSparkReporter(IPathContant.EXTENTREPORTPATH+JavaUtility.datee());
		reporter.config().setDocumentTitle("VTIGER");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("smoke");

		reports= new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("browser version", "105");
		reports.setSystemInfo("repoter name", "pavan");
		reports.setSystemInfo("Build No", "5.3.1");
		reports.setSystemInfo("OS", "Windows_11");

	}

	public void onFinish(ITestContext context) {
		reports.flush();

	}



}
