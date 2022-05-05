package databaseoperations.classes.databasecheckoperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.interfaces.checkable.SupplierIdCheckable;
import databaseoperations.interfaces.gettable.CustomerDetailsGettable;
import sql.DatabaseConnection;

public class CheckSupplierId implements SupplierIdCheckable{
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	
	/**
	 * @param supplierId
	 */
	public boolean isSupplierIdInSupplierTable(int supplierId) {
		
		sql = "select * from "+ShoppingAppConstants.suppliersTable+" where "+ShoppingAppConstants.supplierIdColumn+"="
				+ supplierId;
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next()) {	
				
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
