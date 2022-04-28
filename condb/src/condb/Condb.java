package condb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Condb {
	public static void main(String[] args) throws Exception {
		String url ="jdbc::mysql://localhost:3306/student";
		String uname ="root";
		String pass = "1234";
		String query ="select username from student where userid=3";
		//registering the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establishing connection
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		//statement creation
		Statement st = con.createStatement();
		
		//executing query
		ResultSet rs = st.executeQuery(query);
		rs.next();
		
		//result
		String name = rs.getString("username");
		System.out.println(name);
		st.close();
		con.close();
	}

}
