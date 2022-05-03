package customers.methods.searchbycategoryview;

import java.util.Map;
import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasecheckoperations.CheckProductId;
import databaseoperations.classes.databasegetoperations.GetDetailsInHashMapFromDatabase;

public class JewelleryCategory {
	int productId;
	public int showJewelleryCategoryProducts() {
		String productCategory ="jewellery";
		Scanner scanner = new Scanner(System.in);
		CheckProductId checkProductId = new CheckProductId();
		GetDetailsInHashMapFromDatabase getDetailsMapFromDb = new GetDetailsInHashMapFromDatabase();
		Map<Integer, String> productByCategoryMap = getDetailsMapFromDb.getProductByCategoryDetails(productCategory);
		if(!productByCategoryMap.isEmpty())
		{
		
			System.out.println(ShoppingAppConstants.smallHyphen+"<< Bedazzled by your SoulStone >>"+ShoppingAppConstants.smallHyphen+"\n");
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
			System.out.println("Sorry there is no Jewellery product");
		}
		
		return 0;
		// TODO Auto-generated method stub
		
	}
}
