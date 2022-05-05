package passwordencryption;

public class VerifyEncryptedPassword {
	 
	/**
	 * 
	 * @param providedPassword
	 * @param securedPassword
	 * @return boolean
	 */
	public static boolean isPasswordSame(String providedPassword, String securedPassword)  {  
	      
		boolean verifyPassword = false;  
	          
        /* Generate New secure password with the same salt */  
        String newSecurePassword = EncryptPassword.encryptPassword(providedPassword);  
        /* Check if two passwords are equal */  
        verifyPassword = newSecurePassword.equalsIgnoreCase(securedPassword);  
          
        return verifyPassword;  
	 }  
}  
