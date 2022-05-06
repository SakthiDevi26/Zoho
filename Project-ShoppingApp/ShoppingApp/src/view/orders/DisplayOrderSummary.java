package view.orders;

import java.util.ArrayList;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetProductDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetCustomerEntityDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetProductEntityDetails;
import databaseoperations.interfaces.gettable.CustomerDetailsGettable;
import databaseoperations.interfaces.gettable.ProductDetailsGettable;
import entities.Customers;
import entities.Products;

public class DisplayOrderSummary {

	/**
	 * 
	 * @param productId
	 */
	public void displayOrderSummary(int productId)
	{
		//objects
		CustomerDetailsGettable getCustomerDetails = new GetCustomerDetails();
		int customerId = getCustomerDetails.getCurrentlyLoggedInCustomerId();
		
		//get customer details
		
		GetCustomerEntityDetails getCustomer = new GetCustomerEntityDetails();
		ArrayList<Customers> customerList = getCustomer.getCustomerList(customerId);
		
		for(Customers customer : customerList)
		{
		System.out.println(ShoppingAppConstants.stars+"\n");
		System.out.println(ShoppingAppConstants.smallHyphen+"ORDER SUMMARY"+ShoppingAppConstants.smallHyphen);
		System.out.println(customer.customerName);
		System.out.println(customer.customerAddress);
		System.out.println(customer.customerPhoneNumber);
		System.out.println(ShoppingAppConstants.underscoreLine);
		}
		GetProductEntityDetails getProduct = new GetProductEntityDetails();
		ArrayList<Products> productList = getProduct.getProductList(productId);
		
		for(Products product : productList)
		{
			System.out.print(product.productName);
			System.out.println("\t\t\t"+product.productCategory);
			System.out.println(ShoppingAppConstants.underscoreLine);
			System.out.println("Price Details:\n");
			System.out.println("Delivery Charges:\t\tFree");
			System.out.println("Total Amount:\t\t\t"+product.getProductPrice());

		}
			System.out.println("\n"+ShoppingAppConstants.stars);
	}

}
