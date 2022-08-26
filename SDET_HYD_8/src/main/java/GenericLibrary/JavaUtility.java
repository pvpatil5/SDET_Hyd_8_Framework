package GenericLibrary;

import java.util.Random;

public class JavaUtility {

	/**
	 * author Soumya
	 * @return random integer number
	 */
	public static int generateRandomNumber()
	{
		Random r=new Random();
		int random = r.nextInt(2000);
		return random;
	}
	
	
}
