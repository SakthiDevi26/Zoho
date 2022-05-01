package customers.registeration.classes;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;
import utilities.classes.GetDetails;

public class CreateCustomerAccount {
	String sql="",sql1="";
	Connection connect = DatabaseConnection.getConnection();

	public boolean createCustomerAccount() throws NoSuchAlgorithmException, NoSuchProviderException
	{
		GetDetails getDetails = new GetDetails();
		if(getDetails.getCustomerCreateAccountDetails())
		{
		try {
			Statement statement = connect.createStatement();
			sql ="Insert into "+ShoppingAppConstants.customersTable+
					"("+ShoppingAppConstants.customerUserNameColumn+","+ShoppingAppConstants.customerPasswordColumn+","+ShoppingAppConstants.customerPhoneNumberColumn+")"
					+ " values('"+ getDetails.customerUserName+"','" +getDetails.customerHashedPassword+ "'," + getDetails.customerPhoneNumber +")";
			sql1 ="Insert into "+ShoppingAppConstants.customerAddressTable+
					"("+ShoppingAppConstants.doorNumberColumn+","+ShoppingAppConstants.streetNameColumn+","+ShoppingAppConstants.cityColumn+","+ShoppingAppConstants.stateColumn+","+ShoppingAppConstants.pincodeColumn+")"+
					 " values('"+ getDetails.doorNumber+"','" +getDetails.streetName+ "','" + getDetails.city +"','"+getDetails.state+"',"+getDetails.pincode+")";
			if (statement.executeUpdate(sql)==1)
			{
				if (statement.executeUpdate(sql1)==1)
				return true;
			}
		}catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Username already exists. Please try unique username.");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return false;
		
	}
}
