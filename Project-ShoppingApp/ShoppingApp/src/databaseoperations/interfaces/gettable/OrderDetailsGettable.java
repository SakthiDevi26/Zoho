package databaseoperations.interfaces.gettable;

public interface OrderDetailsGettable {
	public int getOrderId(int productId);
	public String getDeliveryStatus(int orderId);
	public String getDeliveryDate(int orderId);
}
