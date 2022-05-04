package view.admin;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetOrderDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetProductDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetSupplierDetails;
import databaseoperations.interfaces.gettable.CustomerDetailsGettable;
import databaseoperations.interfaces.gettable.OrderDetailsGettable;
import databaseoperations.interfaces.gettable.ProductDetailsGettable;
import databaseoperations.interfaces.gettable.SupplierDetailsGettable;
import driver.admin.ManageOrderDetails;

public class DisplayOrderDetails {

	public void displayOrderDetails(int orderId)
	{
		OrderDetailsGettable getOrderDetails = new GetOrderDetails();
		ProductDetailsGettable getProductDetails = new GetProductDetails();
		CustomerDetailsGettable getCustomerDetails = new GetCustomerDetails();
		SupplierDetailsGettable getSupplierDetails = new GetSupplierDetails();
		 
		String deliveryStatus = getOrderDetails.getDeliveryStatus(orderId);
		String deliveryDate = getOrderDetails.getDeliveryDate(orderId);
		
		int productId = getProductDetails.getProductIdUsingOrderId(orderId);
		String productName = getProductDetails.getProductName(productId);
		String productCategory = getProductDetails.getProductCategory(productId);
		
		int supplierId = getSupplierDetails.getSupplierId(productId);
		String supplierName = getSupplierDetails.getSupplierName(supplierId);
		long supplierPhoneNumber = getSupplierDetails.getSupplierPhoneNumber(supplierId);
		
		int customerId = getCustomerDetails.getCustomerId(orderId);
		String customerName = getCustomerDetails.getCustomerName(customerId);
		String customerAddress = getCustomerDetails.getCustomerAddress(customerId);
		long customerPhoneNumber = getCustomerDetails.getCustomerPhoneNumber(customerId);
		int productPrice = getProductDetails.getProductPrice(productId);
		
		//display
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
		
		ManageOrderDetails manageOrderDetails = new ManageOrderDetails();
		manageOrderDetails.manageOrderDetails(orderId);
		
	}
}