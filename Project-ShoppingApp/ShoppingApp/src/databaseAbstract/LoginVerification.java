package databaseAbstract;

import java.sql.Connection;

import sql.DatabaseConnection;

public abstract class LoginVerification {
	public String sql="";
	public Connection connect = DatabaseConnection.getConnection();
	public abstract boolean verifyLogin(String userName, String password);
}
