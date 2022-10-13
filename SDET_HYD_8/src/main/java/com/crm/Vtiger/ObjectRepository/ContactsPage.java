package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createConIcon;

	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateConIcon() {
		return createConIcon;
	}

	@FindBys({@FindBy (xpath ="//a"), @FindBy(id="username")})
	private WebElement element;

	@FindAll({ @FindBy(name=""), @FindBy(tagName="")})
	private WebElement w;
}
