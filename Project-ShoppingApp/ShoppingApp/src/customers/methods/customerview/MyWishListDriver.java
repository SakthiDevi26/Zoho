package customers.methods.customerview;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import customers.methods.ViewProductInDetail;
import customers.methods.removemethods.RemoveProductFromWishList;
import utilities.PrintMenu;

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
			RemoveProductFromWishList removeProduct = new RemoveProductFromWishList();
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
