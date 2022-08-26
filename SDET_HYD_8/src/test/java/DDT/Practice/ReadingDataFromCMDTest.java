package DDT.Practice;

import org.testng.annotations.Test;

public class ReadingDataFromCMDTest {

	@Test
	public void readDataFromCMDTest()
	{
		String URL=System.getProperty("url");
		String UN = System.getProperty("username");
		String pwd=System.getProperty("password");
		
		System.out.println("URL is "+URL);
	    System.out.println("username is "+UN);
	    System.out.println("password is "+pwd);
	}

}
