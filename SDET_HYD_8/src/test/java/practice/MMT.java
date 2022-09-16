package practice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT {

	public static void main(String[] args) throws InterruptedException {
		Date date = new Date();

		String[] todaysdate = date.toString().split(" ");

		String day= todaysdate[0];
		String month = todaysdate[1];
		String d = todaysdate[2];
		String year =todaysdate[5];

		String todays_date= day+" "+month+" "+d+" "+year;

		System.out.println(todays_date);

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

		driver.findElement(By.xpath("//div[@aria-label='"+todays_date+"']")).click();





	}

}
