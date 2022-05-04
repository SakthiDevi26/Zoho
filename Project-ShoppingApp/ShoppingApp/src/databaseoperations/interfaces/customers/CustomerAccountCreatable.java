package databaseoperations.interfaces.customers;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public interface CustomerAccountCreatable {

	public boolean createCustomerAccount() throws NoSuchAlgorithmException, NoSuchProviderException;
}
