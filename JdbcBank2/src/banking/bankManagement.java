//create account and login account methods for user

package banking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class bankManagement { // this class provides all bank method

	private static final int NULL = 0;

	static Connection con = connection.getConnection();
	static String sql = "";
	static String sql1 ="";
	
	/*Method to create new account
	@param name, type of account and passCode
	*/
	public static boolean createAccount(String name,String accountType,int passCode)
	{
		try {
			//check if all fields are entered
			
			if (name == "" || passCode == NULL || accountType=="") {
				System.out.println("All Field Required!");
				return false;
			}
			
			//create savings account
			String str="savings";
			if(str.equals(accountType))
			{
			// query
			Statement st = con.createStatement();
			sql = "INSERT INTO savings_customer(name,balance,pass_code) values('"
				+ name + "',100,"+ passCode + ")";

			// Execution
				if (st.executeUpdate(sql) == 1) {
					System.out.println(name + ", Now You Login!");
					return true;
				}
			}
			//create checking account
			else {
				Statement st = con.createStatement();
				sql = "INSERT INTO checkings_customer(name,balance,pass_code) values('"
						+ name + "',100," + passCode + ")";

				// Execution
				if (st.executeUpdate(sql) == 1) {
					System.out.println(name + ", Now You Login!");
					return true;
				}
			}
		}
		//if username exists already
		catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Username Not Available!");
		}
		catch (Exception e) {
			e.printStackTrace(); //trace the exception
		}
		return false;
	}
	
	/*Method to login to existing account
	@param name accountType and passCode
	*/
	public static boolean loginAccount(String name,String accountType, int passCode) throws SQLException // login method
	{
		BufferedReader sc = new BufferedReader(
				new InputStreamReader(System.in));
		
		//objects
		Account check = new CheckingsAccount(); 
		Account save = new SavingsAccount();
		// validation
		if (name == "" || passCode == NULL) {
			System.out.println("All Field Required!");
			return false;
		}
		// query
		String str = "savings";
		String str1 ="checking";
		
		//savingsAccount
		if (str.equals(accountType)) {
			// after login
			sql = "select * from savings_customer where name='"
					+ name + "' and pass_code=" + passCode;
				PreparedStatement st
					= con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
			if(rs.next())
			{
			int ch;
			int amt = 0;
			int accountNumber = rs.getInt("ac_no");
			int balance = rs.getInt("balance");
			
			while (true) {
				try {
					System.out.println(
						"Hello, "
						+ rs.getString("name")+" Your account Type is Savings");
					System.out.println(
						"1)Deposit Money");
					System.out.println("2)Withdraw Money");
					System.out.println("3)Purchase Using SwipeCard");
					System.out.println("4)View Balance");
					System.out.println("5)Apply Interest");
					System.out.println("6)LogOut");

					System.out.print("Enter Choice:");
					ch = Integer.parseInt(
						sc.readLine());
					if(ch==1) {
						System.out.print("Enter Amount:");
						amt = Integer.parseInt(sc.readLine());
						if(save.depositMoney(accountNumber, amt)) {
							System.out.println("MSG : Money Deposited Successfully!\n");
						}
						else {
							System.out.println(
								"ERR : Failed!\n");
						}}
						else if(ch==2) {
						System.out.print("Enter Amount:");
						amt = Integer.parseInt(sc.readLine());
							if (save.withdrawMoney(accountNumber,balance, amt)) 
							{
							System.out.println("MSG : Money Withdrawed Successfully!\n");
							}
							else {
								System.out.println("ERR : Failed!\n");
							}
						
						}
						else if(ch==3) {
						System.out.print("Enter Amount:");
						amt = Integer.parseInt(sc.readLine());
						
							if (save.swipeTransferMoney(accountNumber,balance, amt)) {
								System.out.println("MSG : Money Transfered Successfully!\n");
							}
							else {
								System.out.println("ERR : Failed!\n");
							}
						
						
						}
						else if(ch==4) {
						
						save.getBalance(accountNumber);
						}
						else if(ch==5) {
							if (SavingsAccount.applyInterest(accountNumber,balance,accountType))
							{
								System.out.println("Applied Interest Successfully!");
							}
							else {
								System.out.println("ERR: cannot apply interest");
							}
						}
						else if(ch==6) {
							break;
						}
						else {
							System.out.println("Err : Enter Valid input!\n");
						}
						
						
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
				return true;
			}
			else {
				return false;
			}
				
			}
		//checkingAccount
		else if (str1.equals(accountType)) {
			sql = "select * from checkings_customer where name='"
					+ name + "' and pass_code=" + passCode;
				PreparedStatement st
					= con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
			if(rs.next()) {
			int ch = 5;
			int amt = 0;
			int accountNumber = rs.getInt("ac_no");
			int balance = rs.getInt("balance");
			while (true) {
				try {
					System.out.println(
						"Hello, "
						+ rs.getString("name")+" Your account Type is Checkings");
					System.out.println(
						"1)Deposit Money");
					System.out.println("2)Withdraw Money");
					System.out.println("3)Purchase Using SwipeCard");
					System.out.println("4)View Balance");
					System.out.println("5)Logout");
					System.out.print("Enter Choice:");
					ch = Integer.parseInt(
						sc.readLine());
					if(ch==1) {
						System.out.print("Enter Amount:");
						amt = Integer.parseInt(sc.readLine());
						if(check.depositMoney(accountNumber, amt)) {
							System.out.println("MSG : Money Deposited Successfully!\n");
						}
						else {
							System.out.println(
								"ERR : Failed!\n");
						}}
					else if(ch==2) {
						System.out.print("Enter Amount:");
						amt = Integer.parseInt(sc.readLine());
							if (check.withdrawMoney(accountNumber,balance, amt)) 
							{
							System.out.println("MSG : Money Withdrawed Successfully!\n");
							}
							else {
								System.out.println("ERR : Failed!\n");
							}
						
					}
					else if(ch==3) {
						System.out.print("Enter Amount:");
						amt = Integer.parseInt(sc.readLine());
						
							if (check.swipeTransferMoney(accountNumber,balance, amt)) {
								System.out.println("MSG : Money Transfered Successfully!\n");
							}
							else {
								System.out.println("ERR : Failed!\n");
							}
						
						
					}
					else if(ch==4) {
						
						check.getBalance(accountNumber);
					}
					else if(ch==5) {
						break;
					}
					else {
						System.out.println("Err : Enter Valid input!\n");
					}
					
					
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
				return true;
			}
			else {
				return false;
			}
			}
			else {
				return false;
			}
		
	}
}


