import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.*;

public class WriteJson {
	static String sql="";
	static Connection connect = connection.getConnection();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JSONArray menu = new JSONArray();
		JSONObject breakfastFood = new JSONObject();
		breakfastFood.put("Idly", 20);
		breakfastFood.put("Dosa", 100);
		JSONObject breakfast = new JSONObject();
		breakfast.put("breakfast", breakfastFood);
		
		JSONObject lunchfood = new JSONObject();
		lunchfood.put("biriyani", 200);
		lunchfood.put("veg meals", 100);
		JSONObject lunch = new JSONObject();
		lunch.put("Lunch", lunchfood);
		
		JSONObject dinnerfood = new JSONObject();
		dinnerfood.put("friedrice", 200);
		dinnerfood.put("Dosa", 100);
		JSONObject dinner = new JSONObject();
		dinner.put("Dinner", dinnerfood);
		
		menu.add(breakfast);
		menu.add(lunch);
		menu.add(dinner);

			System.out.println(menu.get(1));

		}

}
