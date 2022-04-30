package suppliers.suppliersmethods.classes.updateproductdetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;
import utilities.classes.GetDetails;

public class UpdateProductCategory {
		String sql="";
		Connection connect = DatabaseConnection.getConnection();
		public boolean updateProductCategory(int productId) {
			// TODO Auto-generated method stub
			GetDetails getDetails = new GetDetails();
			getDetails.getProductCategoryToUpdate();
			try {
				connect.setAutoCommit(false);

				Statement statement = connect.createStatement();


				sql = "update "+ShoppingAppConstants.productsTable+" set "+ShoppingAppConstants.productCategoryColumn+"='"+getDetails.productCategory+ 
						"' where " +ShoppingAppConstants.productIdColumn+"=" + productId;
				if (statement.executeUpdate(sql) == 1) {
					connect.commit();
					return true;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				try {
					connect.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			// return
		return false;
	}

}
