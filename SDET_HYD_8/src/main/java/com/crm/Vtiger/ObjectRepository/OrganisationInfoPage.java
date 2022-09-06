package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {

	@FindBy(id = "dtlview_Organization Name")
	private WebElement orgNameInfoPage;
	
	@FindBy(className = "dvHeaderText")
	private WebElement orgInfo;
	
	public OrganisationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameInfoPage() {
		return orgNameInfoPage;
	}

	public WebElement getOrgInfo() {
		return orgInfo;
	}
	
	public void verifyOrgName()
	{
		String text = orgNameInfoPage.getText();
		String orgInformation = orgInfo.getText();
		if(orgInformation.contains(text))
		{
			System.out.println(text+" is available");
		}
	}

}
