package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginClass {

	//Rule=1 Create PM Class for each page on Web Page & class name should be same as Page name
	
	//Rule=2 Locate element them using findBy, findBys & findall
	@FindBy(name="user_name")
	private WebElement un_txt_Fd;
	
	@FindBy(name="user_password")
	private WebElement pwd_txt_Fd;
	
	@FindBy(id="submitButton")
	private WebElement lgn_btn;

	//Rule=3 Create constructor for initializing the element using PageFactory class
	public LoginClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Rule=4 Create private getter method
	public WebElement getUn_txt_Fd() {
		return un_txt_Fd;
	}

	public WebElement getPwd_txt_Fd() {
		return pwd_txt_Fd;
	}

	public WebElement getLgn_btn() {
		return lgn_btn;
	}
	
	//Rule=5 Create buisness logic method
	/**
	 * This is the buisness logic for Login
	 * @author SOUMYASANTA SAHOO
	 */
	public void setLogin(String username, String Password)
	{
		un_txt_Fd.sendKeys(username);
		pwd_txt_Fd.sendKeys(Password);
		lgn_btn.click();
	}
	
	
	
	

}
