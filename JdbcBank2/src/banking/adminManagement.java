//class with methods for admin

package banking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class adminManagement {
	static String sql="";
	static Connection con = connection.getConnection();
	public static void viewUsers() throws SQLException
	{
	//view savings account customers
	Statement s = con.createStatement(); 
	ResultSet r = s.executeQuery("Select * from savings_customer");
	System.out.println("-----Savings Account-----");
	System.out.println("accountNumber  accountName  balance  passCode");
	while (r.next())
	{
		int accountNumber = r.getInt("ac_no");
		String accountName = r.getString("name");
		int balance = r.getInt("balance");
		int passCode = r.getInt("pass_code");
		System.out.println("      "+accountNumber+"           "+accountName+"         "+balance+"        "+passCode+"\n");
	}
	//view checkings account customer
	Statement s1 = con.createStatement(); 
	ResultSet r1 = s1.executeQuery("Select * from checkings_customer");
	System.out.println("-----Checkings Account-----");
	System.out.println("accountNumber  accountName  balance  passCode");
	while (r1.next())
	{
		int accountNumber = r1.getInt("ac_no");
		String accountName = r1.getString("name");
		int balance = r1.getInt("balance");
		int passCode = r1.getInt("pass_code");
		System.out.printf("      "+accountNumber+"           "+accountName+"         "+balance+"        "+passCode+"\n");
	}
	}
	public static boolean addUsers(String accountName, String accountType,int passCode) throws SQLException
	{
		if(accountType.equals("savings"))
		{
			Statement st = con.createStatement();
			sql ="Insert into savings_customer(name,balance,pass_code) values('"+ accountName + "',100, "+ passCode +")";
			if (st.executeUpdate(sql)==1)
			{
				System.out.println("Savings account user added successfully!!");
				return true;
			}
			
		}
		else
		{
			Statement st = con.createStatement();
			sql ="Insert into checkings_customer(name,balance,pass_code) values('"+ accountName + "',100, "+ passCode +")";
			if (st.executeUpdate(sql)==1)
			{
				System.out.println("Checkings account user added successfully!!");
				return true;
			}
		}
		return false;
		
	}
	public static boolean deleteUsers(String accountName, String accountType) throws SQLException
	{
		if(accountType.equals("savings"))
		{
			Statement st = con.createStatement();
			sql = "delete from savings_customer where name='"+accountName+"'";
			if (st.executeUpdate(sql)==1)
			{
				System.out.println("Savings account user deleted successfully!!");
				return true;
			}
		}
		else
		{
			Statement st = con.createStatement();
			sql = "delete from checkings_customer where name='"+accountName+"'";
			if (st.executeUpdate(sql)==1)
			{
				System.out.println("Checkings account user deleted successfully!!");
				return true;
			}
		}
		return false;
	}
}
