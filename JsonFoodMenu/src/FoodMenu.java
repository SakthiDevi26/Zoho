import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class FoodMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject foodMenu = new JSONObject();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter restaurant name:");
		String restaurantName = scanner.nextLine();
		System.out.println("Enter restaurant password:");
		String restaurantPassword = scanner.nextLine();
		System.out.println("Enter restaurant location:");
		String restaurantLocation = scanner.nextLine();
		
		//System.out.println("How many food items you want to add");
		//int foodItemsCount = scanner.nextInt();
		//for(int i=0;i<foodItemsCount;i++)
		//{
			//System.out.println("Enter food item name:");
			//String foodItem = scanner.nextLine();
			//System.out.println("Enter cost:");
			//int cost = scanner.nextInt();
			foodMenu.put("Idly", 20);
			foodMenu.put("Dosa", 70);
			foodMenu.put("Icecream", 100);
		//}
		
		
		//printJsonObject(foodMenu);
		Iterator<Map.Entry> iterator = foodMenu.entrySet().iterator();
		while (iterator.hasNext()) {
		Map.Entry food = iterator.next();
		System.out.println(food.getKey() + " : " + food.getValue());
		}
		

	}

}
