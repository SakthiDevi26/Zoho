package entities;

public class Customers {

	public int customerId;
	public String customerName;
	private String customerPassword;
	public String customerAddress;
	public long customerPhoneNumber;
	
	public Customers(int customerId, String customerName, String customerPassword, String customerAddress,
			long customerPhoneNumber) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerAddress = customerAddress;
		this.customerPhoneNumber = customerPhoneNumber;
	}


	public Customers() {
		// TODO Auto-generated constructor stub
	}

	
}
