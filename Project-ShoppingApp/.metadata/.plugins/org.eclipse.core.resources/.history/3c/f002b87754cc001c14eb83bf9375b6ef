package driver.customers;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.customers.CustomerLoginVerification;
import databaseoperations.interfaces.customers.CustomerLoginVerifiable;
import utilities.GetDetails;

public class CustomerLogin {
	public boolean customerLogin()
	{
		GetDetails getDetails = new GetDetails();
		if(getDetails.getCustomerLoginDetails())
		{
			if (getDetails.customerPhoneNumber == 0 || getDetails.customerPassword == "") {
				System.out.println(ShoppingAppConstants.incompleteFields);
				return false;
			}
			else
			{
				CustomerLoginVerifiable verifyLogin = new CustomerLoginVerification();
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
