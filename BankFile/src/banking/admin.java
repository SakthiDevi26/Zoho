//menu for admin

package banking;

import java.io.*;




public class admin {

	private static final int NULL = 0;
	public static boolean loginAccount(String adminName, int adminPass)
	{
		BufferedReader sc = new BufferedReader(
				new InputStreamReader(System.in));
		int ch;
		//validation
		if (adminName == "" || adminPass == NULL) {
			System.out.println("All Field Required!");
			return false;
		}
				while (true) {
						System.out.println("Hello, Admin "+ adminName);
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

				return true;
			
	}
}
