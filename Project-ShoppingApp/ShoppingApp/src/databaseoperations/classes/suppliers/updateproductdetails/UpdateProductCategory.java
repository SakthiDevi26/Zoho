package databaseoperations.classes.suppliers.updateproductdetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.suppliers.updateproduct.ProductCategoryUpdatable;
import sql.DatabaseConnection;
import utilities.GetDetails;

public class UpdateProductCategory implements ProductCategoryUpdatable{
		String sql="";
		Connection connect = DatabaseConnection.getConnection();
		public boolean updateProductCategory(int productId) {
			// TODO Auto-generated method stub
			GetDetails getDetails = new GetDetails();
			getDetails.getProductCategoryToUpdate();
			try {

				Statement statement = connect.createStatement();


				sql = "update "+ShoppingAppConstants.productsTable+" set "+ShoppingAppConstants.productCategoryColumn+"='"+getDetails.productCategory+ 
						"' where " +ShoppingAppConstants.productIdColumn+"=" + productId;
				if (statement.executeUpdate(sql) == 1) {
					return true;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			// return
		return false;
	}

}
