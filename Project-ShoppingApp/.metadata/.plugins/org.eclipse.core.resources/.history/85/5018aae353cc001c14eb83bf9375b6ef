package driver.customers;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.customers.removemethods.RemoveProductFromWishList;
import databaseoperations.interfaces.customers.removemethods.ProductFromWishListRemovable;
import utilities.PrintMenu;
import view.customers.ViewMyWishList;
import view.customers.ViewProductInDetail;

public class MyWishListDriver {
	public void myWishListDriver(int productId)
	{
		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		printMenu.printWishListDriverMenu();
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			ProductFromWishListRemovable removeProduct = new RemoveProductFromWishList();
			removeProduct.removeProductFromWishList(productId);
			System.out.println(ShoppingAppConstants.productRemoved);
			break;
		case 2:
			ViewProductInDetail viewProductInDetail = new ViewProductInDetail();
			viewProductInDetail.viewProductInDetail(productId);
			break;
		default:
			System.out.println(ShoppingAppConstants.invalidChoice);
		}
		ViewMyWishList viewWishList = new ViewMyWishList();
		viewWishList.viewMyWishList();
		
	}
}
