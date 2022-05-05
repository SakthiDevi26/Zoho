package main;
import java.io.IOException;
import java.util.*;

import appconstants.ShoppingAppConstants;
import driver.admin.AdminLogin;
import driver.customers.CustomerMainDriver;
import driver.orders.FeedbackAnalyzerAPI;
import driver.suppliers.SupplierRegisterationDriver;
import utilities.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		SupplierRegisterationDriver supplierRegisterDriver = new SupplierRegisterationDriver();
		CustomerMainDriver customerMainDriver = new CustomerMainDriver();
		AdminLogin adminLogin = new AdminLogin();
		
		printMenu.printMainMenu();
		
		int choice = scanner.nextInt();
		switch(choice) {
			case 1:
				customerMainDriver.customerMainDriver();
				break;
			case 2:
				supplierRegisterDriver.supplierRegisterationDriver();
				break;
			case 3:
				adminLogin.adminLogin();
				break;
			default:
				System.out.println(ShoppingAppConstants.invalidChoice);
				Main.main(args);
		}
	}

}
