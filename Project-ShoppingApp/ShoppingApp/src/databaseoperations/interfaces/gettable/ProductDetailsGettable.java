package databaseoperations.interfaces.gettable;

public interface ProductDetailsGettable {

	public String getProductName(int productId);
	public String getProductCategory(int productId);
	public String getProductDescription(int productId);
	public int getProductPrice(int productId);
	public int getProductIdUsingOrderId(int orderId);
	public int getProductId(int customerId, int orderId);
	public int getProductId(int customerId);
}