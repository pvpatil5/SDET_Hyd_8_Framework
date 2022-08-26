package DDT.Practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadingDataFromXMLFileTest {

	@Test
	public void readDataFromXML(XmlTest xml)
	{
		String URL=xml.getParameter("url");
		System.out.println(URL);
	}

}
