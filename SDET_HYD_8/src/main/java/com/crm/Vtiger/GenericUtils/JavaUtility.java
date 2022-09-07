package com.crm.Vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

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

	public static String datee() {
		Date currentDate= new Date();
		String date=	currentDate.toString();
		System.out.println(date);

		// Wed Sep 07 13:03:17 IST 2022
		//  0       1    2     3          4      5

		String arr[]=	date.split(" ");
		String date1 =arr[2];
		String month = arr[1];
		String year= arr[5];
		return date1+" "+month+" "+year;

	}
}
