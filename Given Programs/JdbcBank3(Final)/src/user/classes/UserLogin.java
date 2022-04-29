package user.classes;

import basics.*;
import user.interfaces.UserLoginInterface;

import java.util.*;
import accounts.classes.*;
import bankconstants.BankConstants;

public class UserLogin implements UserLoginInterface{
	public void userLoginAccount()
	{
	PrintMenu printMenu = new PrintMenu();
	GetDetails get = new GetDetails();
	Scanner scanner = new Scanner(System.in);
	
	UserRegisterationDriver userRegisterDriver = new UserRegisterationDriver();
	CheckSavingsUserLogin checkSavingAccountLogin = new CheckSavingsUserLogin();
	CheckCheckingUserLogin checkCheckingAccountLogin = new CheckCheckingUserLogin();
	SavingsAccountDriver savingAccountDriver = new SavingsAccountDriver();
	CheckingAccountDriver checkingAccountDriver = new CheckingAccountDriver();
	
	printMenu.printAccountTypeMenu();
	int choice = scanner.nextInt();
	switch(choice)
	{
	case 1:
		get.getUserLoginDetails();
		if(checkSavingAccountLogin.canSavingsUserLogin(get.userName,get.pinNumber))
		{
			System.out.println(BankConstants.successfulLogin);
			savingAccountDriver.SavingsAccount(get.userName,get.pinNumber);
		} 
		else
		{
			System.out.println(BankConstants.failedLogin);
			userRegisterDriver.userRegister();
		}
		break;
	case 2:
		get.getUserLoginDetails();
		if(checkCheckingAccountLogin.canCheckingUserLogin(get.userName,get.pinNumber))
		{
			System.out.println(BankConstants.successfulLogin);
			checkingAccountDriver.checkingAccount(get.userName,get.pinNumber);
		}
		else
		{
			System.out.println(BankConstants.failedLogin);
			userRegisterDriver.userRegister();
		}
		break;
		
	}
	}
}
