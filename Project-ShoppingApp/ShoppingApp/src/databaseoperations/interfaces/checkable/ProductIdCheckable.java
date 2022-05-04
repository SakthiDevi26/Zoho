package databaseoperations.interfaces.checkable;

public interface ProductIdCheckable {

	public boolean isProductIdInProductTable(int productId);
	public boolean isProductIdInCart(int productId);
	public boolean isProductIdInWishList(int productId);
}
