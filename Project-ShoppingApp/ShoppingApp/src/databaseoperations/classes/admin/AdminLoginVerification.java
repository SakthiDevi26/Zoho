package databaseoperations.classes.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databaseAbstract.LoginVerification;
import passwordencryption.VerifyEncryptedPassword;

public class AdminLoginVerification extends LoginVerification  {

	@Override
	public boolean verifyLogin(String userName, String password) {
		// TODO Auto-generated method stub
		sql = "select * from "+ShoppingAppConstants.adminTable+" where "+ShoppingAppConstants.adminUserNameColumn+"='"
				+ userName + "'";
			try {
				PreparedStatement statement = connect.prepareStatement(sql);
				ResultSet resultset = statement.executeQuery();
				if(resultset.next())
				{
				String adminOriginalPassword = resultset.getString(ShoppingAppConstants.adminPasswordColumn); 
				Boolean verifyPassword = VerifyEncryptedPassword.isPasswordSame(password,adminOriginalPassword);  
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
