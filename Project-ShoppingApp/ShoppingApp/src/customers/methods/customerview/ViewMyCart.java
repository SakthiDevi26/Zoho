package customers.methods.customerview;

import java.sql.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import customers.methods.driver.MyCartDriver;
import customers.registeration.classes.driver.CustomerMainDriver;
import databaseoperations.classes.databasecheckoperations.CheckProductId;
import databaseoperations.classes.databasegetoperations.GetDetailsFromDatabase;
import databaseoperations.classes.databasegetoperations.GetListDetailsFromDatabase;
import sql.DatabaseConnection;

public class ViewMyCart {
	String sql="",sql1="";
	Connection connect = DatabaseConnection.getConnection();
	CustomerMainDriver customerMainDrive = new CustomerMainDriver();
	CheckProductId checkProductId = new CheckProductId();
	Scanner scanner = new Scanner(System.in);
	public void viewMyCart()
	{
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		GetListDetailsFromDatabase getListDetailsFromDb = new GetListDetailsFromDatabase();
		int customerId = getDetailsFromDb.getCurrentlyLoggedInCustomerId();
		ArrayList<Integer> productIdList = new ArrayList<Integer>();
		productIdList = getListDetailsFromDb.getProductIdListInCart(customerId);
		if(!productIdList.isEmpty())
		{
			System.out.println(ShoppingAppConstants.smallHyphen+"<< My Cart >>"+ShoppingAppConstants.smallHyphen+"\n");
			ListIterator<Integer> iterator = productIdList.listIterator();
			while(iterator.hasNext())
			{
				String productName = getDetailsFromDb.getProductName(iterator.next());
				iterator.previous();
				int productPrice = getDetailsFromDb.getProductPrice(iterator.next());
				iterator.previous();
				System.out.printf("%12s %20s %20s\n","Product Id",
						"Name",
						"Price");
				System.out.printf("%12s %20s %20d\n", iterator.next(),productName,productPrice);
				System.out.println("\n"+ShoppingAppConstants.equalLine+ShoppingAppConstants.equalLine);
			}
			System.out.println("Enter productId you want to work with:");
			System.out.println(ShoppingAppConstants.goHome);
			int productId = scanner.nextInt();
			if(productId!=0 && checkProductId.isProductIdInCart(productId))
			{
				MyCartDriver myCartDrive = new MyCartDriver();
				myCartDrive.myCartDriver(productId);
			}
			else if(productId==0)
			{
				customerMainDrive.customerMainDriver();
			}
			else
			{
				System.out.println(ShoppingAppConstants.invalidChoice);
				viewMyCart();
			}
		}
		else
		{
			System.out.println("Sorry your cart is empty :(");
		}
	}
	
}
