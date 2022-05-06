package databaseoperations.interfaces.gettable;

import java.util.ArrayList;

public interface CustomerDetailsGettable {

	public int getCurrentlyLoggedInCustomerId();
	public long getCustomerPhoneNumber(int customerId);
	public String getCustomer(int customerId, String columnName);
	
}
