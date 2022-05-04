package databaseoperations.interfaces.gettable;

import java.util.ArrayList;

public interface ProductIdListGettable {

	public ArrayList<Integer> getSupplierProductIdList(int supplierId);
	public ArrayList<Integer> getOrdersProductIdList(int productId);
	public ArrayList<Integer> getProductIdListInCart(int customerId);
	public ArrayList<Integer> getProductIdListInWishList(int customerId);
	public ArrayList<Integer> getAllOrderedProductIdList();
}
