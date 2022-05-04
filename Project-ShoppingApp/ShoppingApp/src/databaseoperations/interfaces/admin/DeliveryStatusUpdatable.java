package databaseoperations.interfaces.admin;

public interface DeliveryStatusUpdatable {

	public boolean updateDeliveryStatus(int orderId,String orderStatus);
}
