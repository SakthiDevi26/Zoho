//has only method definition for users functions

package banking;

import java.sql.Connection;
import java.sql.SQLException;

// Base class
// Abstract
public abstract class Account {

	protected static final int NULL = 0;

	static Connection con = connection.getConnection();
	//used for savingsAccount
	static String sql = "";
	//used for Checkings Account
	//static String sql1 ="";
	    // Abstract
	    /**
	     * Function to deposit funds into the account as long as
	     * the given criteria is satisfied
	     * 
	     * @param amount value to be deposited
	     * @param accountNumber of which account to be used
	     * @throws SQLException 
	     */
	    public abstract boolean depositMoney(int accountNumber, int amount) throws SQLException; 

	    /**
	     * Function to withdraw funds from the Account
	     *  
	     * 
	     * @param amount value to be withdrawn
	     * @param accountNumber of which account to be used
	     * @param balance in the account
	     * @throws SQLException 
	     */    
	    public abstract boolean withdrawMoney(int accountNumber,int balance, int amount) throws SQLException; 
	    /**
	     * Function to swipe funds through card from the Account
	     *  
	     * 
	     * @param amount value to be used for purchase
	     * @param accountNumber of which account to be used
	     * @param balance in the account
	     * @throws SQLException 
	     */    
	    public abstract boolean swipeTransferMoney(int accountNumber,int balance, int amount) throws SQLException;
	    /**
	     * Function to view balance
	     * 
	     * @param accountNumber of which account balance to be viewed
	     */
	    public abstract void getBalance(int acNo);
}


