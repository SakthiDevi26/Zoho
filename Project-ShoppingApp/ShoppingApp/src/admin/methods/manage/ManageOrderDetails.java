package admin.methods.manage;

import java.util.Scanner;

import admin.methods.admindatabaseupdate.UpdateDeliveryDate;
import admin.registration.AdminMethodsDriver;
import appconstants.ShoppingAppConstants;
import utilities.PrintMenu;
import databaseoperations.databasecheckoperations.CheckOrderId;

public class ManageOrderDetails {

	public void manageOrderDetails(int orderId) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		CheckOrderId checkOrderId = new CheckOrderId();
		if(!checkOrderId.isOrderInParticularStatus(orderId,ShoppingAppConstants.delivered))
		{
			printMenu.printAdminOrdersManagementMenu();
			int choice = scanner.nextInt();
			switch(choice)
			{
			case 1:
				UpdateDeliveryDate updateDeliveryDate = new UpdateDeliveryDate();
				if(updateDeliveryDate.updateDeliveryDate(orderId))
				{
					System.out.println(ShoppingAppConstants.successfulDateUpdate);
				}
				else
				{
					System.out.println(ShoppingAppConstants.failedDeliveryUpdate);
				}
				break;
			case 2:
				UpdateDeliveryStatusDriver deliveryStatusDrive = new UpdateDeliveryStatusDriver();
				deliveryStatusDrive.updateDeliveryStatusDriver(orderId);
				break;
			case 3:
				AdminMethodsDriver adminMethodsDrive = new AdminMethodsDriver();
				adminMethodsDrive.adminMethodsDriver();
				break;
			}
			
		}
	}

}
