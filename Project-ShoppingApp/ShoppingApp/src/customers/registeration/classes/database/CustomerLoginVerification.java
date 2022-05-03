package customers.registeration.classes.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import appconstants.ShoppingAppConstants;
import passwordencryption.VerifyEncryptedPassword;
import sql.DatabaseConnection;

public class CustomerLoginVerification {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public boolean verifyCustomerLogin(long customerPhoneNumber, String customerPassword) {
		// TODO Auto-generated method stub
		sql = "select * from "+ShoppingAppConstants.customersTable+" where "+ShoppingAppConstants.customerPhoneNumberColumn+"="
				+ customerPhoneNumber;
			try {
				PreparedStatement statement = connect.prepareStatement(sql);
				ResultSet resultset = statement.executeQuery();
				if(resultset.next())
				{
					int customerId = resultset.getInt(ShoppingAppConstants.customerIdColumn);
					String customerOriginalPassword = resultset.getString(ShoppingAppConstants.customerPasswordColumn); 
					Boolean verifyPassword = VerifyEncryptedPassword.isPasswordSame(customerPassword,customerOriginalPassword);  
					if(verifyPassword==true)
					{
						sql ="insert into "+ShoppingAppConstants.customerLoginTable+" values ("+customerId +")";
						statement.executeUpdate(sql);
						return true;
					}
				}
				else
				{
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return false;
	}

}
