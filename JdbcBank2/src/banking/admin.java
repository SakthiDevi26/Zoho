//menu for admin

package banking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class admin {

	static String sql="";
	private static final int NULL = 0;
	static Connection con = connection.getConnection();
	public static boolean loginAccount(String adminName, int adminPass) throws SQLException
	{
		BufferedReader sc = new BufferedReader(
				new InputStreamReader(System.in));
		int ch;
		//validation
		if (adminName == "" || adminPass == NULL) {
			System.out.println("All Field Required!");
			return false;
		}
		sql = "select * from admin where aname='"
				+ adminName + "' and admin_pass=" + adminPass;
			PreparedStatement st
				= con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				while (true) {
					try {
						System.out.println("Hello, Admin "+ rs.getString("aname"));
						System.out.println("1)View Users");
						System.out.println("2)Add Users");
						System.out.println("3)Delete Users");
						System.out.println("4)Logout");
						System.out.print("Enter Choice:");
						ch = Integer.parseInt(sc.readLine());
						if(ch==1)
						{
							adminManagement.viewUsers();
							
						}else if(ch==2)
						{
							System.out.println("Enter user Name: ");
							String accountName = sc.readLine();
							System.out.println("Enter account Type savings/checking ");
							String accountType = sc.readLine();
							System.out.println("Enter passCode: ");
							int passCode = Integer.parseInt(sc.readLine());
							if(adminManagement.addUsers(accountName, accountType, passCode))
							{
								System.out.println("Thank you");
							}
							
						}else if(ch==3)
						{
							System.out.println("Enter username you want to delete: ");
							String accountName = sc.readLine();
							System.out.println("Enter account Type: ");
							String accountType = sc.readLine();
							if(adminManagement.deleteUsers(accountName, accountType))
							{
								System.out.println("Thank you");
							}
						}
						else if(ch==4)
						{
							//logout
							break;
						}
						else {
							System.out.println("Enter valid choice");
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
				return true;
			
			}
			else
			{
				return false;
			}
	}
}
