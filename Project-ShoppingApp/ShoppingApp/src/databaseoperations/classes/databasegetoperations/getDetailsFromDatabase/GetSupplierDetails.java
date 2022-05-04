package databaseoperations.classes.databasegetoperations.getDetailsFromDatabase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.gettable.SupplierDetailsGettable;
import sql.DatabaseConnection;

public class GetSupplierDetails implements SupplierDetailsGettable{
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public int supplierId,currentCustomerId,productPrice,orderId,productId,customerId;
	public long customerPhoneNumber,supplierPhoneNumber;
	public String productName,productCategory,customerAddress,customerName,deliveryStatus,deliveryDateString,supplierName,productDescription;
	
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
}