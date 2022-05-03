package customers.methods.buynow;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;
import databaseoperations.databasegetoperations.GetDetailsFromDatabase;

public class OrderPlacement {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public boolean orderPlacement(int productId)
	{
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		int customerId = getDetailsFromDb.getCurrentlyLoggedInCustomerId();
		try {
			Statement statement = connect.createStatement();
			sql ="Insert into "+ShoppingAppConstants.ordersTable+
					"("+ShoppingAppConstants.customerIdColumn+","+ShoppingAppConstants.productIdColumn+")"
					+ " values("+ customerId +"," + productId+")";
			if (statement.executeUpdate(sql)==1)
			{
				return true;
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
