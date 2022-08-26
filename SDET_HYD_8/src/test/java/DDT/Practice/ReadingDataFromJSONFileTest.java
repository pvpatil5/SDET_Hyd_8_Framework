package DDT.Practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class ReadingDataFromJSONFileTest {

	@Test
	public void readingDataFromJSON() throws Throwable
	{
		//Step=1 Convert JSON File into JSON Object
		FileReader fr=new FileReader("./CommonDataDDT.json");
		
		//Step=2 Convert JSON Object into Java Object
		JSONParser jp=new JSONParser();
		Object jobj = jp.parse(fr);
		
		//Step=3 Read Data by using HashMap
		HashMap hp = (HashMap)jobj;
		String URL=(String) hp.get("url");
		System.out.println(URL);
	}

}
