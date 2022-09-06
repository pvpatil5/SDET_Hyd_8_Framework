package com.crm.VTiger.TestCases;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Vtiger.GenericUtils.BaseClass;
import com.crm.Vtiger.GenericUtils.ExcelFileUtility;
import com.crm.Vtiger.GenericUtils.JavaUtility;
import com.crm.Vtiger.GenericUtils.PropertyFileUtility;
import com.crm.Vtiger.GenericUtils.WebDriverUtility;


public class DemoTest{
	
	@Test(retryAnalyzer = com.crm.Vtiger.GenericUtils.RetryAnalyserClass.class)
	public void orgTest() throws Throwable
	{
	  System.out.println("Test Start");
	  Assert.assertEquals(false, true);
	  System.out.println("Test Ends");
	}
	
	
	
	
}
