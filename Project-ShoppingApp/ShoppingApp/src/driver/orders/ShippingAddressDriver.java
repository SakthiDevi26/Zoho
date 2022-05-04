package driver.orders;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.classes.orders.UpdateCustomerAddress;
import databaseoperations.interfaces.gettable.CustomerDetailsGettable;
import databaseoperations.interfaces.orders.CustomerAddressUpdatable;
import utilities.*;

public class ShippingAddressDriver {

	public void shippingAddressDriver(int productId)
	{
		Scanner scanner = new Scanner(System.in);
		CustomerDetailsGettable getCustomerDetails = new GetCustomerDetails();
		OrderConfirmation orderConfirm = new OrderConfirmation();
		PrintMenu printMenu = new PrintMenu();
		
		int customerId = getCustomerDetails.getCurrentlyLoggedInCustomerId();
		String customerAddress = getCustomerDetails.getCustomerAddress(customerId);
		System.out.printf("%12s\n","Your Address is");
		System.out.printf("%12s\n\n", customerAddress);
		printMenu.printAddressOption();
		
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println(ShoppingAppConstants.addressNoted);
			break;
		case 2:
			CustomerAddressUpdatable updateCustomerAddress = new UpdateCustomerAddress();
			if(updateCustomerAddress.updateCustomerAddress())
			{
				System.out.println(ShoppingAppConstants.addressNoted);
			}
			break;
		default:
			System.out.println(ShoppingAppConstants.invalidChoice);
			shippingAddressDriver(productId);
		}
		orderConfirm.orderConfirmation(productId);
		
	}
}
