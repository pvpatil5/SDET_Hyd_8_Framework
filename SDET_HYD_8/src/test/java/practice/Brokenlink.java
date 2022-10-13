package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenlink {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/broken");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		
		System.out.println("Total links available = " +links.size());
		
		for(WebElement link :links)
		{
			String URL =link.getAttribute("href");
			verifylinks(URL);
		}

	
		
	}
	
	public static void verifylinks(String link) throws IOException 
	{
		URL url = new URL(link);
		
		HttpURLConnection  httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setConnectTimeout(5000);
		httpURLConnection.connect();
		
		if(httpURLConnection.getResponseCode()== 200) 
		{
			System.out.println(link +" = Link is Working");
		}
		else {
			System.out.println(link +" = Link is Not-Working");
		}
	}

}
