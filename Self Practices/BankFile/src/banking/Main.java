package banking;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int ch;
		String adminName = "";
		int adminPass;
		while(true)
		{
			System.out.println(
					"\n ->|| Welcome to Bank ||<- \n");
				System.out.println("1)Admin");
				System.out.println("2)User");
				try {
					System.out.print("\n Enter Input:"); //user input
					ch = Integer.parseInt(sc.readLine());
					switch(ch)
					{
					case 1:
						//admin
						try {
							System.out.print("Enter username ");
							adminName = sc.readLine();
							System.out.print("Enter password ");
							adminPass = Integer.parseInt(sc.readLine());
							if(admin.loginAccount(adminName,adminPass))
							{
								System.out.print("Logged out succesfully!!");
								break;
							}
							else
							{
								System.out.print("Login failed :(");
							}
						}
						catch (Exception e) {
							System.out.println(
									" ERR : Enter Valid Data::Login Failed!\n");
						}
					case 2:
						//user
						//invoking default constructor
						bank b = new bank();
						break;
					}
				}
				catch(Exception e) {System.out.println("Enter Valid Entry!");
				}
		}
	}
}
