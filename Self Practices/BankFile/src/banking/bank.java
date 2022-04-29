//menu for create account and login into account

package banking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bank {
	ArrayList<String> saveUsers = new ArrayList<String>();
	public bank() throws IOException
	{

		BufferedReader sc = new BufferedReader(
			new InputStreamReader(System.in));
		String name = "";
		int passCode;
		int ch;
		String accountType ="";
		int num = 0;
		

		while (true) {
			System.out.println(
				"\n ->|| Welcome to Bank ||<- \n");
			System.out.println("1)Create Account");
			System.out.println("2)Login Account");

			try {
				System.out.print("\n Enter Input:"); //user input
				ch = Integer.parseInt(sc.readLine());

				switch (ch) {
				case 1:
					//creating Account
					try {
						System.out.println("How many accounts you want to create");
						num = Integer.parseInt(sc.readLine());
						for(int i=0;i<num;i++)
						{
						System.out.print(
							"Enter Unique UserName:");
						name = sc.readLine();
						System.out.print(
							"Enter New Password:");
						passCode = Integer.parseInt(
							sc.readLine());
						System.out.print("Enter account type savings/checking:");
						accountType = sc.readLine();
						//calling createAccount method
						saveUsers.add(name+"  "+passCode+"  "+accountType);
						if (bankManagement.createAccount(saveUsers)) {
							System.out.println(
								"MSG : Account Created Successfully!\n");
						}
						else {
							System.out.println(
								"ERR : Account Creation Failed!\n");
						}
						}
					}
					catch (Exception e) {
						System.out.println(
							" ERR : Enter Valid Data::Insertion Failed!\n");
					}
					break;

				case 2:
					//login
					try {
						System.out.print(
							"Enter UserName:");
						name = sc.readLine();
						System.out.print(
							"Enter Password:");
						passCode = Integer.parseInt(
							sc.readLine());
						System.out.print("Enter account type savings/checking:");
						accountType = sc.readLine();
						
						//calling loginAccount method
						if (bankManagement.loginAccount(
								name,accountType, passCode)) {
							System.out.println(
								"MSG : Logout Successfully!\n");
						}
						else {
							System.out.println(
								"ERR : login Failed!\n");
						}
					}
					catch (Exception e) {
						System.out.println(
							" ERR : Enter Valid Data::Login Failed!\n");
					}

					break;
					

				default:
					System.out.println("Invalid Entry!\n");
				}

				if (ch == 6) {
					System.out.println(
						"Exited Successfully!\n\n Thank You :)");
					break;
				}
			}
			catch (Exception e) {
				System.out.println("Enter Valid Entry!");
			}
		}
		sc.close();
	}
}
