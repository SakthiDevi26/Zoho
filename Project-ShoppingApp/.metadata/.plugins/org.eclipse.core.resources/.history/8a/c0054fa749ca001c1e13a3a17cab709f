package admin.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import appconstants.ShoppingAppConstants;
import passwordencryption.VerifyEncryptedPassword;
import sql.DatabaseConnection;
import suppliers.suppliersmethods.classes.SupplierMethodsDriver;
import utilities.classes.GetDetails;

public class AdminLogin {
	public void adminLogin()
	{
		String sql="";
		Connection connect = DatabaseConnection.getConnection();
		GetDetails getDetails = new GetDetails();
		AdminMethodsDriver adminMethodsDrive = new AdminMethodsDriver();
		getDetails.getAdminLoginDetails();
		if (getDetails.getAdminUserName() == "" || getDetails.getAdminPassword() == "") {
			System.out.println(ShoppingAppConstants.incompleteFields);
		}
		sql = "select * from "+ShoppingAppConstants.adminTable+" where "+ShoppingAppConstants.adminUserNameColumn+"='"
				+ getDetails.getAdminUserName() + "'";
			try {
				PreparedStatement statement = connect.prepareStatement(sql);
				ResultSet resultset = statement.executeQuery();
				if(resultset.next())
				{
				String adminOriginalPassword = resultset.getString(ShoppingAppConstants.adminPasswordColumn); 
				Boolean verifyPassword = VerifyEncryptedPassword.isPasswordSame(getDetails.getAdminPassword(),adminOriginalPassword);  
				if(verifyPassword==true)
				{
					System.out.println(ShoppingAppConstants.successfulLogin);
					adminMethodsDrive.adminMethodsDriver();
				}
				}
				else
				{
					System.out.println(ShoppingAppConstants.invalidLoginCredentials);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			adminLogin();
	}
}
