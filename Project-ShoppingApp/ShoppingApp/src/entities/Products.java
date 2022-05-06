package entities;

public class Products {

	public int productId;
	public String productName;
	public String productCategory;
	public String productDescription;
	private int productPrice;
	
	public Products(int productId, String productName, String productCategory, String productDescription,
			int productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.setProductPrice(productPrice);
	}

	public Products() {
		// TODO Auto-generated constructor stub
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		if(productPrice>0)
		{
		this.productPrice = productPrice;
		}
		else
		{
			System.out.println("invalid");
			throw new IllegalArgumentException();
		}
	}
	
	
}
