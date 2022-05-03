package databaseoperations.databasegetoperations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;

public class GetDetailsFromDatabase {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public int supplierId,currentCustomerId,productPrice,orderId,productId,customerId;
	public long customerPhoneNumber,supplierPhoneNumber;
	public String productName,productCategory,customerAddress,customerName,deliveryStatus,deliveryDateString,supplierName;
	Date deliveryDate;
	
	public int getSupplierId(String supplierUserName)
	{

		sql ="Select * from "+ShoppingAppConstants.suppliersTable+" where "+ShoppingAppConstants.supplierUserNameColumn +" = '"
	+supplierUserName+"'";
			try {
				Statement statement = connect.createStatement();
				ResultSet resultset = statement.executeQuery(sql);
				if(resultset.next())
				{
					supplierId = resultset.getInt(ShoppingAppConstants.supplierIdColumn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return supplierId;
		
	}
	public String getSupplierName(int supplierId)
	{

		sql ="Select * from "+ShoppingAppConstants.suppliersTable+" where "+ShoppingAppConstants.supplierIdColumn +" = "
	+supplierId;
			try {
				Statement statement = connect.createStatement();
				ResultSet resultset = statement.executeQuery(sql);
				if(resultset.next())
				{
					supplierName = resultset.getString(ShoppingAppConstants.supplierUserNameColumn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return supplierName;
		
	}
	public long getSupplierPhoneNumber(int supplierId)
	{
		sql ="Select * from "+ShoppingAppConstants.suppliersTable+" where "+ShoppingAppConstants.supplierIdColumn+" = "
				+supplierId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next())
			{
				supplierPhoneNumber = resultset.getLong(ShoppingAppConstants.supplierPhoneNumberColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return supplierPhoneNumber;
	}
	public int getSupplierId(int productId)
	{

		sql ="Select * from "+ShoppingAppConstants.productsTable+" where "+ShoppingAppConstants.productIdColumn +" = "
	+productId;
			try {
				Statement statement = connect.createStatement();
				ResultSet resultset = statement.executeQuery(sql);
				if(resultset.next())
				{
					supplierId = resultset.getInt(ShoppingAppConstants.supplierIdColumn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return supplierId;
		
	}
	public int getCurrentlyLoggedInCustomerId()
	{
		sql ="Select * from "+ShoppingAppConstants.customerLoginTable;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next())
			{
				currentCustomerId = resultset.getInt(ShoppingAppConstants.customerIdColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentCustomerId;
		
	}
	
	public String getProductName(int productId)
	{
		sql ="Select * from "+ShoppingAppConstants.productsTable+" where "+ShoppingAppConstants.productIdColumn +" = "
				+productId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next())
			{
				productName = resultset.getString(ShoppingAppConstants.productNameColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return productName;

	}
	public String getProductCategory(int productId)
	{
		sql ="Select * from "+ShoppingAppConstants.productsTable+" where "+ShoppingAppConstants.productIdColumn +" = "
				+productId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next())
			{
				productCategory = resultset.getString(ShoppingAppConstants.productCategoryColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return productCategory;

	}
	public int getProductPrice(int productId)
	{

		sql ="Select * from "+ShoppingAppConstants.productsTable+" where "+ShoppingAppConstants.productIdColumn +" = "
	+productId;
			try {
				Statement statement = connect.createStatement();
				ResultSet resultset = statement.executeQuery(sql);
				if(resultset.next())
				{
					productPrice = resultset.getInt(ShoppingAppConstants.productPriceColumn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return productPrice;
		
	}
	public String getCustomerAddress(int customerId)
	{
		sql ="Select * from "+ShoppingAppConstants.customersTable+" where "+ShoppingAppConstants.customerIdColumn+" = '"
				+customerId+"'";
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next())
			{
				customerAddress = resultset.getString(ShoppingAppConstants.customerAddressColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return customerAddress;
	}
	public String getCustomerName(int customerId)
	{
		sql ="Select * from "+ShoppingAppConstants.customersTable+" where "+ShoppingAppConstants.customerIdColumn+" = '"
				+customerId+"'";
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next())
			{
				customerName = resultset.getString(ShoppingAppConstants.customerUserNameColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return customerName;
	}
	public long getCustomerPhoneNumber(int customerId)
	{
		sql ="Select * from "+ShoppingAppConstants.customersTable+" where "+ShoppingAppConstants.customerIdColumn+" = '"
				+customerId+"'";
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next())
			{
				customerPhoneNumber = resultset.getLong(ShoppingAppConstants.customerPhoneNumberColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return customerPhoneNumber;
	}
	
	public int getProductId(int customerId)
	{
		sql ="Select * from "+ShoppingAppConstants.ordersTable+" where "+ShoppingAppConstants.customerIdColumn+" = "
				+customerId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next())
			{
				productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return productId;
	}
	public int getCustomerId(int orderId)
	{
		sql ="Select * from "+ShoppingAppConstants.ordersTable+" where "+ShoppingAppConstants.orderIdColumn+" = "
				+orderId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next())
			{
				customerId = resultset.getInt(ShoppingAppConstants.customerIdColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return customerId;
	}
	public int getOrderId(int productId) {
		sql ="Select * from "+ShoppingAppConstants.ordersTable+" where "+ShoppingAppConstants.productIdColumn+" = "
				+productId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next())
			{
				orderId = resultset.getInt(ShoppingAppConstants.orderIdColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return orderId;
	}
	public int getProductIdUsingOrderId(int orderId)
	{
		sql ="Select * from "+ShoppingAppConstants.ordersTable+" where "+ShoppingAppConstants.orderIdColumn+" = "
				+orderId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next())
			{
				productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productId;
	}
	public String getDeliveryStatus(int orderId)
	{
		sql ="Select * from "+ShoppingAppConstants.shipmentTable+" where "+ShoppingAppConstants.orderIdColumn+" = "
				+orderId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next())
			{
				deliveryStatus = resultset.getString(ShoppingAppConstants.deliveryStatusColumn);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deliveryStatus;
	}
	public String getDeliveryDate(int orderId)
	{
		sql ="Select * from "+ShoppingAppConstants.shipmentTable+" where "+ShoppingAppConstants.orderIdColumn+" = "
				+orderId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next())
			{
				deliveryDate = resultset.getDate(ShoppingAppConstants.deliveryDateColumn);
				deliveryDateString = deliveryDate.toString();
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deliveryDateString;
	}
	public int getProductId(int customerId, int orderId) {
		sql ="Select * from "+ShoppingAppConstants.ordersTable+" where "+ShoppingAppConstants.customerIdColumn+" = "
				+customerId+" and "+ShoppingAppConstants.orderIdColumn+" = "+orderId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next())
			{
				productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return productId;

	}
}
