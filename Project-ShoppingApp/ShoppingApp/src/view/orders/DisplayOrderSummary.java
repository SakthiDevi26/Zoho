package view.orders;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetProductDetails;
import databaseoperations.interfaces.gettable.CustomerDetailsGettable;
import databaseoperations.interfaces.gettable.ProductDetailsGettable;

public class DisplayOrderSummary {

	public void displayOrderSummary(int productId)
	{
		CustomerDetailsGettable getCustomerDetails = new GetCustomerDetails();
		ProductDetailsGettable getProductDetails = new GetProductDetails();
		int customerId = getCustomerDetails.getCurrentlyLoggedInCustomerId();
		
		String customerName = getCustomerDetails.getCustomerName(customerId);
		String customerAddress = getCustomerDetails.getCustomerAddress(customerId);
		long customerPhoneNumber = getCustomerDetails.getCustomerPhoneNumber(customerId);
		String productName = getProductDetails.getProductName(productId);
		String productCategory = getProductDetails.getProductCategory(productId);
		int productPrice = getProductDetails.getProductPrice(productId);
		
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
