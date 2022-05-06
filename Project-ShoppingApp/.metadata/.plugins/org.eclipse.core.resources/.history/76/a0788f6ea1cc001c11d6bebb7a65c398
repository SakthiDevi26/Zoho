package databaseoperations.classes.databasegetoperations.getEntities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import appconstants.ShoppingAppConstants;
import entities.Customers;
import sql.DatabaseConnection;

public class GetCustomerEntityDetails {

	String sql;
	Connection connect = DatabaseConnection.getConnection();
	public ArrayList<Customers> getCustomerList()
	{
		 ArrayList<Customers>customerList = new ArrayList<Customers>();
		 sql ="Select * from "+ShoppingAppConstants.customersTable ;
			try {
				Statement statement = connect.createStatement();
				ResultSet resultset = statement.executeQuery(sql);
				
				while(resultset.next()) {
					
					int customerId = resultset.getInt(ShoppingAppConstants.customerIdColumn);
					String customerName = resultset.getString(ShoppingAppConstants.customerUserNameColumn);
					String customerPassword = resultset.getString(ShoppingAppConstants.customerPasswordColumn);
					String customerAddress = resultset.getString(ShoppingAppConstants.customerAddressColumn);
					long customerPhoneNumber = resultset.getLong(ShoppingAppConstants.customerPhoneNumberColumn);
					Customers customer = new Customers(customerId, customerName, customerPassword, customerAddress, customerPhoneNumber);
					customerList.add(customer);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return customerList;
			
	}
	public ArrayList<Customers> getCustomerList(int id)
	{
		 ArrayList<Customers>customerList = new ArrayList<Customers>();
		 sql ="Select * from "+ShoppingAppConstants.customersTable +" where "+ ShoppingAppConstants.customerIdColumn +" = "+id;
			try {
				Statement statement = connect.createStatement();
				ResultSet resultset = statement.executeQuery(sql);
				
				while(resultset.next()) {
					
					int customerId = resultset.getInt(ShoppingAppConstants.customerIdColumn);
					String customerName = resultset.getString(ShoppingAppConstants.customerUserNameColumn);
					String customerPassword = resultset.getString(ShoppingAppConstants.customerPasswordColumn);
					String customerAddress = resultset.getString(ShoppingAppConstants.customerAddressColumn);
					long customerPhoneNumber = resultset.getLong(ShoppingAppConstants.customerPhoneNumberColumn);
					Customers customer = new Customers(customerId, customerName, customerPassword, customerAddress, customerPhoneNumber);
					customerList.add(customer);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return customerList;
			
	}
}
