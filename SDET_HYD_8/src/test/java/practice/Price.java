package practice;

public class Price {

	public static void main(String[] args) 
	{
		String amazonprice= "? 1,19,900"; 
		String flipkartprice= "? 1,19,999";
		
		String newpriceamazon=	amazonprice.replaceAll("[^0-9]", "");

		String newpriceflipkart=	flipkartprice.replaceAll("[^0-9]", "");

		int amazonprice1=	Integer.parseInt(newpriceamazon);
		int flipkartprice1=	Integer.parseInt(newpriceflipkart);

		if(amazonprice1==flipkartprice1)
		{
			System.out.println("Prices are same");
		}
		else if (amazonprice1>flipkartprice1) {
			System.out.println("Amazon price is more than flipkart");
		}
		else 
		{
			System.out.println("Flipkart  price is more than amazon");
		}

	}

}
