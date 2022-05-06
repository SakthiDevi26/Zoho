package databaseoperations.classes.customers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetIdUsingId;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetProductDetails;
import databaseoperations.interfaces.gettable.CustomerDetailsGettable;
import databaseoperations.interfaces.gettable.IdGettable;
import databaseoperations.interfaces.gettable.ProductDetailsGettable;
import sql.DatabaseConnection;

public class InsertFeedback {
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	
	/**
	 * 
	 * @param orderId
	 * @param feedback
	 * @param analyzedFeedback
	 * @return
	 */
	public boolean insertFeedback(int orderId, String feedback, String analyzedFeedback) {
		
		IdGettable getId = new GetIdUsingId();
		
		
		int customerId = getId.getId(orderId,ShoppingAppConstants.customerIdColumn,ShoppingAppConstants.ordersTable,ShoppingAppConstants.orderIdColumn);
		int productId = getId.getId(orderId,ShoppingAppConstants.productIdColumn,ShoppingAppConstants.ordersTable,ShoppingAppConstants.orderIdColumn);
		
		sql = "insert into "+ShoppingAppConstants.feedbackTable+" values ("+customerId+","+productId+",'"+feedback+"','"+analyzedFeedback+"')";
		Statement statement;
		
		try {
			
			statement = connect.createStatement();
			if(statement.executeUpdate(sql)==1) {
				
				return true;
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;		
	}
}
