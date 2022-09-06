package com.crm.VTiger.TestCases;

import java.util.Date;

import org.testng.annotations.Test;

public class DateTest {

	@Test
	public void generateDate()
	{
		Date d=new Date();
		String currentDate = d.toString().replace(":", "_").replace(" ", "_");
		System.out.println(currentDate);
	}

}
