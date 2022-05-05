package driver.admin;


import appconstants.ShoppingAppConstants;
import utilities.GetDetails;
import view.admin.DisplayOrderDetails;
import view.admin.ViewAllOrders;
import databaseoperations.classes.admin.EnterOrderDetails;
import databaseoperations.classes.databasecheckoperations.CheckOrderId;
import databaseoperations.interfaces.admin.OrderDetailsEnterable;
import databaseoperations.interfaces.checkable.OrderIdCheckable;

public class ManageOrders {

	public void manageOrders() {
		// TODO Auto-generated method stub
		OrderIdCheckable checkOrderId = new CheckOrderId();
		GetDetails getDetails = new GetDetails();
		DisplayOrderDetails displayOrderDetails = new DisplayOrderDetails();
		ViewAllOrders viewOrders = new ViewAllOrders();
		viewOrders.viewAllOrders();
		getDetails.getOrderId();
		if(getDetails.orderId!=0 && checkOrderId.isOrderIdInOrdersTable(getDetails.orderId))
		{
			if(checkOrderId.isOrderIdInShipmentTable(getDetails.orderId))
			{
				displayOrderDetails.displayOrderDetails(getDetails.orderId);
			}
			else
			{
				OrderDetailsEnterable enterOrderDetails = new EnterOrderDetails();
				if(enterOrderDetails.enterOrderDetails(getDetails.orderId))
				{
					displayOrderDetails.displayOrderDetails(getDetails.orderId);
				}
			}
		}
		else if(getDetails.orderId==0)
		{
			AdminMethodsDriver adminMethodsDrive = new AdminMethodsDriver();
			adminMethodsDrive.adminMethodsDriver();
		}
		else
		{
			System.out.println(ShoppingAppConstants.invalidChoice);
			manageOrders();
		}
	}

}
