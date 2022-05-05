package databaseoperations.classes.customers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.customers.CustomerLogoutInterface;
import sql.DatabaseConnection;

public class CustomerLogout implements CustomerLogoutInterface{
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public void customerLogout()
	{
		try {
			Statement statement = connect.createStatement();
			sql ="Delete from "+ShoppingAppConstants.customerLoginTable;
			statement.executeUpdate(sql);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
}
