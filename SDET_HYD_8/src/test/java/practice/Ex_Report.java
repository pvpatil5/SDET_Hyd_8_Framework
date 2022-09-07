package practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex_Report 
{
	ExtentSparkReporter reporter; // PATH,LOOK AND FEEL REPORT
	ExtentReports reports; // AATCH REPORTER AND ENV VARIABLE
	ExtentTest test; // TO CREATE ENTRIES 

	@Test
	public void generateReport() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		reporter = new ExtentSparkReporter("./Reports/Facebook.html");
		reporter.config().setDocumentTitle("VTIGER");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("smoke");

		reports= new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("browser version", "105");
		reports.setSystemInfo("repoter name", "pavan");
		reports.setSystemInfo("Build No", "5.3.1");
		reports.setSystemInfo("OS", "Windows_11");

		test=reports.createTest("FLIPKART");

		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "../SDET_HYD_8/screenshot/ABC2.PNG";
		File dest = new File(path);
		Files.copy(src, dest);

		test.addScreenCaptureFromPath(path);

		test.log(Status.FAIL,"Got failed");
		reports.flush();

	}


}
