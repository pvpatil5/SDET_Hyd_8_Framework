package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_1 {

	@Test(dataProvider = "dataprovider")
	public void test(String src, String dest) 
	{
		System.out.println(src +" --> "+dest);
	}

	@DataProvider
	public Object[][] dataprovider()
	{
		Object obj [][]= new Object[3][2];

		obj[0][0]="BLR";
		obj[0][1]="BOM";

		obj[1][0]="MAA";
		obj[1][1]="GOI";

		obj[2][0]="HYD";
		obj[2][1]="BOM";

		return obj;

	}
}
