package practice;

public class Demo {

	public static void main(String[] args) {


		// Digits has to replaced by dot and spl chracters to be replaced by space
		String str ="India will first123 have to ho#^& and pray that If th!() above 3 desired results do indeed g# India's way then As things stand, it wo@&* really be w*shful thi123nking to hope results do indeed go India's way";
		
				String 	newstr="";
				String secondnew="";
		
				for (int i = 0; i < str.length(); i++) 
				{		
					secondnew=str.replaceAll("[^a-zA-Z0-9]", " ");
					newstr	=secondnew.replaceAll("[0-9]", ".");
				}
				System.out.print (newstr);
				System.out.println("================");
				System.out.println(secondnew);

		//		String arr[]=	str.split(" ");
		//
		//		for (int i = 0; i < arr.length; i++) 
		//		{
		//			char a[]=	arr[i].toCharArray();
		//
		//			for (int j = 0; j < a.length; j++) 
		//			{
		//				if(Character.isDigit(a[j])) 
		//				{
		//					a[j]='.';
		//				}
		//				else if(!((a[j] >= 'a' && a[j] <= 'z') || (a[j] >= 'A' && a[j] <= 'Z'))) 
		//				{
		//					a[j]=' ';
		//				}
		//				System.out.print(a[j]);
		//			}		
	}

}

