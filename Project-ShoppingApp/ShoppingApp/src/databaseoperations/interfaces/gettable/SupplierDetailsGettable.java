package databaseoperations.interfaces.gettable;

public interface SupplierDetailsGettable {

	public int getSupplierId(String supplierUserName);
	public String getSupplierName(int supplierId);
	public long getSupplierPhoneNumber(int supplierId);
	public int getSupplierId(int productId);
}
