package adminfunctions;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import bankconstants.BankConstants;
import sql.DBConnection;
import basics.GetDetails;
import basics.PrintMenu;

public class DeleteUsers{
	String sql="";
	Connection connect = DBConnection.getConnection();
	public boolean deleteUsers() {
		PrintMenu printmenu = new PrintMenu();
		printmenu.printAccountTypeMenu();
		GetDetails getDetails = new GetDetails();
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		if(choice == 1)
		{
				getDetails.getDeleteUserDetails();
				Statement statement;
				try {
					statement = connect.createStatement();
					sql = "delete from "+BankConstants.savingsCustomerTable+" where "+BankConstants.userNameColumn+"='"+getDetails.userName+"'";
					if (statement.executeUpdate(sql)==1)
					{
						return true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(BankConstants.unexistUser);
				return false;
		}
		else if(choice == 2)
		{
			getDetails.getDeleteUserDetails();
				Statement statement;
				try {
					statement = connect.createStatement();
					sql = "delete from "+BankConstants.checkingCustomerTable+" where "+BankConstants.userNameColumn+"='"+getDetails.userName+"'";
					if (statement.executeUpdate(sql)==1)
					{
						return true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return false;
		}
		else
		{
			System.out.println(BankConstants.invalidChoice);
			deleteUsers();
		}
		System.out.println(BankConstants.unexistUser);
		return false;
	}
}
