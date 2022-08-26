package com.crm.VTiger.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.JSONFileUtility;
import GenericLibrary.JavaUtility;
import GenericLibrary.PropertyFileUtility;
import GenericLibrary.WebDriverUtility;
import ObjectRepository.CreateOrganisationPage;
import ObjectRepository.HomePageClass;
import ObjectRepository.LoginClass;
import ObjectRepository.OrganisationInfoPage;
import ObjectRepository.OrganisationPage;

public class CreateOrganisationWithIndustryTest {

	@Test
	public void createOrgWithIndus() throws Throwable
	{
		WebDriverUtility wUtil=new WebDriverUtility();
		
		JSONFileUtility jUtil=new JSONFileUtility();
		String URL = jUtil.jsonFileUtil("url");
		String UN = jUtil.jsonFileUtil("username");
		String pwd = jUtil.jsonFileUtil("password");
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		String orgName = eUtil.readDataFromExcel("Sheet1", 4, 1)+JavaUtility.generateRandomNumber();
		String indType = eUtil.readDataFromExcel("Sheet1", 4, 2);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);

		LoginClass lc=new LoginClass(driver);
		lc.setLogin(UN,pwd);

		HomePageClass hp=new HomePageClass(driver);
		hp.clickOnOrgLink();
		
		OrganisationPage op=new OrganisationPage(driver);
		op.getCreateOrgIcon().click();
		
		CreateOrganisationPage cp=new CreateOrganisationPage(driver);
		cp.createOrgwithIndustry(orgName, indType);

		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		oip.verifyOrgName();

		hp.setLogout(driver);
		Thread.sleep(5000);
		driver.close();
	}

}
