package driver.orders;

import java.util.Scanner;

import databaseoperations.classes.customers.InsertFeedback;
import view.customers.ViewMyOrders;

public class GiveFeedback {

	/**
	 * 
	 * @param orderId
	 */
	public void giveFeedback(int orderId) {

		System.out.println("Waiting for your feedback: ");
		Scanner scanner = new Scanner(System.in);
		String feedback = scanner.nextLine();
		
		try {
			String analyzedFeedback = FeedbackAnalyzerAPI.feedbackAnalyzer(feedback);
			InsertFeedback insertFeedback = new InsertFeedback();
			
			if(insertFeedback.insertFeedback(orderId,feedback,analyzedFeedback)) {
				System.out.println("Thank you for your feedback");
				ViewMyOrders viewOrders = new ViewMyOrders();
				viewOrders.viewMyOrders();
			}
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot");
		}
		
	}

}
