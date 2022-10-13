package practice;

public class Sample {

	public static void main(String[] args) {

		String str = "aaabbcccaa";
		int count =1;
		char[] arr=str.toCharArray();

		for (int i = 0; i < arr.length; i++)
		{
			for (int j = i+1; j < arr.length; j++)
			{
				if(arr[i]==arr[j]) 
				{
					count++;
					arr[j]='0';
				}
			}
			
			if(arr[i]!='0') 
			{
				System.out.println(arr[i]+"-->"+count);
			}

		}
		

	}

}
