package GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {

	/**
	 * This method is for maximizing the window
	 * @author SOUMYASANTA SAHOO
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method for implicitWait
	 * @author SOUMYASANTA SAHOO
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	/**
	 * This method for Explicitwait
	 * @author SOUMYASANTA SAHOO
	 * @param driver
	 * @param ele
	 */
	public void waitForVisibiltyOfElement(WebDriver driver, WebElement ele)
	{
		WebDriverWait wb=new WebDriverWait(driver, 30);
		wb.until(ExpectedConditions.visibilityOf(ele));
	}
	
	/**
	 * These methods are for handling dropdown
	 * @param ele
	 * @param index
	 */
	public void selectingByIndex(WebElement ele, int index)
	{
		Select se=new Select(ele);
		se.selectByIndex(index);
	}
	
	public void selectingByValue(WebElement ele,String value)
	{
		Select sel=new Select(ele);
		sel.selectByValue(value);
	}
	
	public void selectingByVisible(WebElement ele,String text)
	{
		Select sel=new Select(ele);
		sel.selectByVisibleText(text);
	}
	
	public void mouseoverAction(WebDriver driver, WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}

	public void handlingFrame(WebDriver driver, int index)
	{
	    driver.switchTo().frame(index);
	}
	
	public void switchingWindow(WebDriver driver, String partialWindowText)
	{
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		while(it.hasNext())
		{
			String winId = it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWindowText))
			{
				break;
			}
		}
	}
	
	public void handlingEnterButton() throws Throwable
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void takingScreenshot(WebDriver driver) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot");
		Files.copy(src, dest);
	}
}
