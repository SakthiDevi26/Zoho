package banking;

public class Conditions {
	private static final int NULL = 0;
	public static boolean withdraw(int accountNumber,int balance, int amount) {
		
		if(amount%5!=0)
		{
			System.out.println("Please withdraw amount in multiples of 5");
			return false;
		}
		int charges = 0;
		if(amount>100)
		{
			charges = (int) (0.04*amount);
			amount = charges + amount;
			System.out.println("Charges:"+charges);
		}
		else
		{
			charges =(int) (0.02*amount);
			amount = charges +amount;
			System.out.println("Charges:"+charges);
		}
		if (accountNumber==NULL || amount == NULL) {
			System.out.println("No amount Added");
			return false;
		}
		
		else if (amount>balance)
		{
			System.out.println("Insufficient balance");
			return false;
		}
		return true;
	}
	public static boolean swipe(int accountNumber,int balance, int amount)
	{
		int cashback = 0;
		cashback = (int) (0.01 * amount);
		System.out.println("Cashback: "+cashback);
		amount = amount - cashback;
		// validation
		if (accountNumber==NULL || amount == NULL) {
			System.out.println("No amount Added");
			return false;
		}
		
		else if (amount>balance)
		{
			System.out.println("Insufficient balance");
			return false;
		}
		return true;
	}
}
