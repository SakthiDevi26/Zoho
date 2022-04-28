package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PrintAll {
	public static void main(String[] args) throws Exception {
		String url ="jdbc:mysql://localhost:3306/student";
		String uname ="root";
		String pass = "1234";
		String query ="select * from student";
		//registering the driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//establishing connection
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		//statement creation
		Statement st = con.createStatement();
		
		//executing query
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			String userdata = rs.getInt(1) + ":" + rs.getString(2);
			System.out.println(userdata);
		}
		
		
		st.close();
		con.close();
	}
}
