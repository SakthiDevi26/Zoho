package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insert {
	public static void main(String[] args) throws Exception {
		String url ="jdbc:mysql://localhost:3306/student";
		String uname ="root";
		String pass = "1234";
		String query ="insert into student values(4,'Ava')";
		//registering the driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//establishing connection
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		//statement creation
		Statement st = con.createStatement();
		
		//executing query
		int count = st.executeUpdate(query);
		System.out.println(count + "row/s affected");
		
		st.close();
		con.close();
	}
}
