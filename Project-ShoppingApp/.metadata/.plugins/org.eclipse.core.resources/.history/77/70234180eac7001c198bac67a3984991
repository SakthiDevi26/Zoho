package main;
import utilities.classes.*;

import java.util.*;
import appconstants.ShoppingAppConstants;
import customers.registeration.classes.*;
import suppliers.suppliersregistration.classes.SupplierRegisterationDriver;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		SupplierRegisterationDriver supplierRegisterDriver = new SupplierRegisterationDriver();
		CustomerRegisterationDriver customerRegisterDriver = new CustomerRegisterationDriver();
		
		printMenu.printMainMenu();
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			customerRegisterDriver.customerRegisterationDriver();
			break;
		case 2:
			supplierRegisterDriver.supplierRegisterationDriver();
			break;
		case 3:
			//shipping clerk
			break;
		default:
			System.out.println(ShoppingAppConstants.invalidChoice);
			Main.main(args);
		}
	}

}
