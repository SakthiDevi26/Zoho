package customers.methods.buynow;

import appconstants.ShoppingAppConstants;
import databaseoperations.databasecheckoperations.CheckOrderId;

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
			//undelivered
		}
	}

}
