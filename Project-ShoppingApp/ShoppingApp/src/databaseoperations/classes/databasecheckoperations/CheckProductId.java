package databaseoperations.classes.databasecheckoperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;
import databaseoperations.classes.databasegetoperations.GetDetailsFromDatabase;

public class CheckProductId {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public boolean isProductIdInProductTable(int productId)
	{
		sql = "select * from "+ShoppingAppConstants.productsTable+" where "+ShoppingAppConstants.productIdColumn+"="
				+ productId;
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
	public boolean isProductIdInCart(int productId)
	{
		GetDetailsFromDatabase getDetailsFromDatabase = new GetDetailsFromDatabase();
		int customerId = getDetailsFromDatabase.getCurrentlyLoggedInCustomerId();
		sql = "select * from "+ShoppingAppConstants.cartTable+" where "+ShoppingAppConstants.productIdColumn+"="
				+ productId +" and "+ShoppingAppConstants.customerIdColumn+"="+ customerId;
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
	public boolean isProductIdInWishList(int productId)
	{
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		int customerId = getDetailsFromDb.getCurrentlyLoggedInCustomerId();
		sql = "select * from "+ShoppingAppConstants.wishlistTable+" where "+ShoppingAppConstants.productIdColumn+"="
				+ productId + " and "+ShoppingAppConstants.customerIdColumn+ " = "+customerId;
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
