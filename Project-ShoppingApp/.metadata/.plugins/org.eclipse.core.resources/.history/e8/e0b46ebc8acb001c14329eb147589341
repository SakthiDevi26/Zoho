package databaseoperations.classes.databaseprintoperations;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasecheckoperations.CheckProductId;

public class PrintMenuUsingDataBase {
	CheckProductId checkProductId = new CheckProductId();
	public void printProductOptionsDriver(int productId)
	{
		if(checkProductId.isProductIdInCart(productId))
		{
			System.out.println(ShoppingAppConstants.one+"In Cart(Go to Cart)");
		}
		else
		{
		System.out.println(ShoppingAppConstants.one+"Add to Cart");
		}
		if(checkProductId.isProductIdInWishList(productId))
		{
			System.out.println(ShoppingAppConstants.two+"In Wishlist(Go to WishList)");
		}
		else
		{
		System.out.println(ShoppingAppConstants.two+"Add to Wishlist");
		}
		System.out.println(ShoppingAppConstants.three+"Buy Now");
		System.out.println(ShoppingAppConstants.four+"Go back");
		System.out.println(ShoppingAppConstants.enterChoice);
	}
}
