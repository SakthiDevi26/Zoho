package driver.orders;

import java.util.Scanner;

import databaseoperations.classes.orders.OrderPlacement;
import driver.customers.CustomerMainDriver;
import utilities.PrintMenu;

public class PaymentModeDriver {

	public void paymentModeDriver(int productId) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		OrderPlacement orderPlacement = new OrderPlacement();
		CustomerMainDriver customerMainDrive = new CustomerMainDriver();
		PrintMenu printMenu = new PrintMenu();
		printMenu.printPaymentMode();
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Thank you for shopping with us! UPI payment app will be opened and prompt for payment...");
	
			if(orderPlacement.orderPlacement(productId))
			{
				System.out.println("Hurrayy!! Your Order is placed!");
			}
			break;
		case 2:
			System.out.println("Thank you for shopping with us! Cash will be collected at the time of delivery.");
			if(orderPlacement.orderPlacement(productId))
			{
				System.out.println("Hurrayy!! Your Order is placed!");
			}
			break;
		}
		customerMainDrive.customerMainDriver();
		
	}

}
