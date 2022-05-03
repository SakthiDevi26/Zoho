package admin.methods.manage;

import java.util.Scanner;

import admin.methods.admindatabaseupdate.UpdateDeliveryStatus;
import admin.methods.adminview.DisplayOrderDetails;
import appconstants.ShoppingAppConstants;
import utilities.PrintMenu;
import databaseoperations.databasecheckoperations.CheckOrderId;
import databaseoperations.databasegetoperations.GetDetailsFromDatabase;

public class UpdateDeliveryStatusDriver {

	public void updateDeliveryStatusDriver(int orderId) {
		// TODO Auto-generated method stub
		CheckOrderId checkOrderId = new CheckOrderId();
		UpdateDeliveryStatus updateDeliveryStatus = new UpdateDeliveryStatus();
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		PrintMenu printMenu = new PrintMenu();
		Scanner scanner = new Scanner(System.in);
		printMenu.printUpdateDeliveryStatusMenu();
		String orderStatus = getDetailsFromDb.getDeliveryStatus(orderId);
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
