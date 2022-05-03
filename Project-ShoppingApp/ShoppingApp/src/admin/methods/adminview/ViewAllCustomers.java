package admin.methods.adminview;

import java.util.ArrayList;
import java.util.ListIterator;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.GetDetailsFromDatabase;
import databaseoperations.classes.databasegetoperations.GetListDetailsFromDatabase;


public class ViewAllCustomers {

	public void viewAllCustomers()
	{
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		GetListDetailsFromDatabase getListDetailsFromDb = new GetListDetailsFromDatabase();
		
		
		ArrayList<Integer> customerIdList = new ArrayList<Integer>();
		customerIdList = getListDetailsFromDb.getAllCustomerId();
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
				String customerName = getDetailsFromDb.getCustomerName(customerIdListIterator.next());
				customerIdListIterator.previous();
				String customerAddress = getDetailsFromDb.getCustomerAddress(customerIdListIterator.next());
				customerIdListIterator.previous();
				Long customerPhoneNumber = getDetailsFromDb.getCustomerPhoneNumber(customerIdListIterator.next());
				customerIdListIterator.previous();
				System.out.printf("%s %20s %40s %40d\n", customerIdListIterator.next(),customerName,customerAddress,customerPhoneNumber);
			}
			System.out.println("\n"+ShoppingAppConstants.bigEqualLine);
			
	
		}
	}
}
