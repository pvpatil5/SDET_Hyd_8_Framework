package practice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fakedata {

	public static void main(String[] args) {
		//
		Date date = new Date();
		String d=date.toString();
		System.out.println(d);

		// Thu Oct 06 2022
		// Thu Oct 06 15:25:07 IST 2022


		String[] arr = d.split(" ");

		String day= arr[0];
		String month =arr[1];
		String date1=arr[2];
		String year=arr[5];


		String exp= day+" "+month+" "+date1+" "+year;

		System.out.println(exp);

		//		Faker faker = new  Faker();
		//
		//		String fname=	faker.name().firstName();
		//
		//		System.out.println(fname);
		//
		//		String cityname=faker.address().cityName();
		//		System.out.println(cityname);
		//
		//		String cname=faker.company().name();
		//		System.out.println(cname);
		//		

				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("https://makemytrip.com");
				driver.manage().window().maximize();
				driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
				WebElement element=driver.findElement(By.xpath("//span[.='DEPARTURE']"));
			
				WebElement el = driver.findElement(By.xpath("//div[@aria-label='"+exp+"']"));
		













	}

}
