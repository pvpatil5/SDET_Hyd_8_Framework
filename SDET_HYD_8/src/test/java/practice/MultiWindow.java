package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultiWindow {

	public static void main(String[] args) throws AWTException, InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://amazon.in");

		WebElement mobiles = driver.findElement(By.xpath("//div[@id='nav-xshop']/a[text()='Mobiles']"));
		WebElement service = driver.findElement(By.xpath("//div[@id='nav-xshop']/a[text()='Customer Service']"));
		WebElement books = driver.findElement(By.xpath("//div[@id='nav-xshop']/a[text()='Books']"));

		Robot robot = new Robot();

		Actions actions = new Actions(driver);

		actions.contextClick(mobiles).build().perform();

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		actions.contextClick(service).build().perform();

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		actions.contextClick(books).build().perform();

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Set<String> window_ids = driver.getWindowHandles();

		//System.out.println("Total window open are = "+ window_ids.size());

		for(String id : window_ids)
		{
			String title=	driver.switchTo().window(id).getTitle();
			if(!title.equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"))
			{

				driver.close();
			}
			
		}

		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//img[@src='https://images-na.ssl-images-amazon.com/images/G/31/img21/Wireless/katariy/Category_page/march/spritesingle_2_2._CB625084132_.jpg']")).click();





	}

}
