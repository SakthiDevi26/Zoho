package customers.methods.customerview;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import customers.methods.driver.MyWishListDriver;
import customers.registeration.classes.driver.CustomerMainDriver;
import databaseoperations.classes.databasecheckoperations.CheckProductId;
import databaseoperations.classes.databasegetoperations.GetDetailsFromDatabase;
import sql.DatabaseConnection;


public class ViewMyWishList {
	String sql="",sql1="";
	Connection connect = DatabaseConnection.getConnection();
	CustomerMainDriver customerMainDrive = new CustomerMainDriver();
	CheckProductId checkProductId = new CheckProductId();
	Scanner scanner = new Scanner(System.in);
	public void viewMyWishList()
	{
	GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
	int customerId = getDetailsFromDb.getCurrentlyLoggedInCustomerId();
	try {
		Statement statement = connect.createStatement();
		ResultSet resultset = statement.executeQuery("Select * from "+ShoppingAppConstants.wishlistTable+" where "
		+ShoppingAppConstants.customerIdColumn+" = "+ customerId);
		
		System.out.println(ShoppingAppConstants.smallHyphen+"<< My WishList>>"+ShoppingAppConstants.smallHyphen+"\n");
		if(!resultset.next())
		{
			System.out.println("Sorry your wishlist is empty :(");
		}
		else
		{
		resultset.previous();
		while (resultset.next())
		{
			int productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
			String productName = getDetailsFromDb.getProductName(productId);
			int productPrice = getDetailsFromDb.getProductPrice(productId);
			
			System.out.printf("%12s %12s %12s\n","Product Id",
					"Name",
					"Price");
			System.out.printf("%12d %12s %12d\n",productId,productName,productPrice);
			System.out.println("\n"+ShoppingAppConstants.equalLine+ShoppingAppConstants.equalLine);
		}
		System.out.println("Enter productId of the product you want to work with:");
		}
		System.out.println("press 0 to go to home");
		int productId = scanner.nextInt();
		if(productId!=0 && checkProductId.isProductIdInWishList(productId))
		{
			MyWishListDriver myWishListDrive = new MyWishListDriver();
			myWishListDrive.myWishListDriver(productId);
		}
		else if(productId==0)
		{
			customerMainDrive.customerMainDriver();
		}
		else
		{
			System.out.println(ShoppingAppConstants.invalidChoice);
			viewMyWishList();
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
}
}
