package driver.admin;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.admin.AdminLoginVerification;
import utilities.GetDetails;

public class AdminLogin {
	public void adminLogin()
	{
		GetDetails getDetails = new GetDetails();
		AdminMethodsDriver adminMethodsDrive = new AdminMethodsDriver();
		getDetails.getAdminLoginDetails();
		if (getDetails.getAdminUserName() == "" || getDetails.getAdminPassword() == "") {
			System.out.println(ShoppingAppConstants.incompleteFields);
			adminLogin();
		}
		else
		{
			AdminLoginVerification verifyLogin = new AdminLoginVerification();
			if(verifyLogin.verifyLogin(getDetails.getAdminUserName(),getDetails.getAdminPassword()))
			{
				System.out.println(ShoppingAppConstants.successfulLogin);
				adminMethodsDrive.adminMethodsDriver();				
			}
			else
			{
				System.out.println(ShoppingAppConstants.invalidLoginCredentials);
				adminLogin();
			}
		}
			
	}
}
