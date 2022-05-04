package driver.orders;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetOrderDetails;
import databaseoperations.interfaces.gettable.OrderDetailsGettable;
import utilities.PrintMenu;
import view.orders.ShowOrderInfo;
import view.orders.ShowSupplierInfo;

public class ShowDeliveredOrderDetailsDriver {

	public void showDeliveredOrderDetailsDriver(int orderId) {
		
		Scanner scanner = new Scanner(System.in);
		OrderDetailsGettable getOrderDetails = new GetOrderDetails();
		PrintMenu printMenu = new PrintMenu();
		
		String deliveryStatus = getOrderDetails.getDeliveryStatus(orderId);
		System.out.println(ShoppingAppConstants.stars);
		System.out.println("\n"+deliveryStatus);
		printMenu.printDeliveredOrderDetailsMenu();
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			ShowSupplierInfo showSupplier = new ShowSupplierInfo();
			showSupplier.showSupplierInfo(orderId);
			break;
		case 2:
			//feedback
			break;
		case 3:
			ShowOrderInfo showOrderInfo = new ShowOrderInfo();
			showOrderInfo.showOrderInfo(orderId);
			break;
		default:
			System.out.println(ShoppingAppConstants.invalidChoice);
			break;
		}
		
		
	}

}

