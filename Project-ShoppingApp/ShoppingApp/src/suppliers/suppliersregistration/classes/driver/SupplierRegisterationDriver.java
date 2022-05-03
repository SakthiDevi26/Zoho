package suppliers.suppliersregistration.classes.driver;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.*;

import appconstants.ShoppingAppConstants;
import suppliers.suppliersregistration.classes.database.CreateSupplierAccount;
import utilities.*;

public class SupplierRegisterationDriver {
	public void supplierRegisterationDriver()
	{
		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		CreateSupplierAccount createSupplierAccount = new CreateSupplierAccount();
		SupplierLogin supplierLogin = new SupplierLogin();
		GetDetails getDetails = new GetDetails();
		printMenu.printRegisterationDriverMenu();
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			try {
				if(createSupplierAccount.createSupplierAccount())
				{
					System.out.println("Account Created Successfully!!");
					System.out.println("Now you Login...");
					if(supplierLogin.supplierLogin());
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			if(!supplierLogin.supplierLogin())
			{
				System.out.println(ShoppingAppConstants.invalidLoginCredentials);
			}
			break;
		default:
			System.out.println(ShoppingAppConstants.invalidChoice);
		}
		supplierRegisterationDriver();
		
	}
}
