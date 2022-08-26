package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	@FindBy(name = "lastname")
	private WebElement ln;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement orgLink;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLn() {
		return ln;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createCon(String lastName)
	{
		ln.sendKeys(lastName);
		orgLink.click();
	}

}
