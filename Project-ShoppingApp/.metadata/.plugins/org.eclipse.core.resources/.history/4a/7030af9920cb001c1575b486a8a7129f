package suppliers.suppliersregistration.classes;


import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;
import utilities.GetDetails;

public class CreateSupplierAccount {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();

	public boolean createSupplierAccount() throws NoSuchAlgorithmException, NoSuchProviderException
	{
		GetDetails getDetails = new GetDetails();
		if(getDetails.getSupplierCreateAccountDetails())
		{
		try {
			Statement statement = connect.createStatement();
			sql ="Insert into "+ShoppingAppConstants.suppliersTable+
					"("+ShoppingAppConstants.supplierUserNameColumn+","+ShoppingAppConstants.supplierPasswordColumn+","+ShoppingAppConstants.supplierPhoneNumberColumn+")"
					+ " values('"+ getDetails.supplierUserName+"','" +getDetails.supplierHashedPassword+ "'," + getDetails.supplierPhoneNumber +")";
			if (statement.executeUpdate(sql)==1)
			{
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
