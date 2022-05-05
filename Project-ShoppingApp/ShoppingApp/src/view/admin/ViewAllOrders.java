package view.admin;

import java.util.ArrayList;
import java.util.ListIterator;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetProductDetails;
import databaseoperations.classes.databasegetoperations.getlistfromdatabase.GetOrderIdList;
import databaseoperations.interfaces.gettable.OrderIdListGettable;
import databaseoperations.interfaces.gettable.ProductDetailsGettable;

public class ViewAllOrders {
	
	public void viewAllOrders() {		
		
		ProductDetailsGettable getProductDetails = new GetProductDetails();
		OrderIdListGettable getOrderIdList = new GetOrderIdList();
		
		
		ArrayList<Integer> orderIdList = new ArrayList<Integer>();
		orderIdList = getOrderIdList.getAllOrderIdList();
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
				int productId = getProductDetails.getProductIdUsingOrderId(orderIdListIterator.next());
				orderIdListIterator.previous();
				String productName = getProductDetails.getProductName(productId);
				System.out.printf("%30s %20s\n", orderIdListIterator.next(),productName);
			}
			System.out.println("\n"+ShoppingAppConstants.equalLine);	
		}
	}
}
