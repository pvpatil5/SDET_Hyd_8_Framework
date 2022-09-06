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

import com.crm.Vtiger.GenericUtils.BaseClass;
import com.crm.Vtiger.GenericUtils.ExcelFileUtility;
import com.crm.Vtiger.GenericUtils.PropertyFileUtility;
import com.crm.Vtiger.GenericUtils.WebDriverUtility;
import com.crm.Vtiger.ObjectRepository.ContactsPage;
import com.crm.Vtiger.ObjectRepository.CreateContactPage;
import com.crm.Vtiger.ObjectRepository.HomePageClass;
import com.crm.Vtiger.ObjectRepository.LoginClass;

public class CreateContactWithOrgTest extends BaseClass{

	@Test
	public void createConWithOrg() throws Throwable
	{
		String lastName = eUtil.readDataFromExcel("Sheet1", 7, 1);
		
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
	}
	
}
