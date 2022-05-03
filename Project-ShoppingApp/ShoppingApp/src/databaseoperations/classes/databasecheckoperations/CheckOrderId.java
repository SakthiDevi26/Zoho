package databaseoperations.classes.databasecheckoperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;

public class CheckOrderId {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public boolean isOrderIdInOrdersTable(int orderId)
	{
		sql = "select * from "+ShoppingAppConstants.ordersTable+" where "+ShoppingAppConstants.orderIdColumn+"="
				+ orderId;
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next())
			{	
				return true;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean isOrderIdInShipmentTable(int orderId)
	{
		sql = "select * from "+ShoppingAppConstants.shipmentTable+" where "+ShoppingAppConstants.orderIdColumn+"="
				+ orderId;
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next())
			{	
				return true;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	 
	public boolean isOrderInParticularStatus(int orderId,String orderStatus)
	{
		sql = "select * from "+ShoppingAppConstants.shipmentTable+" where "+ShoppingAppConstants.deliveryStatusColumn+"='"+orderStatus+"' and "+
	ShoppingAppConstants.orderIdColumn+"="+orderId;
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next())
			{	
				return true;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean isOrderInSameDate(int orderId,String deliveryDate)
	{
		sql = "select * from "+ShoppingAppConstants.shipmentTable+" where "+ShoppingAppConstants.deliveryDateColumn+"='"+deliveryDate+"' and "+
	ShoppingAppConstants.orderIdColumn+"="+orderId;
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next())
			{	
				return true;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
