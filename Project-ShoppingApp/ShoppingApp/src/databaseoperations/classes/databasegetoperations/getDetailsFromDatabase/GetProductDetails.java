package databaseoperations.classes.databasegetoperations.getDetailsFromDatabase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.gettable.ProductDetailsGettable;
import sql.DatabaseConnection;

public class GetProductDetails implements ProductDetailsGettable {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public int supplierId,currentCustomerId,productPrice,orderId,productId,customerId;
	public long customerPhoneNumber,supplierPhoneNumber;
	public String productName,productCategory,customerAddress,customerName,deliveryStatus,deliveryDateString,supplierName,productDescription;
	Date deliveryDate;
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
	public String getProductDescription(int productId)
	{
		sql ="Select * from "+ShoppingAppConstants.productsTable+" where "+ShoppingAppConstants.productIdColumn +" = "
				+productId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next())
			{
				productDescription = resultset.getString(ShoppingAppConstants.productDescriptionColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return productDescription;

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
}