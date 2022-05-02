package admin.methods.adminview;

import appconstants.ShoppingAppConstants;
import utilities.classes.databaseoperations.databasegetoperations.GetDetailsFromDatabase;

public class DisplayOrderDetails {

	public void displayOrderDetails(int orderId)
	{
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		 
		String deliveryStatus = getDetailsFromDb.getDeliveryStatus(orderId);
		String deliveryDate = getDetailsFromDb.getDeliveryDate(orderId);
		
		int productId = getDetailsFromDb.getProductIdUsingOrderId(orderId);
		String productName = getDetailsFromDb.getProductName(productId);
		String productCategory = getDetailsFromDb.getProductCategory(productId);
		
		int supplierId = getDetailsFromDb.getSupplierId(productId);
		String supplierName = getDetailsFromDb.getSupplierName(supplierId);
		long supplierPhoneNumber = getDetailsFromDb.getSupplierPhoneNumber(supplierId);
		
		int customerId = getDetailsFromDb.getCustomerId(orderId);
		String customerName = getDetailsFromDb.getCustomerName(customerId);
		String customerAddress = getDetailsFromDb.getCustomerAddress(customerId);
		long customerPhoneNumber = getDetailsFromDb.getCustomerPhoneNumber(customerId);
		int productPrice = getDetailsFromDb.getProductPrice(productId);
		
		//print
		System.out.println(ShoppingAppConstants.greaterThanLine+"\n");
		System.out.println("\t\t\tORDER DETAILS\n");
		System.out.println(ShoppingAppConstants.lessThanLine+"\n");
		System.out.printf("%s", "orderId");
		System.out.printf("\n%d", orderId);
		System.out.print("\nOrder is "+deliveryStatus);
		System.out.printf("%32s %s","Delivery Date: " ,deliveryDate);
		System.out.println("\n"+ShoppingAppConstants.bigUnderscoreLine+"\n");
		System.out.printf("%s", "Supplier Id\n");
		System.out.printf("%d", supplierId);
		System.out.printf("\n%s",supplierName);
		System.out.printf("%50s %s","Contact supplier at: ",supplierPhoneNumber);
		System.out.println("\n"+ShoppingAppConstants.bigUnderscoreLine+"\n");
		System.out.println("Shipping Details\n");
		System.out.printf("%s", customerName);
		System.out.printf("\n%s", customerAddress);
		System.out.printf("\n%d", customerPhoneNumber);
		System.out.printf("%40s %s","Total Price: ",productPrice);
		System.out.println("\n"+ShoppingAppConstants.bigUnderscoreLine+"\n");
		
	}
}