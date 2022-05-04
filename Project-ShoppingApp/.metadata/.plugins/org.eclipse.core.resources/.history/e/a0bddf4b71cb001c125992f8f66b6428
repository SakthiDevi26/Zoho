package customers.registeration.classes.driver;

import appconstants.ShoppingAppConstants;
import customers.registeration.classes.database.CustomerLoginVerification;
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
