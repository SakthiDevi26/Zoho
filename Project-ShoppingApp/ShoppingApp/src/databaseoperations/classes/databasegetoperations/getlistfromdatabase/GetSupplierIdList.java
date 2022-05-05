package databaseoperations.classes.databasegetoperations.getlistfromdatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.gettable.SupplierIdListGettable;
import sql.DatabaseConnection;

public class GetSupplierIdList implements SupplierIdListGettable{
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	int supplierId;
	
	
	@Override
	public ArrayList<Integer> getAllSuppliersId() {
		ArrayList<Integer> allSuppliersIdList = new ArrayList<Integer>();
		sql ="Select * from "+ShoppingAppConstants.suppliersTable;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			
			while(resultset.next()) {
				
				supplierId = resultset.getInt(ShoppingAppConstants.supplierIdColumn);
				allSuppliersIdList.add(supplierId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allSuppliersIdList;
	}

}
