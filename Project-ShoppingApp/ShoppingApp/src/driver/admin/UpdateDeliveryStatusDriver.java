package driver.admin;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import utilities.PrintMenu;
import view.admin.DisplayOrderDetails;
import databaseoperations.classes.admin.UpdateDeliveryStatus;
import databaseoperations.classes.databasecheckoperations.CheckOrderId;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetOrderDetails;
import databaseoperations.interfaces.admin.DeliveryStatusUpdatable;
import databaseoperations.interfaces.checkable.OrderIdCheckable;
import databaseoperations.interfaces.gettable.OrderDetailsGettable;

public class UpdateDeliveryStatusDriver {

	public void updateDeliveryStatusDriver(int orderId) {
		// TODO Auto-generated method stub
		OrderIdCheckable checkOrderId = new CheckOrderId();
		DeliveryStatusUpdatable updateDeliveryStatus = new UpdateDeliveryStatus();
		OrderDetailsGettable getOrderDetails = new GetOrderDetails();
		
		PrintMenu printMenu = new PrintMenu();
		Scanner scanner = new Scanner(System.in);
		printMenu.printUpdateDeliveryStatusMenu();
		String orderStatus = getOrderDetails.getDeliveryStatus(orderId);
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			if(!checkOrderId.isOrderInParticularStatus(orderId, ShoppingAppConstants.processed))
			{
				if(updateDeliveryStatus.updateDeliveryStatus(orderId, ShoppingAppConstants.processed))
				{
					System.out.println(ShoppingAppConstants.successfulStatusUpdate);
				}
			}
			else
			{
				System.out.println(ShoppingAppConstants.orderIsAlready+ShoppingAppConstants.processed);
			}
			break;
		case 2:
			if(!(checkOrderId.isOrderInParticularStatus(orderId, ShoppingAppConstants.shipped)))
			{
				if(updateDeliveryStatus.updateDeliveryStatus(orderId, ShoppingAppConstants.shipped))
				{
					System.out.println(ShoppingAppConstants.successfulStatusUpdate);
				}
			}
			else
			{
				System.out.println(ShoppingAppConstants.orderIsAlready+ShoppingAppConstants.shipped);
			}
			break;
		case 3:
			if(!checkOrderId.isOrderInParticularStatus(orderId, ShoppingAppConstants.delivered))
			{
				if(updateDeliveryStatus.updateDeliveryStatus(orderId, ShoppingAppConstants.delivered))
				{
					System.out.println(ShoppingAppConstants.successfulStatusUpdate);
				}
			}
			else
			{
				System.out.println(ShoppingAppConstants.orderIsAlready+ShoppingAppConstants.delivered);
			}
			break;
		case 4:
			if(!checkOrderId.isOrderInParticularStatus(orderId, ShoppingAppConstants.cancelled))
			{
				if(updateDeliveryStatus.updateDeliveryStatus(orderId, ShoppingAppConstants.cancelled))
				{
					System.out.println(ShoppingAppConstants.successfulStatusUpdate);
				}
			}
			else
			{
				System.out.println(ShoppingAppConstants.orderIsAlready+ShoppingAppConstants.cancelled);
			}
			break;
		}
		DisplayOrderDetails displayOrderDetails = new DisplayOrderDetails();
		displayOrderDetails.displayOrderDetails(orderId);
	}

}
