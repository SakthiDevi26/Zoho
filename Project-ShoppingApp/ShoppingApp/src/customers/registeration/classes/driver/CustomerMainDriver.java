package customers.registeration.classes.driver;

import java.util.Scanner;

import customers.methods.customerview.ViewProductInDetail;
import customers.registeration.classes.database.CheckCustomerLoggedIn;
import customers.registeration.classes.view.ProductRecommendations;

public class CustomerMainDriver {
	public int productId;
	public void customerMainDriver() {
		Scanner scanner = new Scanner(System.in);
		ProductRecommendations productRecommend = new ProductRecommendations();
		productId = productRecommend.showProductRecommendations();
		if(productId!=0 && productId!=1) //entered id in random
		{
			ViewProductInDetail viewProduct = new ViewProductInDetail();
			viewProduct.viewProductInDetail(productId);
		}
		else if(productId == 1) //entered invalid
		{

			System.out.println("Invalid");
			customerMainDriver();
		}
		else //entered 0
		{
			CheckCustomerLoggedIn checkCustomerLoggedIn = new CheckCustomerLoggedIn();
			if(checkCustomerLoggedIn.isCustomerLoggedin())
			{
				CustomerAfterLoginDriver customerAfterLoginDriver = new CustomerAfterLoginDriver();
				customerAfterLoginDriver.customerAfterLoginDriver();
			}
			else
			{
				CustomerBeforeLoginDriver customerBeforeLoginDriver = new CustomerBeforeLoginDriver();
				customerBeforeLoginDriver.customerBeforeLoginDriver();
			}
		}
	}

}
