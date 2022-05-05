package view.orders;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetOrderDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetProductDetails;
import databaseoperations.interfaces.gettable.CustomerDetailsGettable;
import databaseoperations.interfaces.gettable.OrderDetailsGettable;
import databaseoperations.interfaces.gettable.ProductDetailsGettable;
import driver.customers.CustomerMainDriver;

public class ShowOrderInfo {

	public void showOrderInfo(int orderId)
	{

		CustomerDetailsGettable getCustomerDetails = new GetCustomerDetails();
		ProductDetailsGettable getProductDetails = new GetProductDetails();
		OrderDetailsGettable getOrderDetails = new GetOrderDetails();
		 
		String deliveryStatus = getOrderDetails.getDeliveryStatus(orderId);
		String deliveryDate = getOrderDetails.getDeliveryDate(orderId);
		
		int productId = getProductDetails.getProductIdUsingOrderId(orderId);
		String productName = getProductDetails.getProductName(productId);
		String productCategory = getProductDetails.getProductCategory(productId);
		
		int customerId = getCustomerDetails.getCustomerId(orderId);
		String customerName = getCustomerDetails.getCustomerName(customerId);
		String customerAddress = getCustomerDetails.getCustomerAddress(customerId);
		long customerPhoneNumber = getCustomerDetails.getCustomerPhoneNumber(customerId);
		int productPrice = getProductDetails.getProductPrice(productId);
		
		//print
		System.out.println(ShoppingAppConstants.greaterThanLine+"\n");
		System.out.println("\t\t\t\tORDER INFO\n");
		System.out.println(ShoppingAppConstants.lessThanLine+"\n");
		System.out.printf("%s", "orderId");
		System.out.printf("\n%d", orderId);
		System.out.print("\nOrder is "+deliveryStatus);
		System.out.printf("%32s %s","Delivery Date: " ,deliveryDate);
		System.out.println("\n"+ShoppingAppConstants.bigUnderscoreLine+"\n");
		System.out.printf("%s", "product Name\n\n");
		System.out.printf("%s", productName);
		System.out.printf("\n%s",productCategory);
		//System.out.printf("%50s %s","Contact supplier at: ",supplierPhoneNumber);
		System.out.println("\n"+ShoppingAppConstants.bigUnderscoreLine+"\n");
		System.out.println("Shipping Address\n");
		System.out.printf("%s", customerName);
		System.out.printf("\n%s", customerAddress);
		System.out.printf("\n%d", customerPhoneNumber);
		System.out.printf("%40s %s","Total Price: ",productPrice);
		System.out.println("\n"+ShoppingAppConstants.bigUnderscoreLine+"\n");
		System.out.println(ShoppingAppConstants.goHome);
		
		Scanner scanner = new Scanner(System.in);
		int userInput = scanner.nextInt();

		if(userInput==0)
		{
			CustomerMainDriver customerMainDrive = new CustomerMainDriver();
			customerMainDrive.customerMainDriver();
		}
		else
		{
			System.out.println(ShoppingAppConstants.invalidChoice);
			showOrderInfo(orderId);
		}
		
	}
}
