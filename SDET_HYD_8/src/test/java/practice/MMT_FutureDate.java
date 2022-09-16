package practice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT_FutureDate {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();

		driver.findElement(By.id("fromCity")).sendKeys("banglore");
		driver.findElement(By.xpath("//div[text()='BLR']")).click();

		driver.findElement(By.id("toCity")).sendKeys("mumbai");
		driver.findElement(By.xpath("//div[text()='BOM']")).click();

		Thread.sleep(2000);

		for (int i = 0; i < 12; i++) 
		{
			try {
				driver.findElement(By.xpath("//div[@aria-label='Thu May 04 2023']")).click();
				break;

			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}	
		}



	}

}
