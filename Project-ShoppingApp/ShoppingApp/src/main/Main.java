package main;
import utilities.classes.*;

import java.util.*;

import admin.registration.AdminLogin;
import appconstants.ShoppingAppConstants;
import customers.registeration.classes.*;
import passwordencryption.EncryptPassword;
import suppliers.suppliersregistration.classes.SupplierRegisterationDriver;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		SupplierRegisterationDriver supplierRegisterDriver = new SupplierRegisterationDriver();
		CustomerMainDriver customerMainDriver = new CustomerMainDriver();
		AdminLogin adminLogin = new AdminLogin();
		printMenu.printMainMenu();
		int choice = scanner.nextInt();
		switch(choice)
		{
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
