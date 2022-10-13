package practice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT_DataProvider {

	@Test(dataProvider = "dataprovider")
	public void data(String src, String dest) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		Demo123 demo123 = new Demo123();
		demo123.t1();
		
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		//driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.id("fromCity")).sendKeys(src);
		driver.findElement(By.xpath("//div[text()='"+src+"']")).click();

		driver.findElement(By.id("toCity")).sendKeys(dest);
		driver.findElement(By.xpath("//div[text()='"+dest+"']")).click();
	}

	@DataProvider
	public Object[][] dataprovider()
	{
		Object obj [][]= new Object[1][2];

		obj[0][0]="BLR";
		obj[0][1]="BOM";

//		obj[1][0]="MAA";
//		obj[1][1]="GOI";
//
//		obj[2][0]="HYD";
//		obj[2][1]="BOM";

		return obj;

	}
}
