package banking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckingsAccount extends Account{

	@Override
	public boolean depositMoney(int accountNumber, int amount) throws SQLException {
		// TODO Auto-generated method stub
		if (accountNumber==NULL || amount == NULL) {
			System.out.println("No amount Added");
			return false;
		}
		try {
			con.setAutoCommit(false);
			sql = "select * from checkings_customer where ac_no="
				+ accountNumber;
			PreparedStatement ps
				= con.prepareStatement(sql);
			ps.executeQuery();


			Statement st = con.createStatement();

			// debit
			//con.setSavepoint();

			sql = "update checkings_customer set balance=balance+"
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

	@Override
	public boolean withdrawMoney(int accountNumber, int balance, int amount) throws SQLException {
		// TODO Auto-generated method stub
		int charges=0;
		if(amount%5!=0) {
			System.out.println("Please enter in multiples of 5");
			return false;
		}
		if(amount>100)
		{
			charges = (int) (0.04*amount);
			amount = amount + charges;
			System.out.println("Charges: "+charges);
		}
		else
		{
			charges = (int) (0.02*amount);
			amount = amount + charges;
			System.out.println("Charges: "+charges);
		}
		if(amount<balance)
		{
		try {
			con.setAutoCommit(false);
			sql = "select * from checkings_customer where ac_no="
				+ accountNumber;
			PreparedStatement ps
				= con.prepareStatement(sql);
			ps.executeQuery();


			Statement st = con.createStatement();

			// debit
			//con.setSavepoint();

			sql = "update checkings_customer set balance=balance-"+ amount + " where ac_no=" + accountNumber;
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
		}
		else
		{
			System.out.println("Balance insufficient");
		}
		// return
		return false;
	}

	@Override
	public boolean swipeTransferMoney(int accountNumber, int balance, int amount) throws SQLException {
		// TODO Auto-generated method stub
		int cashBack = (int) (0.01*amount);
		amount = amount-cashBack;
		System.out.println("CashBack: "+cashBack);
		try {
			con.setAutoCommit(false);
			sql = "select * from checkings_customer where ac_no="
				+ accountNumber;
			PreparedStatement ps
				= con.prepareStatement(sql);
			ps.executeQuery();


			Statement st = con.createStatement();

			// debit
			//con.setSavepoint();
			sql = "update checkings_customer set balance=balance-"
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

	@Override
	public void getBalance(int acNo) {
		// TODO Auto-generated method stub
		try {

			// query
			sql = "select * from checkings_customer where ac_no="
				+ acNo;
			PreparedStatement st
				= con.prepareStatement(sql);

			ResultSet rs = st.executeQuery(sql);
			System.out.println(
				"-----------------------------------------------------------");
			System.out.printf("%12s %10s %10s\n",
							"Account No", "Name",
							"Balance");

			// Execution

			while (rs.next()) {
				System.out.printf("%12d %10s %10d.00\n",
								rs.getInt("ac_no"),
								rs.getString("name"),
								rs.getInt("balance"));
			}
			System.out.println(
				"-----------------------------------------------------------\n");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
