package driver.admin;

import java.util.Scanner;

import utilities.PrintMenu;
import view.admin.ViewAllCustomers;
import view.admin.ViewAllSuppliers;

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
			ViewAllSuppliers view = new ViewAllSuppliers();
			view.ViewAllSuppliers();
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
