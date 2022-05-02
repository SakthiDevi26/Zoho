package admin.methods.adminview;

import java.util.ArrayList;
import java.util.ListIterator;

import admin.methods.manage.EnterOrderDetails;
import admin.registration.AdminMethodsDriver;
import appconstants.ShoppingAppConstants;
import customers.registeration.classes.CustomerMainDriver;
import utilities.classes.GetDetails;
import utilities.classes.databaseoperations.databasecheckoperations.CheckOrderId;
import utilities.classes.databaseoperations.databasegetoperations.GetDetailsFromDatabase;
import utilities.classes.databaseoperations.databasegetoperations.GetListDetailsFromDatabase;

public class ViewAllOrders {
	public void viewAllOrders()
	{
		
		
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		GetListDetailsFromDatabase getListDetailsFromDb = new GetListDetailsFromDatabase();
		
		
		ArrayList<Integer> orderIdList = new ArrayList<Integer>();
		orderIdList = getListDetailsFromDb.getAllOrderIdList();
		if(!orderIdList.isEmpty())
		{
			System.out.println(ShoppingAppConstants.equalLine+"\n");
			System.out.println("\t\t\t\tORDERS RECEIVED");
			System.out.println(ShoppingAppConstants.equalLine+"\n");
			System.out.printf("%30s %20s\n","Order Id",
					"Product Name");
			System.out.println("\t\t"+ShoppingAppConstants.underscoreLine);
	
			ListIterator<Integer> orderIdListIterator = orderIdList.listIterator();
			while(orderIdListIterator.hasNext())
			{
				int productId = getDetailsFromDb.getProductIdUsingOrderId(orderIdListIterator.next());
				orderIdListIterator.previous();
				String productName = getDetailsFromDb.getProductName(productId);
				System.out.printf("%30s %20s\n", orderIdListIterator.next(),productName);
			}
			System.out.println("\n"+ShoppingAppConstants.equalLine);
			
	
		}
	}
}
