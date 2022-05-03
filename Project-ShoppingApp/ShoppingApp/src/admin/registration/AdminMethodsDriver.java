package admin.registration;

import java.util.Scanner;

import admin.methods.adminview.ViewAllCustomers;
import admin.methods.adminview.ViewAllProducts;
import admin.methods.driver.ManageOrders;
import utilities.PrintMenu;

public class AdminMethodsDriver {

	public void adminMethodsDriver() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		printMenu.printAdminMethodsMenu();
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			ViewAllProducts view = new ViewAllProducts();
			view.ViewAllProducts();
			break;
		case 2:
			ViewAllCustomers viewAllCustomers = new ViewAllCustomers();
			viewAllCustomers.viewAllCustomers();
			break;
		case 3:
			ManageOrders manageOrders = new ManageOrders();
			manageOrders.manageOrders();
			break;
		}
		adminMethodsDriver();
	}

}
