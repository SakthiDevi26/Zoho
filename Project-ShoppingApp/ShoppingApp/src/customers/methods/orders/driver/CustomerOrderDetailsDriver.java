package customers.methods.orders.driver;

import appconstants.ShoppingAppConstants;
import customers.methods.orders.view.ShowUndeliveredOrderDetails;
import databaseoperations.classes.databasecheckoperations.CheckOrderId;

public class CustomerOrderDetailsDriver {

	public void customerOrderDetailsDriver(int orderId)
	{
		CheckOrderId checkOrderId = new CheckOrderId();
		if(checkOrderId.isOrderInParticularStatus(orderId, ShoppingAppConstants.delivered))
		{
			ShowDeliveredOrderDetailsDriver showDeliveredOrderDetailsDrive = new ShowDeliveredOrderDetailsDriver();
			showDeliveredOrderDetailsDrive.showDeliveredOrderDetailsDriver(orderId);
		}
		else
		{
			if(checkOrderId.isOrderIdInShipmentTable(orderId))
			{
				ShowUndeliveredOrderDetails showUndeliveredOrderDetails = new ShowUndeliveredOrderDetails();
				showUndeliveredOrderDetails.showUndeliveredOrderDetails(orderId);
			}
			else
			{
				System.out.println("Please wait.Your order is processing");
			}
		}
	}

}
