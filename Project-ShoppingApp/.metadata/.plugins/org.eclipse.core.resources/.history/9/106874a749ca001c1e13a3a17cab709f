package customers.methods.buynow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;
import utilities.classes.GetDetails;
import utilities.classes.databaseoperations.databasegetoperations.GetDetailsFromDatabase;


public class UpdateCustomerAddress {
	String sql="",sql1="";
	Connection connect = DatabaseConnection.getConnection();
	public boolean updateCustomerAddress()
	{
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		GetDetails getDetails = new GetDetails();
		getDetails.getCustomerNewAddress();
		int customerId = getDetailsFromDb.getCurrentlyLoggedInCustomerId();
		try {
			sql = "select * from "+ShoppingAppConstants.customersTable+" where "+ShoppingAppConstants.customerIdColumn+"="
				+ customerId;
			PreparedStatement preparedstatement
				= connect.prepareStatement(sql);
			preparedstatement.executeQuery();
	
	
			Statement statement = connect.createStatement();
			sql = "update "+ShoppingAppConstants.customersTable+" set "+ShoppingAppConstants.customerAddressColumn+"='"
			+getDetails.customerAddress+"'";
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
