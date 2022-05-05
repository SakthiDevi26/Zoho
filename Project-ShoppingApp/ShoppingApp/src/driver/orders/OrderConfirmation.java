package driver.orders;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import driver.customers.CustomerMainDriver;
import view.orders.DisplayOrderSummary;

public class OrderConfirmation {

	/**
	 * 
	 * @param productId
	 */
	public void orderConfirmation(int productId) {
		
		Scanner scanner = new Scanner(System.in);
		DisplayOrderSummary displayOrder = new DisplayOrderSummary();
		displayOrder.displayOrderSummary(productId);
		
		System.out.println("Do you want to place order? Type: y/n");
		
		String userInput = scanner.nextLine();
		if(userInput.equals("y")) {
			PaymentModeDriver paymentModeDriver = new PaymentModeDriver();
			paymentModeDriver.paymentModeDriver(productId);
		}
		else if(userInput.equals("n")) {
			System.out.println("Alas!! you missed the product.But still there are plenty...");
			CustomerMainDriver customerMainDrive = new CustomerMainDriver();
			customerMainDrive.customerMainDriver();		
		}
		else {
			System.out.println(ShoppingAppConstants.invalidChoice);
			orderConfirmation(productId);
		}
	}
}
