package customers.methods.searchbycategory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;
import utilities.classes.withdatabases.CheckProductId;

public class ElectronicsCategory {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	int productId;
	public int showElectronicsCategoryProducts() {
		Scanner scanner = new Scanner(System.in);
		CheckProductId checkProductId = new CheckProductId();
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery("Select * from "+ShoppingAppConstants.productsTable+" where "
			+ShoppingAppConstants.productCategoryColumn+" = 'electronics'");
			System.out.println(ShoppingAppConstants.smallHyphen+"<< The world of simple Technology >>"+ShoppingAppConstants.smallHyphen+"\n");
			if(!resultset.next())
			{
				System.out.println("Sorry There is no Electronics products :(");
			}
			resultset.previous();
			System.out.printf("%12s %25s\n","Product Id",
					"Product Name");
			System.out.println(ShoppingAppConstants.underscoreLine);
			while (resultset.next())
			{
				int productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
				String productName = resultset.getString(ShoppingAppConstants.productNameColumn);
				
				
				System.out.printf("%12d %25s\n",productId,productName);
				System.out.println(ShoppingAppConstants.hyphenLine);
			}
			System.out.println("Enter ProductId of the product you love: ");
			productId = scanner.nextInt();
			if(checkProductId.isProductIdInProductTable(productId))
			{
				return productId;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
		// TODO Auto-generated method stub
		
	}

}
