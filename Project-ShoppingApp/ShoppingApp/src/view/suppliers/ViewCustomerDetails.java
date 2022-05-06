package view.suppliers;

import java.util.ArrayList;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetIdUsingId;
import databaseoperations.classes.databasegetoperations.getEntities.GetCustomerEntityDetails;
import databaseoperations.interfaces.gettable.CustomerDetailsGettable;
import databaseoperations.interfaces.gettable.IdGettable;
import entities.Customers;

public class ViewCustomerDetails {

	/**
	 * 
	 * @param orderId
	 */
	public void viewCustomerDetails(int orderId)
	{
		
		IdGettable getId = new GetIdUsingId();
		GetCustomerEntityDetails getCustomer = new GetCustomerEntityDetails();
		Customers customer = new Customers();
		ArrayList<Customers> customerList = new ArrayList<Customers>();
		
		
		int customerId = getId.getId(orderId,ShoppingAppConstants.customerIdColumn,ShoppingAppConstants.ordersTable,ShoppingAppConstants.orderIdColumn);
		customerList = getCustomer.getCustomerList(customer.customerId);
		for(Customers customer1 : customerList)
		{
			System.out.println(ShoppingAppConstants.bigEqualLine);
			System.out.println("\n"+ShoppingAppConstants.customerBox);
			System.out.printf("\n%43s","Customer Id : ");
			System.out.printf("%d",customer.customerId);
			System.out.printf("\n%43s","Name : ");
			System.out.printf("%s",customer1.customerName);
		}
				
		
		System.out.printf("\n\nOther Details Of Customers are Confidential. Kindly approach Our team if there is a neccesity\n\n");		
		System.out.println(ShoppingAppConstants.bigEqualLine);		
	}
}
