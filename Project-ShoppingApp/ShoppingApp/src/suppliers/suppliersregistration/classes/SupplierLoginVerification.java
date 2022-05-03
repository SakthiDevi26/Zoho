package suppliers.suppliersregistration.classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import appconstants.ShoppingAppConstants;
import databaseAbstract.LoginVerification;
import passwordencryption.VerifyEncryptedPassword;

public class SupplierLoginVerification extends LoginVerification{

	@Override
	public boolean verifyLogin(String userName, String password) {
		// TODO Auto-generated method stub
		sql = "select * from "+ShoppingAppConstants.suppliersTable+" where "+ShoppingAppConstants.supplierUserNameColumn+"='"
				+ userName + "'";
			try {
				PreparedStatement statement = connect.prepareStatement(sql);
				ResultSet resultset = statement.executeQuery();
				if(resultset.next())
				{
				String supplierOriginalPassword = resultset.getString(ShoppingAppConstants.supplierPasswordColumn); 
				Boolean verifyPassword = VerifyEncryptedPassword.isPasswordSame(password,supplierOriginalPassword);  
				if(verifyPassword==true)
				{
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
