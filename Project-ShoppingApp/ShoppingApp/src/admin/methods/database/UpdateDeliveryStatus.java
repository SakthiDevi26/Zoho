package admin.methods.database;

import java.sql.Connection;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;

public class UpdateDeliveryStatus {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public boolean updateDeliveryStatus(int orderId,String orderStatus)
	{
		try {

		Statement statement = connect.createStatement();
		sql = "update "+ShoppingAppConstants.shipmentTable+" set "+ShoppingAppConstants.deliveryStatusColumn+"='"+orderStatus+ 
				"' where " +ShoppingAppConstants.orderIdColumn+"=" + orderId;
		if (statement.executeUpdate(sql) == 1) {
			return true;
		}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
		
		
		return false;
		
	}
}
