package suppliers.suppliersregistration.classes;


import appconstants.ShoppingAppConstants;
import suppliers.suppliersmethods.classes.SupplierMethodsDriver;
import utilities.GetDetails;

public class SupplierLogin {
	public boolean supplierLogin()
	{
		GetDetails getDetails = new GetDetails();
		SupplierMethodsDriver supplierMethodsDrive = new SupplierMethodsDriver();
		getDetails.getSupplierLoginDetails();
		if (getDetails.supplierUserName == "" || getDetails.supplierPassword == "") {
			System.out.println(ShoppingAppConstants.incompleteFields);
			return false;
		}
		else
		{
			SupplierLoginVerification verifyLogin = new SupplierLoginVerification();
			if(verifyLogin.verifyLogin(getDetails.supplierUserName, getDetails.supplierPassword))
			{
				System.out.println(ShoppingAppConstants.successfulLogin);
				supplierMethodsDrive.supplierMethodsDriver(getDetails.supplierUserName);
			}
			else
			{
				return false;
			}
		}
		return false;
		
		
	}
}
