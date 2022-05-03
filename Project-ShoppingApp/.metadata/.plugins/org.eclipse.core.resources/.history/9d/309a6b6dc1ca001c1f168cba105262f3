package customers.methods.removemethods;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;
import utilities.classes.databaseoperations.databasegetoperations.GetDetailsFromDatabase;

public class RemoveProductFromCart {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	int customerId;
	public boolean removeProductFromCart(int productId) {
		// TODO Auto-generated method stub
		GetDetailsFromDatabase getDetailsFromDatabase = new GetDetailsFromDatabase();
		customerId = getDetailsFromDatabase.getCurrentlyLoggedInCustomerId();
		sql = "delete from "+ShoppingAppConstants.cartTable+" where "+ShoppingAppConstants.customerIdColumn+" = "+customerId +
				" and "+ShoppingAppConstants.productIdColumn+ " = "+productId;
		Statement statement;
		try {
			statement = connect.createStatement();
			if(statement.executeUpdate(sql)==1)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
	}
}
