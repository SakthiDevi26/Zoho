package utilities.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;

public class GetDetailsFromDatabase {
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public int supplierId;
	
	public int getSupplierId(String supplierUserName)
	{

		sql ="Select * from "+ShoppingAppConstants.suppliersTable+" where "+ShoppingAppConstants.supplierUserNameColumn +" = '"
	+supplierUserName+"'";
			PreparedStatement statement;
			try {
				statement = connect.prepareStatement(sql);
				ResultSet resultset = statement.executeQuery();
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