package databaseoperations.classes.admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.admin.OrderDetailsEnterable;
import sql.DatabaseConnection;
import utilities.GetDetails;

public class EnterOrderDetails implements OrderDetailsEnterable {
	
	/**
	 * @param orderId
	 */
	public boolean enterOrderDetails(int orderId) {
		
		String sql="";
		Connection connect = DatabaseConnection.getConnection();
		GetDetails getDetails = new GetDetails();
		
		getDetails.getOrderDetails();
		try {
			Statement statement = connect.createStatement();
			try {
				sql ="Insert into "+ShoppingAppConstants.shipmentTable+
						"("+ShoppingAppConstants.orderIdColumn+","+ShoppingAppConstants.deliveryStatusColumn+","+ShoppingAppConstants.deliveryDateColumn+")"
						+ " values("+orderId +",'"+ getDetails.deliveryStatus +"','" + getDetails.deliveryDate+"')";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (statement.executeUpdate(sql)==1)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
}
