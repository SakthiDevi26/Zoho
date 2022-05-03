package admin.methods.admindatabaseupdate;

import java.sql.Connection;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;
import utilities.GetDetails;

public class UpdateDeliveryDate {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	
	public boolean updateDeliveryDate(int orderId)
	{
		GetDetails getDetails = new GetDetails();
		getDetails.getDeliveryDateToUpdate();
		try {

		Statement statement = connect.createStatement();
		sql = "update "+ShoppingAppConstants.shipmentTable+" set "+ShoppingAppConstants.deliveryDateColumn+"='"+getDetails.deliveryDate+ 
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
