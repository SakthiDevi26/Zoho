package basics;
import java.util.*;

import admin.classes.*;
import user.classes.*;
import bankconstants.BankConstants;
public class Main {
	public static void main(String[] args)
	{
	PrintMenu printmenu = new PrintMenu();
	UserRegisterationDriver userRegisterDriver = new UserRegisterationDriver();
	AdminManagement adminmanage = new AdminManagement();
	Scanner scanner = new Scanner(System.in);
	//BankConstants.run();
	printmenu.printMainMenu();
	try {
		int choice;
		choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			AdminLogin adminlogin = new AdminLogin();
			if(adminlogin.adminLoginAccount())
			{
				adminmanage.adminOperations();
			}
			else
			{
				System.out.println(BankConstants.failedLogin);
			}
			break;
		case 2:
			userRegisterDriver.userRegister();
			break;
		case 3:
			System.out.println(BankConstants.thankyouMessage);
			System.exit(3);
		default:
			System.out.println(BankConstants.invalidChoice);	
		}
		main(args);
	}
	catch(InputMismatchException e)
	{
		System.out.println(BankConstants.invalidChoice);
		main(args);
	}
	}
}
