package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.GenericUtils.WebDriverUtility;

public class HomePageClass {

	public WebDriverUtility wUtil=new WebDriverUtility();
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement conLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement logOut;
	
	public HomePageClass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	
	
	public WebElement getConLink() {
		return conLink;
	}

	public WebElement getAdmImg() {
		return admImg;
	}

	public WebElement getLogOut() {
		return logOut;
	}

	public void clickOnOrgLink()
	{
		orgLink.click();
	}
	
	public void setLogout(WebDriver driver)
	{
		wUtil.mouseoverAction(driver, admImg);
		logOut.click();
	}
}
