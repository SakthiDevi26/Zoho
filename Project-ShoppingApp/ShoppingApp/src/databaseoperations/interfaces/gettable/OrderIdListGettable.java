package databaseoperations.interfaces.gettable;

import java.util.ArrayList;

public interface OrderIdListGettable {

	public ArrayList<Integer> getOrderIdList(int customerId);
	public ArrayList<Integer> getAllOrderIdList();
}
