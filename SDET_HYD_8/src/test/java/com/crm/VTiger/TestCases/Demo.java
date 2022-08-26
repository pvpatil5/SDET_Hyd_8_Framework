package com.crm.VTiger.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.JavaUtility;
import GenericLibrary.PropertyFileUtility;
import GenericLibrary.WebDriverUtility;

public class Demo {

	@Test
	public void demoTest() throws Throwable
	{
	 WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://www.facebook.com/");
	 
	 WebElement element = driver.findElement(By.name("email"));
	 element.sendKeys("xyz@gmail.com");
	 driver.navigate().refresh();
	 
	 element.sendKeys("xyz@gmail.com");
	}
}
