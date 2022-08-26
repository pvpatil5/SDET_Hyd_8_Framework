package GenericLibrary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class JSONFileUtility {

	public String jsonFileUtil(String key) throws Throwable
	{
		FileReader fr=new FileReader(IPathContant.JSONFILEPATH);
		
		JSONParser jp=new JSONParser();
		Object jobj = jp.parse(fr);
		
		HashMap hp = (HashMap)jobj;
		String value = (String) hp.get(key);
		return value;
	}

}
