package com.crm.VTiger.TestCases;

import org.testng.annotations.Test;
import com.crm.Vtiger.GenericUtils.BaseClass;
import com.crm.Vtiger.GenericUtils.JavaUtility;
import com.crm.Vtiger.ObjectRepository.CreateOrganisationPage;
import com.crm.Vtiger.ObjectRepository.HomePageClass;
import com.crm.Vtiger.ObjectRepository.OrganisationInfoPage;
import com.crm.Vtiger.ObjectRepository.OrganisationPage;

public class CreateOrganisationWithIndustryTest extends BaseClass {

	@Test
	public void createOrgWithIndus() throws Throwable
	{
		String orgName = eUtil.readDataFromExcel("Sheet1", 4, 1)+JavaUtility.generateRandomNumber();
		String indType = eUtil.readDataFromExcel("Sheet1", 4, 2);

		HomePageClass hp=new HomePageClass(driver);
		hp.clickOnOrgLink();
		
		OrganisationPage op=new OrganisationPage(driver);
		//op.getCreateOrgIcon().click();
		
		CreateOrganisationPage cp=new CreateOrganisationPage(driver);
		cp.createOrgwithIndustry(orgName, indType);

		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		oip.verifyOrgName();
	}

}
