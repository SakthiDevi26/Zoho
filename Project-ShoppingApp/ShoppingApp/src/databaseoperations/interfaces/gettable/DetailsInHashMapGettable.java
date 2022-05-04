package databaseoperations.interfaces.gettable;

import java.util.Map;

public interface DetailsInHashMapGettable {

	public Map<Integer, String> getProductRecommendationDetails ();
	public Map<Integer, String> getProductByCategoryDetails (String productCategory);
	public Map<Integer, String> getAllProducts();
}
