package driver.customers;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.customers.removemethods.RemoveProductFromCart;
import driver.orders.ShippingAddressDriver;
import utilities.PrintMenu;
import view.customers.ViewMyCart;

public class MyCartDriver {

	public void myCartDriver(int productId)
	{
		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		printMenu.printCartDriverMenu();
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			RemoveProductFromCart removeProduct = new RemoveProductFromCart();
			removeProduct.removeProductFromCart(productId);
			System.out.println(ShoppingAppConstants.productRemoved);
			break;
		case 2:
			ShippingAddressDriver shipAddressDrive = new ShippingAddressDriver();
			shipAddressDrive.shippingAddressDriver(productId);
			break;
		default:
			System.out.println(ShoppingAppConstants.invalidChoice);
		}
		ViewMyCart viewCart = new ViewMyCart();
		viewCart.viewMyCart();
	}
}
