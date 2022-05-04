package databaseoperations.classes.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import sql.DatabaseConnection;
import utilities.GetDetails;


public class UpdateCustomerAddress {
	String sql="",sql1="";
	Connection connect = DatabaseConnection.getConnection();
	public boolean updateCustomerAddress()
	{
		GetCustomerDetails getCustomerDetails = new GetCustomerDetails();
		GetDetails getDetails = new GetDetails();
		getDetails.getCustomerNewAddress();
		int customerId = getCustomerDetails.getCurrentlyLoggedInCustomerId();
		try {
			sql = "select * from "+ShoppingAppConstants.customersTable+" where "+ShoppingAppConstants.customerIdColumn+"="
				+ customerId;
			PreparedStatement preparedstatement
				= connect.prepareStatement(sql);
			preparedstatement.executeQuery();
	
	
			Statement statement = connect.createStatement();
			sql = "update "+ShoppingAppConstants.customersTable+" set "+ShoppingAppConstants.customerAddressColumn+"='"
			+getDetails.customerAddress+"' where "+ShoppingAppConstants.customerIdColumn+"="+customerId;
			if (statement.executeUpdate(sql) == 1) {
				return true;
			}
	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
