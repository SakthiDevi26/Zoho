package customers.registeration.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import appconstants.ShoppingAppConstants;
import passwordencryption.VerifyEncryptedPassword;
import sql.DatabaseConnection;
import suppliers.suppliersmethods.classes.SupplierMethodsDriver;
import utilities.GetDetails;

public class CustomerLogin {
	public boolean customerLogin()
	{
		String sql="";
		Connection connect = DatabaseConnection.getConnection();
		GetDetails getDetails = new GetDetails();
		if(getDetails.getCustomerLoginDetails())
		{
			if (getDetails.customerPhoneNumber == 0 || getDetails.customerPassword == "") {
				System.out.println(ShoppingAppConstants.incompleteFields);
				return false;
			}
			else
			{
				CustomerLoginVerification verifyLogin = new CustomerLoginVerification();
				if(verifyLogin.verifyCustomerLogin(getDetails.customerPhoneNumber,getDetails.customerPassword))
				{
					return true;
				}
				else
				{
					System.out.println(ShoppingAppConstants.invalidLoginCredentials);
					return false;
				}
			}
		}
		return false;
	}
}
