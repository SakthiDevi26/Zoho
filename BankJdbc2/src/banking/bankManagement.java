
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
	
	/*Method to create new account
	@param name, type of account and passcode
	*/
	public static boolean createAccount(String name,String accountType,int passCode)
	{
		try {
			//check if all fields are entered
			
			if (name == "" || passCode == NULL || accountType=="") {
				System.out.println("All Field Required!");
				return false;
			}

			// query
			Statement st = con.createStatement();
			sql = "INSERT INTO customer(cname,balance,ac_type,pass_code) values('"
				+ name + "',100,'" +accountType+"',"+ passCode + ")";

			// Execution
			if (st.executeUpdate(sql) == 1) {
				System.out.println(name + ", Now You Login!");
				return true;
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
	@param name and passcode
	*/
	public static boolean
	loginAccount(String name, int passCode) // login method
	{
		Conditions fc = new Conditions(); //object
		try {
			// validation
			if (name == "" || passCode == NULL) {
				System.out.println("All Field Required!");
				return false;
			}
			// query
			sql = "select * from customer where cname='"
				+ name + "' and pass_code=" + passCode;
			PreparedStatement st
				= con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			// Execution
			BufferedReader sc = new BufferedReader(
				new InputStreamReader(System.in));

			if (rs.next()) {
				// after login

				int ch = 5;
				int amt = 0;
				int accountNumber = rs.getInt("ac_no");
				int balance = rs.getInt("balance");
				String accountType = rs.getString("ac_type");
				while (true) {
					try {
						System.out.println(
							"Hello, "
							+ rs.getString("cname"));
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
						if (ch == 1) {
							System.out.print("Enter Amount:");
							amt = Integer.parseInt(sc.readLine());

							if (bankManagement.depositMoney(accountNumber, amt)) {
								System.out.println(
									"MSG : Money Deposited Successfully!\n");
							}
							else {
								System.out.println(
									"ERR : Failed!\n");
							}
						}else if (ch == 2) {
							System.out.print("Enter Amount:");
								amt = Integer.parseInt(sc.readLine());

								if (fc.withdraw(accountNumber,balance,amt))
								{
									if (bankManagement.withdrawMoney(accountNumber,balance, amt)) 
									{
									System.out.println("MSG : Money Withdrawed Successfully!\n");
									}
									else {
										System.out.println("ERR : Failed!\n");
									}
								}
								else {
									System.out.println("Err : Criteria not matched");
								}
						}else if (ch == 3) {
							System.out.print("Enter Amount:");
								amt = Integer.parseInt(sc.readLine());
								if(fc.swipe(accountNumber, balance, amt))
								{
									if (bankManagement.swipeTransferMoney(accountNumber,balance, amt)) {
										System.out.println("MSG : Money Transfered Successfully!\n");
									}
									else {
										System.out.println("ERR : Failed!\n");
									}
								}
								else {
									System.out.println("Err: Criteria not matched");
								}
						}	
						
						
						else if (ch == 4) {

							bankManagement.getBalance(accountNumber);
						}
						else if (ch==5)
						{
							if (bankManagement.applyInterest(accountNumber,balance,accountType))
							{
								System.out.println("Applied Interest Successfully!");
							}
							else {
								System.out.println("ERR: cannot apply interest");
							}
						}
						else if (ch == 6) {
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
			}
			else {
				return false;
			}
			// return
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static void
	getBalance(int acNo) // fetch balance method
	{
		try {

			// query
			sql = "select * from customer where ac_no="
				+ acNo;
			PreparedStatement st
				= con.prepareStatement(sql);

			ResultSet rs = st.executeQuery(sql);
			System.out.println(
				"-----------------------------------------------------------");
			System.out.printf("%12s %10s %10s %16s\n",
							"Account No", "Name",
							"Balance", "Account Type");

			// Execution

			while (rs.next()) {
				System.out.printf("%12d %10s %10d.00 %10s\n",
								rs.getInt("ac_no"),
								rs.getString("cname"),
								rs.getInt("balance"),
								rs.getString("ac_type"));
			}
			System.out.println(
				"-----------------------------------------------------------\n");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean depositMoney(int accountNumber, int amount)
		throws SQLException // transfer money method
	{
		// validation
		if (accountNumber==NULL || amount == NULL) {
			System.out.println("No amount Added");
			return false;
		}
		try {
			con.setAutoCommit(false);
			sql = "select * from customer where ac_no="
				+ accountNumber;
			PreparedStatement ps
				= con.prepareStatement(sql);
			ps.executeQuery();


			Statement st = con.createStatement();

			// debit
			//con.setSavepoint();

			sql = "update customer set balance=balance+"
				+ amount + " where ac_no=" + accountNumber;
			if (st.executeUpdate(sql) == 1) {
				System.out.println("Amount Deposited!");
			}


			con.commit();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		}
		// return
			return false;
		}
	public static boolean withdrawMoney(int accountNumber,int balance, int amount)
			throws SQLException // transfer money method
		{
			try {
				con.setAutoCommit(false);
				sql = "select * from customer where ac_no="
					+ accountNumber;
				PreparedStatement ps
					= con.prepareStatement(sql);
				ps.executeQuery();


				Statement st = con.createStatement();

				// debit
				//con.setSavepoint();

				sql = "update customer set balance=balance-"+ amount + " where ac_no=" + accountNumber;
				if (st.executeUpdate(sql) == 1) {
					System.out.printf("%d Withdrawed!\n",amount);
				}


				con.commit();
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
				con.rollback();
			}
			// return
				return false;
			}
	public static boolean swipeTransferMoney(int accountNumber,int balance, int amount)
			throws SQLException // transfer money method
		{
			
			try {
				con.setAutoCommit(false);
				sql = "select * from customer where ac_no="
					+ accountNumber;
				PreparedStatement ps
					= con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();


				Statement st = con.createStatement();

				// debit
				//con.setSavepoint();
				sql = "update customer set balance=balance-"
					+ amount + " where ac_no=" + accountNumber;
				if (st.executeUpdate(sql) == 1) {
					System.out.println("Amount Withdrawed!");
				}


				con.commit();
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
				con.rollback();
			}
			// return
				return false;
			}
	public static boolean applyInterest (int accountNumber,int balance,String accountType) throws SQLException
	{
		try {
			con.setAutoCommit(false);
			sql = "select * from customer where ac_no=" + accountNumber;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String type = rs.getString("ac_type");
			String str="savings";
			if(str.equals(type)) {
				int interest = (int) (0.02*balance);
				Statement st = con.createStatement();
				sql ="update customer set balance=balance+"+interest+" where ac_no="+accountNumber;
				if (st.executeUpdate(sql) == 1) {
					System.out.println("Interest Applied!");
				}
			}

			else
			{
				System.out.println("Cannot apply interest to "+type);
				return false;
			
		}
		con.commit();
		return true;
		
	}
	catch (Exception e) {
		e.printStackTrace();
		con.rollback();
	}
		return false;
}
}


