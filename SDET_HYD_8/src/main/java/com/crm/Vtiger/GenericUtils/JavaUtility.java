package com.crm.Vtiger.GenericUtils;

import java.util.Random;

public class JavaUtility {

	/**
	 * author Soumya
	 * @return
	 */
	public static int generateRandomNumber()
	{
		Random r=new Random();
		int random = r.nextInt(2000);
		return random;
	}

}
