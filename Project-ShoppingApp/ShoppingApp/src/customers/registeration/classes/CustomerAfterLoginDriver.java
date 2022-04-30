package customers.registeration.classes;

import java.util.Scanner;

import customers.methods.SearchByCategoryDriver;
import main.Main;
import utilities.classes.PrintMenu;

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
			//My Account
			break;
		case 3:
			//My orders
			break;
		case 4:
			//My cart
			break;
		case 5:
			//My wishlist
			break;
		case 6:
			//feedback
			break;
		case 7:
			CustomerLogout customerLogout = new CustomerLogout();
			customerLogout.customerLogout();
			Main.main(null);
			break;
		}
	}
}