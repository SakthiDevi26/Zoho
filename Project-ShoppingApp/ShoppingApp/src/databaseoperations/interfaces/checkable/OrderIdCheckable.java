package databaseoperations.interfaces.checkable;

public interface OrderIdCheckable {

	public boolean isOrderIdInOrdersTable(int orderId);
	public boolean isOrderIdInShipmentTable(int orderId);
	public boolean isOrderInParticularStatus(int orderId,String orderStatus);
	public boolean isOrderInSameDate(int orderId,String deliveryDate);
}
