package customers.methods.database.removemethods;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.GetDetailsFromDatabase;
import sql.DatabaseConnection;

public class RemoveProductFromWishList {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	int customerId;
	public boolean removeProductFromWishList(int productId) {
		
		GetDetailsFromDatabase getDetailsFromDatabase = new GetDetailsFromDatabase();
		customerId = getDetailsFromDatabase.getCurrentlyLoggedInCustomerId();
		sql = "delete from "+ShoppingAppConstants.wishlistTable+" where "+ShoppingAppConstants.customerIdColumn+" = "+customerId +
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
