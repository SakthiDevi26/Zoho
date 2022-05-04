package suppliers.suppliersmethods.classes.driver;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import suppliers.suppliersmethods.classes.database.updateproductdetails.UpdateProductCategory;
import suppliers.suppliersmethods.classes.database.updateproductdetails.UpdateProductDescription;
import suppliers.suppliersmethods.classes.database.updateproductdetails.UpdateProductName;
import suppliers.suppliersmethods.classes.database.updateproductdetails.UpdateProductPrice;
import suppliers.suppliersmethods.classes.view.ViewSupplierProducts;
import utilities.*;

public class UpdateProductDriver {
	public void updateProductDriver(String supplierUserName)
	{
	Scanner scanner = new Scanner(System.in);
	ViewSupplierProducts viewProducts = new ViewSupplierProducts();
	PrintMenu printMenu = new PrintMenu();
	GetDetails getDetails = new GetDetails();
	viewProducts.viewSupplierAllProducts(supplierUserName);
	if(getDetails.getProductIdForModification())
	{
	printMenu.printUpdateProductDriverMenu();
	int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			UpdateProductName updateProductName = new UpdateProductName();
			if(updateProductName.updateProductName(getDetails.productId))
			{
				System.out.println(ShoppingAppConstants.successfulUpdate);
			}
			else
			{
				System.out.println(ShoppingAppConstants.failedUpdate);
			}
			break;
		case 2:
			UpdateProductCategory updateProductCategory = new UpdateProductCategory();
			if(updateProductCategory.updateProductCategory(getDetails.productId))
			{
				System.out.println(ShoppingAppConstants.successfulUpdate);
			}
			else
			{
				System.out.println(ShoppingAppConstants.failedUpdate);
			}
			break;
		case 3:
			UpdateProductDescription updateProductDescription = new UpdateProductDescription();
			if(updateProductDescription.updateProductDescription(getDetails.productId))
			{
				System.out.println(ShoppingAppConstants.successfulUpdate);
			}
			else
			{
				System.out.println(ShoppingAppConstants.failedUpdate);
			}
			break;
		case 4:
			UpdateProductPrice updateProductPrice = new UpdateProductPrice();
			if(updateProductPrice.updateProductPrice(getDetails.productId))
			{
				System.out.println(ShoppingAppConstants.successfulUpdate);
			}
			else
			{
				System.out.println(ShoppingAppConstants.failedUpdate);
			}
			break;
		default:
			System.out.println(ShoppingAppConstants.invalidChoice);
			updateProductDriver(supplierUserName);
		}
	}
	else
	{
		System.out.println(ShoppingAppConstants.invalidChoice);
		updateProductDriver(supplierUserName);
	}
	}
}
