package customers.registeration.classes.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;

public class CheckCustomerLoggedIn {
	public boolean isCustomerLoggedin()
	{
		String sql="";
		Connection connect = DatabaseConnection.getConnection();

		sql = "select * from "+ShoppingAppConstants.customerLoginTable;

			try {
				PreparedStatement statement = connect.prepareStatement(sql);
				ResultSet resultset = statement.executeQuery();
				if(resultset.next())
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
