package suppliers.suppliersmethods.classes;

import java.sql.Connection;
import java.sql.*;

import sql.DatabaseConnection;
import utilities.classes.databaseoperations.databasegetoperations.GetDetailsFromDatabase;
import appconstants.ShoppingAppConstants;

public class ViewProducts {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();

	public void viewAllProducts(String supplierUserName) {
		SupplierMethodsDriver supplierMethodsDrive = new SupplierMethodsDriver();
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		int supplierId =getDetailsFromDb.getSupplierId(supplierUserName);
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery("Select * from "+ShoppingAppConstants.productsTable+" where "
			+ShoppingAppConstants.supplierIdColumn+" = "+ supplierId);
			System.out.println(ShoppingAppConstants.smallHyphen+"<< My Products >>"+ShoppingAppConstants.smallHyphen+"\n");
			if(!resultset.next())
			{
				System.out.println("Sorry you have no products :(");
				System.out.println(ShoppingAppConstants.underscoreLine+"\n");
				
				supplierMethodsDrive.supplierMethodsDriver(supplierUserName);
			}
			else
			{
			resultset.previous();
			while (resultset.next())
			{
				int productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
				String productName = resultset.getString(ShoppingAppConstants.productNameColumn);
				String productCategory = resultset.getString(ShoppingAppConstants.productCategoryColumn);
				String productDescription = resultset.getString(ShoppingAppConstants.productDescriptionColumn);
				int productPrice = resultset.getInt(ShoppingAppConstants.productPriceColumn);
				
				System.out.printf("%12s %12s %12s %12s\n","Product Id",
						"Product Name",
						"Product Category","Product Price");
				System.out.printf("%12d %12s %12s %12d\n\n",productId,productName,productCategory,productPrice);
				System.out.printf("%40s\n","Product Description:");
				String[] productDescriptionSplit = productDescription.split("[.]",0);
				for(String productDescriptionFormatted:productDescriptionSplit)
				{
					System.out.printf("%12s\n",productDescriptionFormatted);
				}
				System.out.println("\n"+ShoppingAppConstants.equalLine+ShoppingAppConstants.equalLine);
			}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
