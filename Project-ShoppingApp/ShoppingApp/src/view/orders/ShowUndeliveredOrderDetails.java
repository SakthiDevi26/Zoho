package view.orders;

import java.util.ArrayList;
import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetIdUsingId;
import databaseoperations.classes.databasegetoperations.getEntities.GetOrderDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetCustomerEntityDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetProductEntityDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetSupplierEntityDetails;
import databaseoperations.interfaces.gettable.IdGettable;
import driver.customers.CustomerMainDriver;
import entities.Customers;
import entities.Products;
import entities.Shipment;
import entities.Suppliers;


public class ShowUndeliveredOrderDetails {

	/**
	 * 
	 * @param orderId
	 */
	public void showUndeliveredOrderDetails(int orderId) {
		
		IdGettable getId = new GetIdUsingId();
		
		//print
		System.out.println(ShoppingAppConstants.greaterThanLine+"\n");
		System.out.println("\t\t\t\tORDER INFO\n");
		System.out.println(ShoppingAppConstants.lessThanLine+"\n");
		
		//orderDetails
		
		GetOrderDetails getOrderDetails = new GetOrderDetails();
		for(Shipment order : getOrderDetails.getOrderDetails(orderId))
		{
			System.out.printf("%s", "orderId");
			System.out.printf("\n%d", orderId);
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
		
		
		//supplier details
		int supplierId = getId.getId(productId, ShoppingAppConstants.supplierIdColumn,ShoppingAppConstants.productsTable,ShoppingAppConstants.productIdColumn);
		GetSupplierEntityDetails getSupplier = new GetSupplierEntityDetails();
		ArrayList<Suppliers>supplierList = getSupplier.getSupplierList(supplierId);
		for(Suppliers supplier : supplierList)
		{
			System.out.println(supplier.supplierName);
			System.out.printf("%50s %s","Contact supplier at: ",supplier.supplierPhoneNumber);
		}
		
		System.out.println("\n"+ShoppingAppConstants.bigUnderscoreLine+"\n");
		System.out.println("Shipping Address\n");
		
		
		//customer details
		GetCustomerEntityDetails getCustomer = new GetCustomerEntityDetails();
		ArrayList<Customers> customerList = new ArrayList<Customers>();
		for(Customers customer : customerList)
		{
				
			System.out.printf("%s", customer.customerName);
			System.out.printf("\n%s", customer.customerAddress);
			System.out.printf("\n%d", customer.customerPhoneNumber);
			System.out.println("\n"+ShoppingAppConstants.bigUnderscoreLine+"\n");
		}
			
		System.out.println(ShoppingAppConstants.goHome);
		Scanner scanner = new Scanner(System.in);
		int userInput = scanner.nextInt();

		if(userInput==0) {
			CustomerMainDriver customerMainDrive = new CustomerMainDriver();
			customerMainDrive.customerMainDriver();
		}
		else {
			System.out.println(ShoppingAppConstants.invalidChoice);
			showUndeliveredOrderDetails(orderId);
		}
	}

}
