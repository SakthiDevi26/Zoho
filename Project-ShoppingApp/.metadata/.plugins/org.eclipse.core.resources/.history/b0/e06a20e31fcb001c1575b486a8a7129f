package customers.methods.productoptions;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;
import databaseoperations.databasegetoperations.GetDetailsFromDatabase;

public class AddToWishList {
	String sql="",sql1="";
	Connection connect = DatabaseConnection.getConnection();
	int customerId;
	public boolean addToWishList(int productId) {
		// TODO Auto-generated method stub
		GetDetailsFromDatabase getDetailsFromDatabase = new GetDetailsFromDatabase();
		customerId = getDetailsFromDatabase.getCurrentlyLoggedInCustomerId();
		sql = "insert into "+ShoppingAppConstants.wishlistTable+" values ("+customerId+","+productId+")";
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
