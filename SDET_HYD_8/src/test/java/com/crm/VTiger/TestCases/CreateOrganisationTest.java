package com.crm.VTiger.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.JavaUtility;
import GenericLibrary.PropertyFileUtility;
import GenericLibrary.WebDriverUtility;
import ObjectRepository.CreateOrganisationPage;
import ObjectRepository.HomePageClass;
import ObjectRepository.LoginClass;
import ObjectRepository.OrganisationInfoPage;
import ObjectRepository.OrganisationPage;

public class CreateOrganisationTest {

	@Test
	public void createOrg() throws Throwable
	{
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("url");
		String UN = pUtil.readDataFromPropertyFile("username");
		String pwd = pUtil.readDataFromPropertyFile("password");
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		String orgName = eUtil.readDataFromExcel("Sheet1", 1, 1)+JavaUtility.generateRandomNumber();
		
		WebDriverUtility wUtil=new WebDriverUtility();
		
		WebDriver driver=new ChromeDriver();
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
		LoginClass lc=new LoginClass(driver);
		lc.setLogin(UN, pwd);
		
		HomePageClass hp=new HomePageClass(driver);
		hp.clickOnOrgLink();
		
		OrganisationPage op=new OrganisationPage(driver);
		op.getCreateOrgIcon().click();
		
		CreateOrganisationPage cp=new CreateOrganisationPage(driver);
		cp.createOrg(orgName);
		
		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		oip.verifyOrgName();
	    
	    hp.setLogout(driver);
	
	    driver.close();
	}

}
