package utilities.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import appconstants.ShoppingAppConstants;
import passwordencryption.EncryptPassword;
import suppliers.suppliersregistration.classes.CreateSupplierAccount;
import utilities.classes.withdatabases.CheckProductId;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
public class GetDetails {
	public String supplierUserName;
	public String supplierPassword;
	public long supplierPhoneNumber;
	public String productName;
	public String productCategory;
	public String productDescription;
	public int productPrice;
	public int productId;
	public String supplierHashedPassword;
	public String customerUserName;
	public String customerPassword;
	public long customerPhoneNumber;
	public String customerHashedPassword;
	public String customerAddress;
	
	Scanner scanner = new Scanner(System.in);
	CreateSupplierAccount createSupplierAccount = new CreateSupplierAccount();

	public boolean getSupplierCreateAccountDetails() throws NoSuchAlgorithmException, NoSuchProviderException
	{
		System.out.println(ShoppingAppConstants.enterUserName);
		supplierUserName = scanner.nextLine();
		if(supplierUserName.matches("[a-zA-Z]+"))
		{
			System.out.println(ShoppingAppConstants.enterPassword);
			supplierPassword = scanner.nextLine();
			supplierHashedPassword = EncryptPassword.encryptPassword(supplierPassword);
			System.out.println(ShoppingAppConstants.enterPhoneNumber);
			try {
			supplierPhoneNumber = scanner.nextLong();
			String supplierPhoneNumberString =Long.toString(supplierPhoneNumber);
			int phoneNumberLength = supplierPhoneNumberString.length();
			if(phoneNumberLength!=10)
			{
				System.out.println("Invalid PhoneNumber.Please enter 10 digits number.");
				return false;
			}
			else
			{
				return true;
			}
			}
			catch(InputMismatchException e)
			{
				System.out.println(ShoppingAppConstants.enterOnlyNumbers);
				return false;
			}
		}
		else {
			System.out.println("UserName cannot contain digits.Please enter valid UserName..");
			return false;
		}
	}
	public void getSupplierLoginDetails()
	{
		System.out.println(ShoppingAppConstants.enterUserName);
		supplierUserName = scanner.nextLine();
		System.out.println(ShoppingAppConstants.enterPassword);
		supplierPassword = scanner.nextLine();
	}
	public boolean getProductDetails()
	{
		System.out.println("Enter Product Name:");
		productName = scanner.nextLine();
		System.out.println("Enter Product Category:");
		productCategory = scanner.nextLine();
		System.out.println("Enter Product Description:");
		productDescription = scanner.nextLine();
		System.out.println("Enter Product Price:");
		productPrice = scanner.nextInt();
		if(!(productName.matches(".*[a-zA-Z]+.*")&&productCategory.matches(".*[a-zA-Z]+.*")&&productDescription.matches(".*[a-zA-Z]+.*")))
		{
			System.out.println("No alphabets");
			return false;
		}
		return true;
		
	}
	public boolean getProductIdForModification() {
		// TODO Auto-generated method stub
		System.out.println("Enter Product Id you wish to modify/remove:");
		productId = scanner.nextInt();
		CheckProductId checkProductId = new CheckProductId();
		if(checkProductId.isProductIdInProductTable(productId))
		{
			return true;
		}
		return false;
		
	}
	public void getProductNameToUpdate()
	{
		System.out.println("Enter New Product Name:");
		productName = scanner.nextLine();
	}
	public void getProductCategoryToUpdate() {
		System.out.println("Enter New Product Category:");
		productCategory = scanner.nextLine();
		
	}
	public void getProductDescriptionToUpdate() {
		System.out.println("Enter New Product Description:");
		productDescription = scanner.nextLine();
		
	}
	public void getProductPriceToUpdate() {
		System.out.println("Enter New Product Price:");
		productPrice = scanner.nextInt();
		
	}
	public boolean getCustomerCreateAccountDetails() throws NoSuchAlgorithmException, NoSuchProviderException
	{
		System.out.println(ShoppingAppConstants.enterUserName);
		customerUserName = scanner.nextLine();
		if(customerUserName.matches("[a-zA-Z]+"))
		{
			System.out.println(ShoppingAppConstants.enterPassword);
			customerPassword = scanner.nextLine();
			customerHashedPassword = EncryptPassword.encryptPassword(customerPassword);
			System.out.println(ShoppingAppConstants.enterAddress);
			customerAddress = scanner.nextLine();
			System.out.println(ShoppingAppConstants.enterPhoneNumber);
			try {
			customerPhoneNumber = scanner.nextLong();
			String customerPhoneNumberString =Long.toString(customerPhoneNumber);
			int phoneNumberLength = customerPhoneNumberString.length();
			if(phoneNumberLength!=10)
			{
				System.out.println("Invalid PhoneNumber.Please enter 10 digits number.");
				return false;
			}
			else
			{
				return true;
			}
			}
			catch(InputMismatchException e)
			{
				System.out.println(ShoppingAppConstants.enterOnlyNumbers);
				return false;
			}
		}
			
		else {
			System.out.println("UserName cannot contain digits.Please enter valid UserName..");
			return false;
		}
	}
	public boolean getCustomerLoginDetails() {
		// TODO Auto-generated method stub
		System.out.println(ShoppingAppConstants.enterPhoneNumber);
		try{
		customerPhoneNumber = scanner.nextLong();
		scanner.nextLine();
		System.out.println(ShoppingAppConstants.enterPassword);
		customerPassword = scanner.nextLine();
		String customerPhoneNumberString =Long.toString(customerPhoneNumber);
		int phoneNumberLength = customerPhoneNumberString.length();
		if(phoneNumberLength!=10)
		{
			System.out.println("Invalid PhoneNumber.Please enter 10 digits number.");
			return false;
		}
		else
		{
			return true;
		}
		}
		catch(InputMismatchException e)
		{
			System.out.println(ShoppingAppConstants.enterOnlyNumbers);
			return false;
		}
		
	}
	public void getCustomerNewAddress()
	{
		System.out.println("Enter new Address to ship the product:");
		customerAddress = scanner.nextLine();
	}
	
	
	
}
