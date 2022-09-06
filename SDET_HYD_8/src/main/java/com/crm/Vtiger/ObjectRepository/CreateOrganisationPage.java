package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.Vtiger.GenericUtils.WebDriverUtility;

public class CreateOrganisationPage {

	public WebDriverUtility wUtil=new WebDriverUtility();
	
	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(name="industry")
	private WebElement indusType;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	public CreateOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getIndusType() {
		return indusType;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrg(String org)
	{
		orgName.sendKeys(org);
		saveBtn.click();
	}
	
	public void createOrgwithIndustry(String org, String ind)
	{
		orgName.sendKeys(org);
		wUtil.selectingByVisible(indusType, ind);
		saveBtn.click();
	}

}
