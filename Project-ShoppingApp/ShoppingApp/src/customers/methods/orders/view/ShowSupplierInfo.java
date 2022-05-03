package customers.methods.orders.view;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import customers.methods.orders.driver.ShowDeliveredOrderDetailsDriver;
import databaseoperations.classes.databasegetoperations.GetDetailsFromDatabase;

public class ShowSupplierInfo {

	public void showSupplierInfo(int orderId)
	{
		Scanner scanner = new Scanner(System.in);
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		int productId = getDetailsFromDb.getProductIdUsingOrderId(orderId);
		int supplierId = getDetailsFromDb.getSupplierId(productId);
		String supplierName = getDetailsFromDb.getSupplierName(supplierId);
		long supplierPhoneNumber = getDetailsFromDb.getSupplierPhoneNumber(supplierId);
		
		System.out.println(ShoppingAppConstants.supplierBox);
		System.out.println("\n\t\t\t\t"+supplierName);
		System.out.println("\n\t\t\t\t"+supplierPhoneNumber);
		System.out.println("\n"+ShoppingAppConstants.equalLine);
		System.out.println(ShoppingAppConstants.goBack);
		
		int userInput = scanner.nextInt();
		if(userInput==0)
		{
			ShowDeliveredOrderDetailsDriver showDeliveredOrderDrive = new ShowDeliveredOrderDetailsDriver();
			showDeliveredOrderDrive.showDeliveredOrderDetailsDriver(orderId);
		}
		else
		{
			System.out.println(ShoppingAppConstants.invalidChoice);
		}
	}
}
