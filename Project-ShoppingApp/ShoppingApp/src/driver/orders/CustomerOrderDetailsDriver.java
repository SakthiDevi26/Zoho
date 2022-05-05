package driver.orders;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasecheckoperations.CheckOrderId;
import databaseoperations.interfaces.checkable.OrderIdCheckable;
import view.customers.ViewMyOrders;
import view.orders.ShowUndeliveredOrderDetails;

public class CustomerOrderDetailsDriver {

	/**
	 * 
	 * @param orderId
	 */
	public void customerOrderDetailsDriver(int orderId)
	{
		OrderIdCheckable checkOrderId = new CheckOrderId();
		
		if(checkOrderId.isOrderInParticularStatus(orderId, ShoppingAppConstants.delivered)) {
			ShowDeliveredOrderDetailsDriver showDeliveredOrderDetailsDrive = new ShowDeliveredOrderDetailsDriver();
			showDeliveredOrderDetailsDrive.showDeliveredOrderDetailsDriver(orderId);
		}
		else {
			if(checkOrderId.isOrderIdInShipmentTable(orderId)) {
				ShowUndeliveredOrderDetails showUndeliveredOrderDetails = new ShowUndeliveredOrderDetails();
				showUndeliveredOrderDetails.showUndeliveredOrderDetails(orderId);
			}
			else {
				System.out.println("Please wait.Your order is processing");
				ViewMyOrders viewOrders = new ViewMyOrders();
				viewOrders.viewMyOrders();
			}
		}
	}

}
