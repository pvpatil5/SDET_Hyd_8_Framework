package com.crm.VTiger.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Vtiger.GenericUtils.BaseClass;
import com.crm.Vtiger.GenericUtils.ExcelFileUtility;
import com.crm.Vtiger.GenericUtils.JavaUtility;
import com.crm.Vtiger.GenericUtils.PropertyFileUtility;
import com.crm.Vtiger.GenericUtils.WebDriverUtility;
import com.crm.Vtiger.ObjectRepository.CreateOrganisationPage;
import com.crm.Vtiger.ObjectRepository.HomePageClass;
import com.crm.Vtiger.ObjectRepository.LoginClass;
import com.crm.Vtiger.ObjectRepository.OrganisationInfoPage;
import com.crm.Vtiger.ObjectRepository.OrganisationPage;


public class CreateOrganisationTest extends BaseClass {

	@Test
	public void createOrg() throws Throwable
	{
		String orgName = eUtil.readDataFromExcel("Sheet1", 1, 1)+JavaUtility.generateRandomNumber();
		
		HomePageClass hp=new HomePageClass(driver);
		hp.clickOnOrgLink();
		Assert.assertEquals(false, true);
		OrganisationPage op=new OrganisationPage(driver);
		op.getCreateOrgIcon().click();
		
		CreateOrganisationPage cp=new CreateOrganisationPage(driver);
		cp.createOrg(orgName);
		
		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		oip.verifyOrgName();
	    
	}

}
