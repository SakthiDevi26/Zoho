package customers.methods.driver;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import customers.methods.customerview.ViewMyCart;
import customers.methods.customerview.ViewMyWishList;
import customers.methods.customerview.ViewProductInDetail;
import customers.methods.database.addmethods.AddToCart;
import customers.methods.database.addmethods.AddToWishList;
import customers.methods.orders.driver.ShippingAddressDriver;
import customers.registeration.classes.database.CheckCustomerLoggedIn;
import customers.registeration.classes.driver.CustomerMainDriver;
import customers.registeration.classes.driver.CustomerRegisterationDriver;
import databaseoperations.classes.databasecheckoperations.CheckProductId;
import databaseoperations.classes.databaseprintoperations.PrintMenuUsingDataBase;


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
