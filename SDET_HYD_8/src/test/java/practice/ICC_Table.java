package practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICC_Table {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");

		String text=driver.findElement(By.xpath("//table")).getText();
		System.out.println(text);

		//		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		//
		//		for (int i = 1; i <= rows.size(); i++) {
		//
		//			for (int j = 1; j <= 5; j++) 
		//			{
		//				String name=	driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]")).getText();
		//				System.out.print(name+" ");
		//			}
		//			System.out.println();
		//
		//		}

		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		for (int i = 1; i <= rows.size(); i++) {

			
			
				String name=	driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText();
				System.out.println(name+" ");
			

		}



	}
}
