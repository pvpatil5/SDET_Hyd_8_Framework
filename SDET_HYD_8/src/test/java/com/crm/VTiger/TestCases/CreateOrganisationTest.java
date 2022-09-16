package com.crm.VTiger.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.Vtiger.GenericUtils.BaseClass;
import com.crm.Vtiger.GenericUtils.JavaUtility;
import com.crm.Vtiger.ObjectRepository.CreateOrganisationPage;
import com.crm.Vtiger.ObjectRepository.HomePageClass;
import com.crm.Vtiger.ObjectRepository.OrganisationInfoPage;
import com.crm.Vtiger.ObjectRepository.OrganisationPage;


public class CreateOrganisationTest extends BaseClass {

	@Test(retryAnalyzer = com.crm.Vtiger.GenericUtils.RetryAnalyserClass.class)
	public void createOrg() throws Throwable
	{
		String orgName = eUtil.readDataFromExcel("Sheet1", 1, 1)+JavaUtility.generateRandomNumber();
		
		HomePageClass hp=new HomePageClass(driver);
		hp.clickOnOrgLink();
		Assert.assertEquals(false, true);
		OrganisationPage op=new OrganisationPage(driver);
		op.getCreateOrgIcon().click();
		
		CreateOrganisationPage cp=new CreateOrganisationPage(driver);
		Thread.sleep(2000);
		cp.createOrg(orgName);
		
		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		oip.verifyOrgName();
	    
	}

}
