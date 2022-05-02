package admin.registration;

import java.util.Scanner;

import admin.methods.manage.ManageOrders;
import utilities.classes.PrintMenu;

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
			//suppliers
			break;
		case 2:
			//customers
			break;
		case 3:
			ManageOrders manageOrders = new ManageOrders();
			manageOrders.manageOrders();
			break;
		}
		adminMethodsDriver();
	}

}