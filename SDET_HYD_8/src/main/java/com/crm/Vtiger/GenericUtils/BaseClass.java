package com.crm.Vtiger.GenericUtils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.crm.Vtiger.ObjectRepository.HomePageClass;
import com.crm.Vtiger.ObjectRepository.LoginClass;
import com.google.common.io.Files;

public class BaseClass {

	public WebDriverUtility wUtil=new WebDriverUtility();
	public WebDriver driver;
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"smoke","regression"})
	public void createConnWithDB()
	{
		System.out.println("============create connection with DB============");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smoke","regression"})
	public void openBrowser() throws Throwable
	{
		System.out.println("===========Open browser==========");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		wUtil.maximizeWindow(driver);
		sdriver=driver;
		wUtil.waitForPageLoad(driver);
	}
	
	@BeforeMethod(groups = {"smoke","regression"})
	public void setLogin() throws Throwable
	{
		System.out.println("=========Login==========");
		driver.get(pUtil.readDataFromPropertyFile("url"));
		LoginClass lc=new LoginClass(driver);
		lc.setLogin(pUtil.readDataFromPropertyFile("username"), pUtil.readDataFromPropertyFile("password"));
	}
	
	@AfterMethod(groups = {"smoke","regression"})
	public void logout()
	{
		System.out.println("==========Logout=========");
		HomePageClass hpc=new HomePageClass(driver);
		hpc.setLogout(driver);
	}
	
	@AfterClass(groups = {"smoke","regression"})
	public void closeBrowser()
	{
		System.out.println("========close browser========");
		driver.close();
	}
	
	@AfterSuite(groups = {"smoke","regression"})
	public void closeConnWithDB()
	{
		System.out.println("=========close connection with DB=========");
	}
	
	public static String takingScreenshot(String name) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path="./screenshot/"+name+".png";
		File dest=new File(path);
		Files.copy(src, dest);
		return path;
	}
	
}
