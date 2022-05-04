package databaseoperations.classes.customers;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.customers.CustomerAccountCreatable;
import sql.DatabaseConnection;
import utilities.GetDetails;

public class CreateCustomerAccount implements CustomerAccountCreatable{
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public int customerId;
	public boolean createCustomerAccount() throws NoSuchAlgorithmException, NoSuchProviderException
	{
		GetDetails getDetails = new GetDetails();
		if(getDetails.getCustomerCreateAccountDetails())
		{
			try {
				Statement statement = connect.createStatement();
				sql ="Insert into "+ShoppingAppConstants.customersTable+
						"("+ShoppingAppConstants.customerUserNameColumn+","+ShoppingAppConstants.customerPasswordColumn+","+ShoppingAppConstants.customerPhoneNumberColumn+","+ShoppingAppConstants.customerAddressColumn+")"
						+ " values('"+ getDetails.customerUserName+"','" +getDetails.customerHashedPassword+ "'," + getDetails.customerPhoneNumber +",'"+getDetails.customerAddress+"')";
				if (statement.executeUpdate(sql)==1)
				return true;
				}
			catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("Phone number exists already");
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
		
	}
}
