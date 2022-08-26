package DDT.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadingDataFromPropertyFileTest {

	@Test
	public void readDataFromProperty() throws Throwable
	{
		FileInputStream fis=new FileInputStream("./CommonDataDDT.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		System.out.println(URL);
	}

}
