package customers.methods.buynow;

import appconstants.ShoppingAppConstants;
import databaseoperations.databasegetoperations.GetDetailsFromDatabase;

public class DisplayOrderSummary {

	public void displayOrderSummary(int productId)
	{
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		int customerId = getDetailsFromDb.getCurrentlyLoggedInCustomerId();
		
		String customerName = getDetailsFromDb.getCustomerName(customerId);
		String customerAddress = getDetailsFromDb.getCustomerAddress(customerId);
		long customerPhoneNumber = getDetailsFromDb.getCustomerPhoneNumber(customerId);
		String productName = getDetailsFromDb.getProductName(productId);
		String productCategory = getDetailsFromDb.getProductCategory(productId);
		int productPrice = getDetailsFromDb.getProductPrice(productId);
		
		//Display
		System.out.println(ShoppingAppConstants.stars+"\n");
		System.out.println(ShoppingAppConstants.smallHyphen+"ORDER SUMMARY"+ShoppingAppConstants.smallHyphen);
		System.out.println(customerName);
		System.out.println(customerAddress);
		System.out.println(customerPhoneNumber);
		System.out.println(ShoppingAppConstants.underscoreLine);
		System.out.print(productName);
		System.out.println("\t\t\t"+productCategory);
		System.out.println(ShoppingAppConstants.underscoreLine);
		System.out.println("Price Details:\n");
		System.out.println("Delivery Charges:\t\tFree");
		System.out.println("Total Amount:\t\t\t"+productPrice);
		System.out.println("\n"+ShoppingAppConstants.stars);
	}

}
