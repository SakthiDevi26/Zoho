package customers.registeration.classes;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;
import appconstants.ShoppingAppConstants;

public class ProductRecommendations {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public int productId;

	public int showProductRecommendations() {
		Scanner scanner = new Scanner(System.in);
		Map <Integer, String> productMap = new HashMap<>();
	
		sql ="SELECT "+ShoppingAppConstants.productIdColumn+","+ShoppingAppConstants.productNameColumn+","+ ShoppingAppConstants.productDescriptionColumn+" FROM "+
				ShoppingAppConstants.productsTable+ " ORDER BY RAND ( ) LIMIT 4 ";
						try {
							Statement statement = connect.createStatement();
							ResultSet resultset = statement.executeQuery(sql);
							System.out.println("\n-----------------------<< Let your day begin here!! >>---------------------\n");
							System.out.printf("%20s\n",ShoppingAppConstants.productRecommendation);
							while (resultset.next())
							{
								int productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
								String productName = resultset.getString(ShoppingAppConstants.productNameColumn);
								productMap.put(productId, productName);
							}
							System.out.printf("%12s %25s\n","Product Id","Product Name");
							System.out.println(ShoppingAppConstants.underscoreLine);
							for(Map.Entry<Integer, String> entry : productMap.entrySet())
							{
								
								System.out.printf("%12d %25s\n",entry.getKey(),entry.getValue());
								System.out.println(ShoppingAppConstants.hyphenLine);
							}
							System.out.println("\nEnter the product id to view the product:");
							System.out.println("Not interested in any? press 0");
							productId = scanner.nextInt();
							
							//if customer enters the productId in random options
							if(productMap.containsKey(productId))
							{
								return productId;
							}
							else if(productId!=0) //if customer enters invalid id any number other than 0
							{
								return 1;
							}
		
						}
						catch (SQLException e) {
							e.printStackTrace();
						}
						return 0; //if customer doesn't like any random product
				
		
	}

}
