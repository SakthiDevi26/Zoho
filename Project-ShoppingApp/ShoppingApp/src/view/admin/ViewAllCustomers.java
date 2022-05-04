package view.admin;

import java.util.ArrayList;
import java.util.ListIterator;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.classes.databasegetoperations.getlistfromdatabase.GetCustomerIdList;


public class ViewAllCustomers {

	public void viewAllCustomers()
	{
		GetCustomerDetails getCustomerDetails = new GetCustomerDetails();
		GetCustomerIdList getCustomerIdList = new GetCustomerIdList();
		
		
		ArrayList<Integer> customerIdList = new ArrayList<Integer>();
		customerIdList = getCustomerIdList.getAllCustomerId();
		if(!customerIdList.isEmpty())
		{
			System.out.println(ShoppingAppConstants.bigEqualLine+"\n");
			System.out.println("\t\t\t\t\tOUR CUSTOMERS");
			System.out.println("\t\t\tDon't Find Customers for products,find products for Customers\n");
			System.out.println(ShoppingAppConstants.bigEqualLine+"\n");
			System.out.printf("%s %20s %35s %40s\n","Customer Id",
					"Customer Name","Customer Address","Customer PhoneNumber");
			System.out.println(ShoppingAppConstants.bigUnderscoreLine);
	
			ListIterator<Integer> customerIdListIterator = customerIdList.listIterator();
			while(customerIdListIterator.hasNext())
			{
				String customerName = getCustomerDetails.getCustomerName(customerIdListIterator.next());
				customerIdListIterator.previous();
				String customerAddress = getCustomerDetails.getCustomerAddress(customerIdListIterator.next());
				customerIdListIterator.previous();
				Long customerPhoneNumber = getCustomerDetails.getCustomerPhoneNumber(customerIdListIterator.next());
				customerIdListIterator.previous();
				System.out.printf("%s %20s %40s %40d\n", customerIdListIterator.next(),customerName,customerAddress,customerPhoneNumber);
			}
			System.out.println("\n"+ShoppingAppConstants.bigEqualLine);
			
	
		}
	}
}
