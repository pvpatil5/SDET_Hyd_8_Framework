package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Color {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//		driver.get("https://facebook.com");
		//		String color = driver.findElement(By.xpath("//img[@alt='Facebook']")).getCssValue("color");
		//
		//		//	String msg=	driver.findElement(By.xpath("")).getAttribute("title");
		//		System.out.println(color);
		//
		//		System.out.println("Color");
		driver.get("https://lenskart.com");

		driver.findElement(By.xpath("//input[@name='q']")).click();

		List<WebElement> allnames=driver.findElements(By.xpath("//ul[@class='trending_list menu-link']/li/a"));

		for (int i = 0; i < allnames.size(); i++) {
			String name=allnames.get(i).getText();		
			System.out.println(name);
		}





	}

}
