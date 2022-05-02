package customers.methods;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import customers.methods.afterlogin.ViewMyCart;
import customers.methods.afterlogin.ViewMyWishList;
import customers.methods.buynow.ShippingAddressDriver;
import customers.methods.productoptions.AddToCart;
import customers.methods.productoptions.AddToWishList;
import customers.registeration.classes.CheckCustomerLoggedIn;
import customers.registeration.classes.CustomerMainDriver;
import customers.registeration.classes.CustomerRegisterationDriver;
import utilities.classes.PrintMenu;
import utilities.classes.PrintMenuUsingDataBase;
import utilities.classes.withdatabases.CheckProductId;

public class ProductOptionsDriver {

	public void productOptionsDriver(int productId) {
		// TODO Auto-generated method stub
		PrintMenuUsingDataBase printMenuUsingDatabase = new PrintMenuUsingDataBase();
		CheckCustomerLoggedIn checkCustomerLoggedIn = new CheckCustomerLoggedIn();
		CheckProductId checkProductId = new CheckProductId();
		ViewProductInDetail viewProductInDetail = new ViewProductInDetail();
		CustomerRegisterationDriver customerRegisterDriver = new CustomerRegisterationDriver();
		CustomerMainDriver customerMainDriver = new CustomerMainDriver();
		Scanner scanner = new Scanner(System.in);
		printMenuUsingDatabase.printProductOptionsDriver(productId);
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			if(checkCustomerLoggedIn.isCustomerLoggedin())
			{
				if(!checkProductId.isProductIdInCart(productId))
				{
					AddToCart addCart = new AddToCart();
					
					if(addCart.addToCart(productId))
					{
						System.out.println(ShoppingAppConstants.productAdded);
						viewProductInDetail.viewProductInDetail(productId);
					}
				}
				else
				{
					ViewMyCart viewCart = new ViewMyCart();
					viewCart.viewMyCart();
				}
			}
			else
			{
				if(customerRegisterDriver.customerRegisterationDriver())
				{
					viewProductInDetail.viewProductInDetail(productId);
				}
			}
			break;
		case 2:
			if(checkCustomerLoggedIn.isCustomerLoggedin())
			{
				if(!checkProductId.isProductIdInWishList(productId))
				{
					AddToWishList addWishlist = new AddToWishList();
					
					if(addWishlist.addToWishList(productId))
					{
						System.out.println(ShoppingAppConstants.productAdded);
						viewProductInDetail.viewProductInDetail(productId);
					}
				}
				else
				{
					ViewMyWishList viewWishlist = new ViewMyWishList();
					viewWishlist.viewMyWishList();
				}
			}
			else
			{
				if(customerRegisterDriver.customerRegisterationDriver())
				{
					viewProductInDetail.viewProductInDetail(productId);
				}
			}
			break;
		case 3:
			if(checkCustomerLoggedIn.isCustomerLoggedin())
			{
				ShippingAddressDriver shipAddressDrive = new ShippingAddressDriver();
				shipAddressDrive.shippingAddressDriver(productId);
			}
			else
			{
				if(customerRegisterDriver.customerRegisterationDriver())
				{
					viewProductInDetail.viewProductInDetail(productId);
				}
			}
			break;
		case 4:
			customerMainDriver.customerMainDriver();
			break;
		default:
			System.out.println(ShoppingAppConstants.invalidChoice);
		}
		productOptionsDriver(productId);
	}

}
