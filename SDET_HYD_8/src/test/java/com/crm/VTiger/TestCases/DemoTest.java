package com.crm.VTiger.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;


public class DemoTest{
	
	@Test(retryAnalyzer = com.crm.Vtiger.GenericUtils.RetryAnalyserClass.class)
	public void orgTest() throws Throwable
	{
	  System.out.println("Test Start");
	  Assert.assertEquals(false, true);
	  System.out.println("Test Ends");
	}
	
	
	
	
}
