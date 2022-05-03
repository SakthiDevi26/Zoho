package customers.methods.customerview;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.ListIterator;

import appconstants.ShoppingAppConstants;
import customers.methods.buynow.CustomerOrderDetailsDriver;
import customers.registeration.classes.CustomerMainDriver;
import sql.DatabaseConnection;
import utilities.GetDetails;
import databaseoperations.databasecheckoperations.CheckOrderId;
import databaseoperations.databasegetoperations.GetDetailsFromDatabase;
import databaseoperations.databasegetoperations.GetListDetailsFromDatabase;

public class ViewMyOrders {

	String sql="",sql1="";
	Connection connect = DatabaseConnection.getConnection();
	public void viewMyOrders()
	{
		GetDetails getDetails = new GetDetails();
		GetListDetailsFromDatabase getListDetailsFromDb = new GetListDetailsFromDatabase();
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		CheckOrderId checkOrderId = new CheckOrderId();
		
		int customerId = getDetailsFromDb.getCurrentlyLoggedInCustomerId();
		ArrayList<Integer> orderIdList = new ArrayList<Integer>();
		orderIdList = getListDetailsFromDb.getOrderIdList(customerId);
		if(!orderIdList.isEmpty())
		{
			System.out.println(ShoppingAppConstants.equalLine+"\n");
			System.out.println("\t\t\t\tMy ORDERS");
			System.out.println(ShoppingAppConstants.equalLine+"\n");
			System.out.printf("%30s %20s\n","Order Id",
					"Product Name");
			System.out.println("\t\t"+ShoppingAppConstants.underscoreLine);
	
			ListIterator<Integer> iterator = orderIdList.listIterator();
			while(iterator.hasNext())
			{
			int productId = getDetailsFromDb.getProductId(customerId,iterator.next());
			iterator.previous();
			String productName = getDetailsFromDb.getProductName(productId);
			System.out.printf("%30s %20s\n", iterator.next(),productName);
			}
			System.out.println("\n"+ShoppingAppConstants.equalLine);
			getDetails.getOrderId();
			if(getDetails.orderId!=0 && checkOrderId.isOrderIdInOrdersTable(getDetails.orderId))
			{
				CustomerOrderDetailsDriver orderDetailsDrive = new CustomerOrderDetailsDriver();
				orderDetailsDrive.customerOrderDetailsDriver(getDetails.orderId);
			}
			else if(getDetails.orderId==0)
			{
				CustomerMainDriver customerMainDrive = new CustomerMainDriver();
				customerMainDrive.customerMainDriver();
			}
			else
			{
				System.out.println(ShoppingAppConstants.invalidChoice);
				viewMyOrders();
			}
		
		}
	}
}
