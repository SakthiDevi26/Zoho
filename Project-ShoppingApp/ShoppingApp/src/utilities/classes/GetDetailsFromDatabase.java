package utilities.classes;

import java.sql.Connection;
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
	public int supplierId,currentCustomerId,productPrice;
	public String productName,customerAddress;
	
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
	public int getProductPrice(int productId)
	{

		sql ="Select * from "+ShoppingAppConstants.productsTable+" where "+ShoppingAppConstants.productIdColumn +" = "
	+productId;
			try {
				Statement statement = connect.createStatement();
				ResultSet resultset = statement.executeQuery(sql);
				if(resultset.next())
				{
					productPrice = resultset.getInt(ShoppingAppConstants.productIdColumn);
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
}
