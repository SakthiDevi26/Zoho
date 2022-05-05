package driver.orders;

import com.mashape.unirest.http.*;
import com.mashape.unirest.request.body.MultipartBody;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONML;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class  FeedbackAnalyzerAPI{

	/**
	 * 
	 * @param feedback
	 * @return analyzed feedback
	 * @throws Exception
	 */
	  public static String feedbackAnalyzer(String feedback) throws Exception {
	    
			Unirest.setTimeouts(0, 0);
		    HttpResponse<JsonNode> response = Unirest.post("http://127.0.0.1:5000/analyze") //API
		      .field("text", feedback)
		      .asJson();
		    org.json.JSONObject jsonObject = response.getBody().getObject();
		    String analyzedFeedback = jsonObject.getString("response");
		    
		    return analyzedFeedback;
	  }
}
