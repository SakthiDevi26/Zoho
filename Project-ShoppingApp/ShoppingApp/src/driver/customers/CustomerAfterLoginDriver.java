package driver.customers;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.customers.CustomerLogout;
import main.Main;
import utilities.PrintMenu;
import view.customers.ViewCustomerAccount;
import view.customers.ViewMyCart;
import view.customers.ViewMyOrders;
import view.customers.ViewMyWishList;

public class CustomerAfterLoginDriver {
	public void customerAfterLoginDriver()
	{
		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		printMenu.printAfterLoginCustomerMainMenu();
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			SearchByCategoryDriver categoryDriver = new SearchByCategoryDriver();
			categoryDriver.searchByCategoryDriver();
			break;
		case 2:
			ViewCustomerAccount viewCustomerAccount = new ViewCustomerAccount();
			viewCustomerAccount.viewCustomerAccount();
			break;
		case 3:
			ViewMyOrders viewOrders = new ViewMyOrders();
			viewOrders.viewMyOrders();
			break;
		case 4:
			ViewMyCart viewCart = new ViewMyCart();
			viewCart.viewMyCart();
			break;
		case 5:
				ViewMyWishList viewWishList = new ViewMyWishList();
				viewWishList.viewMyWishList();
			break;
		case 6:
			//feedback
			break;
		case 7:
			System.out.println(ShoppingAppConstants.manThankyouMessage);
			CustomerLogout customerLogout = new CustomerLogout();
			customerLogout.customerLogout();
			Main.main(null);
			break;
		}
	}
}
