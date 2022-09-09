package practice;

public class Password 
{
	public static void main(String[] args) {
		String str ="assword123@";

		if(checkSpecialCharacters(str)&& checkLength(str) && checkLowercase(str) && checkNumber(str) &&checkUpperCase(str))
		{
			System.out.println("True");
		}
		else 
			System.out.println("false");

	}

	public static  boolean checkLength(String s1) 
	{
		boolean status = false;
		if(s1.length()>=8) 
		{
			return true;
		}
		return status;
	}

	public static boolean checkUpperCase(String s1) 
	{
		boolean status = false;
		char arr[]=s1.toCharArray();
		if(Character.isUpperCase(arr[0]))
		{
			return true;
		}
		return status;
	}

	public static boolean checkNumber(String s1) 
	{
		boolean status = false;
		char arr[]=s1.toCharArray();

		for (int i = 0; i < arr.length; i++) 
		{
			if(Character.isDigit(arr[i]))
			{
				status = true;
				break;
			}
		}
		return status;
	}

	public static boolean checkLowercase(String s1)
	{
		boolean status = false;
		char arr[]=s1.toCharArray();

		for (int i = 0; i < arr.length; i++) 
		{
			if(Character.isLowerCase(arr[i]))
			{
				status = true;
				break;
			}
		}
		return status;
	}

	public static boolean checkSpecialCharacters(String s1) 
	{
		boolean status = false;
		char arr[]=s1.toCharArray();

		for (int i = 0; i < arr.length; i++) 
		{
			if(!Character.isAlphabetic(arr[i]) && !Character.isDigit(arr[i]))
			{
				status = true;
				break;
			}
		}
		return status;
	}
}














