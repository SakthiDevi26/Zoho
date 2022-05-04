package databaseoperations.interfaces.suppliers;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public interface SupplierAccountCreatable {

	public boolean createSupplierAccount() throws NoSuchAlgorithmException, NoSuchProviderException;
}
