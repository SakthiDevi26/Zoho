package databaseoperations.classes.databaseprintoperations;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasecheckoperations.CheckProductId;
import databaseoperations.interfaces.printable.DatabaseMenuPrintable;

public class PrintMenuUsingDataBase implements DatabaseMenuPrintable{
	
	CheckProductId checkProductId = new CheckProductId();
	
	/**
	 * @param productId
	 */
	public void printProductOptionsDriver(int productId) {
		
		if(checkProductId.isProductIdInCart(productId)) {
			System.out.println(ShoppingAppConstants.one+"In Cart(Go to Cart)");
		}
		else {
			System.out.println(ShoppingAppConstants.one+"Add to Cart");
		}
		if(checkProductId.isProductIdInWishList(productId)) {
			System.out.println(ShoppingAppConstants.two+"In Wishlist(Go to WishList)");
		}
		else {
			System.out.println(ShoppingAppConstants.two+"Add to Wishlist");
		}
		
		System.out.println(ShoppingAppConstants.three+"Buy Now");
		System.out.println(ShoppingAppConstants.four+"Go Home");
		System.out.println(ShoppingAppConstants.enterChoice);
	}
}
