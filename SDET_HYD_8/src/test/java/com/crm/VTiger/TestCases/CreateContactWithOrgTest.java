package com.crm.VTiger.TestCases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.PropertyFileUtility;
import GenericLibrary.WebDriverUtility;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePageClass;
import ObjectRepository.LoginClass;

public class CreateContactWithOrgTest {

	@Test
	public void createConWithOrg() throws Throwable
	{
		WebDriverUtility wUtil=new WebDriverUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("url");
		String UN = pUtil.readDataFromPropertyFile("username");
		String pwd = pUtil.readDataFromPropertyFile("password");
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		String lastName = eUtil.readDataFromExcel("Sheet1", 7, 1);
		
		WebDriver driver=new ChromeDriver();
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);

		LoginClass lc=new LoginClass(driver);
		lc.setLogin(UN,pwd);
		
		HomePageClass hp=new HomePageClass(driver);
		hp.getConLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateConIcon().click();
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createCon(lastName);
		
		wUtil.switchingWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys("vtiger");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("vtiger")).click();
		
		wUtil.switchingWindow(driver, "Contacts");
		
		ccp.getSaveBtn().click();
		
		String text = driver.findElement(By.className("dvHeaderText")).getText();
		if(text.contains(lastName))
		{
			System.out.println(lastName+" is available");
		}
		else
		{
			System.out.println("lastname is not available");
		}
		
		hp.setLogout(driver);
		driver.close();
	}
	
}
