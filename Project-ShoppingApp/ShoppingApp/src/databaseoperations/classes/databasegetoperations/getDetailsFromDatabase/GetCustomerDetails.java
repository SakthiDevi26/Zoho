package databaseoperations.classes.databasegetoperations.getDetailsFromDatabase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.gettable.CustomerDetailsGettable;
import sql.DatabaseConnection;

public class GetCustomerDetails implements CustomerDetailsGettable {
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public int supplierId,currentCustomerId,productPrice,orderId,productId,customerId;
	public long customerPhoneNumber,supplierPhoneNumber;
	public String productName,productCategory,customerAddress,customerName,deliveryStatus,deliveryDateString,supplierName,productDescription;
	Date deliveryDate;
	
	
	public int getCurrentlyLoggedInCustomerId() {
		
		sql ="Select * from "+ShoppingAppConstants.customerLoginTable;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next()) {
				currentCustomerId = resultset.getInt(ShoppingAppConstants.customerIdColumn);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentCustomerId;		
	}
	
	/**
	 * @param customerId
	 */
	public String getCustomerAddress(int customerId) {
		
		sql ="Select * from "+ShoppingAppConstants.customersTable+" where "+ShoppingAppConstants.customerIdColumn+" = '"
				+customerId+"'";
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next()) 			{
				
				customerAddress = resultset.getString(ShoppingAppConstants.customerAddressColumn);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerAddress;
	}
	
	/**
	 * @param customerId
	 */
	public String getCustomerName(int customerId)
	{
		sql ="Select * from "+ShoppingAppConstants.customersTable+" where "+ShoppingAppConstants.customerIdColumn+" = '"
				+customerId+"'";
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next()) {
				
				customerName = resultset.getString(ShoppingAppConstants.customerUserNameColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerName;
	}
	
	/**
	 * @param customerId
	 */
	public long getCustomerPhoneNumber(int customerId)
	{
		sql ="Select * from "+ShoppingAppConstants.customersTable+" where "+ShoppingAppConstants.customerIdColumn+" = '"
				+customerId+"'";
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next()) {
				
				customerPhoneNumber = resultset.getLong(ShoppingAppConstants.customerPhoneNumberColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerPhoneNumber;
	}

	/**
	 * @param orderId
	 */
	public int getCustomerId(int orderId)
	{
		sql ="Select * from "+ShoppingAppConstants.ordersTable+" where "+ShoppingAppConstants.orderIdColumn+" = "
				+orderId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next()) {
				
				customerId = resultset.getInt(ShoppingAppConstants.customerIdColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerId;
	}
}
