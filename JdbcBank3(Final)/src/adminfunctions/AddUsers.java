package adminfunctions;

import java.sql.Connection;


import sql.DBConnection;
import user.classes.*;


public class AddUsers {
	String sql="";
	Connection connect = DBConnection.getConnection();
	public boolean addUsers() {
		CreateUserAccount create = new CreateUserAccount();
		if(create.createUserAccount())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
