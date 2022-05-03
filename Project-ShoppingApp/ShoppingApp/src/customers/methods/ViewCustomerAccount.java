package customers.methods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import customers.registeration.classes.CustomerMainDriver;
import sql.DatabaseConnection;
import databaseoperations.databasegetoperations.GetDetailsFromDatabase;

public class ViewCustomerAccount {
	String sql="",sql1="";
	Connection connect = DatabaseConnection.getConnection();
	public int customerId;
	public long customerPhoneNumber;
	public String customerName,customerAddress;
	
	public void viewCustomerAccount()
	{
		Scanner scanner = new Scanner(System.in);
		CustomerMainDriver customerMainDrive = new CustomerMainDriver();
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		customerId = getDetailsFromDb.getCurrentlyLoggedInCustomerId();
		sql = "Select * from "+ShoppingAppConstants.customersTable+" where "+ShoppingAppConstants.customerIdColumn+ " = "
				+customerId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next())
			{
				customerName = resultset.getString(ShoppingAppConstants.customerUserNameColumn);
				customerPhoneNumber = resultset.getLong(ShoppingAppConstants.customerPhoneNumberColumn);
				customerAddress = resultset.getString(ShoppingAppConstants.customerAddressColumn);
			}
			System.out.println(ShoppingAppConstants.equalLine+"\n\n");
			System.out.println("\t\t"+ShoppingAppConstants.smallHyphen+"MY PROFILE"+ShoppingAppConstants.smallHyphen);
			System.out.printf("\n%s %25s\n","\t\tName","\t\tPhone Number");
			System.out.print("\t\t"+customerName);
			System.out.println("\t\t\t"+customerPhoneNumber);
			System.out.println("\t\t"+ShoppingAppConstants.underscoreLine);
			System.out.println("\t\tDeliver My orders to");
			System.out.println("\t\t"+customerAddress);
			System.out.println("\n"+ShoppingAppConstants.equalLine);
			System.out.println("Press 0 to go to main");
			int userInput = scanner.nextInt();
			if(userInput==0)
			{
			customerMainDrive.customerMainDriver();
			}
			else
			{
				System.out.println("Sorry.Invalid Input. Terminating...");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
