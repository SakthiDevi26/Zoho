package databaseoperations.interfaces.gettable;

import java.util.ArrayList;

public interface CustomerIdListGettable {

	public ArrayList<Integer> getAllCustomerId();
	public ArrayList<Integer> getReviewedCustomerIdList(int productId);
}
