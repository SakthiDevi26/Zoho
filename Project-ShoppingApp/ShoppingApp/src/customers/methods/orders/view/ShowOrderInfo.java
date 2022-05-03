package customers.methods.orders.view;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import customers.registeration.classes.driver.CustomerMainDriver;
import databaseoperations.classes.databasegetoperations.GetDetailsFromDatabase;

public class ShowOrderInfo {

	public void showOrderInfo(int orderId)
	{

		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		 
		String deliveryStatus = getDetailsFromDb.getDeliveryStatus(orderId);
		String deliveryDate = getDetailsFromDb.getDeliveryDate(orderId);
		
		int productId = getDetailsFromDb.getProductIdUsingOrderId(orderId);
		String productName = getDetailsFromDb.getProductName(productId);
		String productCategory = getDetailsFromDb.getProductCategory(productId);
		
		int customerId = getDetailsFromDb.getCustomerId(orderId);
		String customerName = getDetailsFromDb.getCustomerName(customerId);
		String customerAddress = getDetailsFromDb.getCustomerAddress(customerId);
		long customerPhoneNumber = getDetailsFromDb.getCustomerPhoneNumber(customerId);
		int productPrice = getDetailsFromDb.getProductPrice(productId);
		
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
