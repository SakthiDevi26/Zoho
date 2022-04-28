package banking;

import java.sql.Connection;
import java.sql.SQLException;

// Base class
// Abstract
public abstract class Account {

	protected static final int NULL = 0;

	static Connection con = connection.getConnection();
	static String sql = "";
	static String sql1 ="";
	    // Abstract
	    /**
	     * Function to deposit funds into the account as long as
	     * the amount parameter is > 0 
	     * 
	     * @param amount value to be deposited
	     * @throws SQLException 
	     */
	    public abstract boolean depositMoney(int accountNumber, int amount) throws SQLException; 

	    /**
	     * Function to withdraw funds from the Account
	     *  
	     * 
	     * @param amount value to be withdrawn
	     * @throws SQLException 
	     */    
	    public abstract boolean withdrawMoney(int accountNumber,int balance, int amount) throws SQLException; 
	    
	    public abstract boolean swipeTransferMoney(int accountNumber,int balance, int amount) throws SQLException;
	    public abstract void getBalance(int acNo);
}


