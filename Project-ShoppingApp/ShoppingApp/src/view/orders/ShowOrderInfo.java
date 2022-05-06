package view.orders;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetIdUsingId;
import databaseoperations.classes.databasegetoperations.getEntities.GetCustomerEntityDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetOrderDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetProductEntityDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetProductDetails;
import databaseoperations.interfaces.gettable.CustomerDetailsGettable;
import databaseoperations.interfaces.gettable.IdGettable;
import databaseoperations.interfaces.gettable.OrderDetailsGettable;
import databaseoperations.interfaces.gettable.ProductDetailsGettable;
import driver.customers.CustomerMainDriver;
import entities.Customers;
import entities.Products;
import entities.Shipment;

public class ShowOrderInfo {

	/**
	 * 
	 * @param orderId
	 */
	public void showOrderInfo(int orderId)
	{
		
		//objects
		IdGettable getId = new GetIdUsingId();
		ProductDetailsGettable getProductDetails = new GetProductDetails();
		 
		//order details
		System.out.println(ShoppingAppConstants.greaterThanLine+"\n");
		System.out.println("\t\t\t\tORDER INFO\n");
		System.out.println(ShoppingAppConstants.lessThanLine+"\n");
		System.out.printf("%s", "orderId");
		System.out.printf("\n%d", orderId);
		
		GetOrderDetails getOrderDetails = new GetOrderDetails();
		for(Shipment order : getOrderDetails.getOrderDetails(orderId))
		{
			System.out.print("\nOrder is "+order.deliveryStatus);
			System.out.printf("%32s %s","Delivery Date: " ,order.deliveryDate);
		}
		
		System.out.println("\n"+ShoppingAppConstants.bigUnderscoreLine+"\n");
		
		//product details
		int productId = getId.getId(orderId,ShoppingAppConstants.productIdColumn,ShoppingAppConstants.ordersTable,ShoppingAppConstants.orderIdColumn);
		GetProductEntityDetails getProduct = new GetProductEntityDetails();
		for(Products product : getProduct.getProductList(productId))
		{
			System.out.printf("%s", "product Name\n\n");
			System.out.printf("%s", product.productName);
			System.out.printf("\n%s",product.productCategory);
			System.out.printf("%40s %s","Total Price: ",product.getProductPrice());
		}
		System.out.println("\n"+ShoppingAppConstants.bigUnderscoreLine+"\n");
		
		
		//customer details
		int customerId = getId.getId(orderId,ShoppingAppConstants.customerIdColumn,ShoppingAppConstants.ordersTable,ShoppingAppConstants.orderIdColumn);
		GetCustomerEntityDetails getCustomer = new GetCustomerEntityDetails();
		for(Customers customer : getCustomer.getCustomerList(customerId))
		{
			System.out.println("Shipping Address\n");
			System.out.printf("%s", customer.customerName);
			System.out.printf("\n%s", customer.customerAddress);
			System.out.printf("\n%d", customer.customerPhoneNumber);
		}
		
		
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
