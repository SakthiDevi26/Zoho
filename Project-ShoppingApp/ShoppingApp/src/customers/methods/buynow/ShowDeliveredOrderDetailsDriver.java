package customers.methods.buynow;

import appconstants.ShoppingAppConstants;
import databaseoperations.databasegetoperations.GetDetailsFromDatabase;
import utilities.PrintMenu;

public class ShowDeliveredOrderDetailsDriver {

	public void showDeliveredOrderDetailsDriver(int orderId) {
		
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		PrintMenu printMenu = new PrintMenu();
		
		String deliveryStatus = getDetailsFromDb.getDeliveryStatus(orderId);
		System.out.println(ShoppingAppConstants.stars);
		System.out.println("\n"+deliveryStatus);
		printMenu.printDeliveredOrderDetailsMenu();
		System.out.println("\n"+ShoppingAppConstants.stars);
		System.out.println(ShoppingAppConstants.enterChoice);
		
	}

}




