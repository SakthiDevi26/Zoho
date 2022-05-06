package view.customers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetProductDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetSupplierDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetProductEntityDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetSupplierEntityDetails;
import databaseoperations.classes.databasegetoperations.getlistfromdatabase.GetCustomerIdList;
import databaseoperations.interfaces.gettable.CustomerIdListGettable;
import databaseoperations.interfaces.gettable.ProductDetailsGettable;
import databaseoperations.interfaces.gettable.SupplierDetailsGettable;
import driver.customers.ProductOptionsDriver;
import entities.Customers;
import entities.Products;
import entities.Suppliers;
import sql.DatabaseConnection;

public class ViewProductInDetail {
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	
	public int supplierId,customerId;
	
	/**
	 * 
	 * @param productId
	 */
	public void viewProductInDetail(int productId) {
		
		//objects
		ProductOptionsDriver productOptionDriver = new ProductOptionsDriver();
		ProductDetailsGettable getProductDetails = new GetProductDetails();
		SupplierDetailsGettable getSupplierDetails = new GetSupplierDetails();
		CustomerIdListGettable getCustomerIdList = new GetCustomerIdList();
		
		System.out.println("\n"+ShoppingAppConstants.equalLine);
		System.out.printf("\n%12s %30s\n",
				"Product Name",
				"Category");
		
		GetProductEntityDetails getProduct = new GetProductEntityDetails();
		ArrayList<Products> productList = getProduct.getProductList(productId);
		for (Products product : productList)
		{
			System.out.printf("%12s %30s\n\n",product.productName,product.productCategory);
			System.out.printf("%12s\n","Description:");
			String[] productDescriptionSplit = product.productDescription.split("[.]",0);
			
			for(String productDescriptionFormatted:productDescriptionSplit) {
				System.out.printf("%12s\n",productDescriptionFormatted);
				System.out.printf("Buy at only:%d\n\n",product.getProductPrice());
				
			}
		}
		
		
		System.out.println(ShoppingAppConstants.bigUnderscoreLine);	
		
		supplierId = getSupplierDetails.getSupplierId(productId);
		
		//supplier details
		
		GetSupplierEntityDetails getSupplier = new GetSupplierEntityDetails();
		ArrayList<Suppliers> supplierList = getSupplier.getSupplierList(supplierId);
		for(Suppliers supplier : supplierList)
		{
			System.out.printf("\n\nSold by :%s\n",supplier.supplierName);
			System.out.printf("Contact Supplier at %d\n\n", supplier.supplierPhoneNumber);
		}
		
		
		System.out.println(ShoppingAppConstants.bigUnderscoreLine);	
		System.out.println("\n"+ShoppingAppConstants.equalLine);
		
		//reviews to be added
		
		productOptionDriver.productOptionsDriver(productId);
	}

}
