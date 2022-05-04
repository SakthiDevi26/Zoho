package databaseoperations.interfaces.customers;

public interface CustomerLoginVerifiable {

	public boolean verifyCustomerLogin(long customerPhoneNumber, String customerPassword);
}
