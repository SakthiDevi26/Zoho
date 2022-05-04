package view.customers.searchbycategoryview;

import java.util.Map;
import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasecheckoperations.CheckProductId;
import databaseoperations.classes.databasegetoperations.GetDetailsInHashMapFromDatabase;
import databaseoperations.interfaces.checkable.ProductIdCheckable;
import databaseoperations.interfaces.gettable.DetailsInHashMapGettable;


public class ClothingCategory {
	int productId;
	public  int showClothingCategoryProducts() {
	String productCategory ="clothing";
	Scanner scanner = new Scanner(System.in);
	ProductIdCheckable checkProductId = new CheckProductId();
	DetailsInHashMapGettable getDetailsMapFromDb = new GetDetailsInHashMapFromDatabase();
	Map<Integer, String> productByCategoryMap = getDetailsMapFromDb.getProductByCategoryDetails(productCategory);
	if(!productByCategoryMap.isEmpty())
	{
	
		System.out.println(ShoppingAppConstants.smallHyphen+"<< Here's to chasing your dreams in your favourite attire >>"+ShoppingAppConstants.smallHyphen+"\n");
		System.out.printf("%12s %25s\n","Product Id",
				"Product Name");
		System.out.println(ShoppingAppConstants.underscoreLine);
		for(Map.Entry<Integer, String> entry : productByCategoryMap.entrySet())
		{
			
			System.out.printf("%12d %25s\n",entry.getKey(),entry.getValue());
			System.out.println(ShoppingAppConstants.hyphenLine);
		}
		System.out.println("Enter ProductId of the product you love: ");
		productId = scanner.nextInt();
		if(checkProductId.isProductIdInProductTable(productId))
		{
			return productId;
		}
	}
	else
	{
		System.out.println("Sorry there is no Clothing product");
	}
	
	return 0;
	// TODO Auto-generated method stub
	
	}
		
}

