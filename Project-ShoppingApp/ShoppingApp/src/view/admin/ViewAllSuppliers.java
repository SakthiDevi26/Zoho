package view.admin;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasecheckoperations.CheckSupplierId;
import databaseoperations.classes.databasegetoperations.GetDetailsInHashMapFromDatabase;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetSupplierDetails;
import databaseoperations.classes.databasegetoperations.getlistfromdatabase.GetCustomerIdList;
import databaseoperations.classes.databasegetoperations.getlistfromdatabase.GetSupplierIdList;
import databaseoperations.interfaces.checkable.SupplierIdCheckable;
import databaseoperations.interfaces.gettable.SupplierDetailsGettable;
import databaseoperations.interfaces.gettable.SupplierIdListGettable;
import driver.customers.MyCartDriver;
import driver.suppliers.SupplierMethodsDriver;
import utilities.GetDetails;
import view.suppliers.ViewSupplierProducts;

public class ViewAllSuppliers {

	public void ViewAllSuppliers() {
		
		GetDetails getDetails = new GetDetails();
		SupplierIdCheckable checkSupplierId = new CheckSupplierId();
		SupplierDetailsGettable getSupplierDetails = new GetSupplierDetails();
		SupplierIdListGettable getSuppliersIdList = new GetSupplierIdList();
		ViewSupplierProducts view = new ViewSupplierProducts();
		SupplierMethodsDriver supplierMethodsDrive = new SupplierMethodsDriver();
		
		
		ArrayList<Integer> suppliersIdList = new ArrayList<Integer>();
		suppliersIdList = getSuppliersIdList.getAllSuppliersId();
		if(!suppliersIdList.isEmpty()) {
			
			System.out.println(ShoppingAppConstants.bigEqualLine+"\n");
			System.out.println("\t\t\t\t\tOUR SUPPLIERS");
			//System.out.println("\t\t\tDon't Find Customers for products,find products for Customers\n");
			System.out.println(ShoppingAppConstants.bigEqualLine+"\n");
			System.out.printf("%s %20s %35s\n","Supplier Id",
					"Name","PhoneNumber");
			System.out.println(ShoppingAppConstants.bigUnderscoreLine);
	
			ListIterator<Integer> suppliersIdListIterator = suppliersIdList.listIterator();
			while(suppliersIdListIterator.hasNext()) {
				String supplierName = getSupplierDetails.getSupplierName(suppliersIdListIterator.next());
				suppliersIdListIterator.previous();
				Long supplierPhoneNumber = getSupplierDetails.getSupplierPhoneNumber(suppliersIdListIterator.next());
				suppliersIdListIterator.previous();
				System.out.printf("%s %30s %40d\n", suppliersIdListIterator.next(),supplierName,supplierPhoneNumber);
			}
			System.out.println("\n"+ShoppingAppConstants.bigEqualLine);
			getDetails.getSupplierId();
			String supplierUserName = getSupplierDetails.getSupplierName(getDetails.supplierId);
			if(getDetails.supplierId!=0 && checkSupplierId.isSupplierIdInSupplierTable(getDetails.supplierId)) {
				
				view.viewSupplierAllProducts(supplierUserName);
			}
			else if(getDetails.supplierId==0) {
				
				supplierMethodsDrive.supplierMethodsDriver(supplierUserName);
			}
			else {
				System.out.println(ShoppingAppConstants.invalidChoice);
			}
		}
		else {
			System.out.println("Sorry there is no suppliers:(");
		}
	}

}
