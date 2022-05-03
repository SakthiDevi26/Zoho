package customers.methods.orders.driver;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import customers.methods.orders.view.ShowOrderInfo;
import customers.methods.orders.view.ShowSupplierInfo;
import databaseoperations.classes.databasegetoperations.GetDetailsFromDatabase;
import utilities.PrintMenu;

public class ShowDeliveredOrderDetailsDriver {

	public void showDeliveredOrderDetailsDriver(int orderId) {
		
		Scanner scanner = new Scanner(System.in);
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		PrintMenu printMenu = new PrintMenu();
		
		String deliveryStatus = getDetailsFromDb.getDeliveryStatus(orderId);
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

