package test;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;


public class HappyReturns {
	
	static String getURL = "https://happyreturnsqatest.proxy.beeceptor.com/getProductVariants";
	static String postURL = "https://happyreturnsqatest.proxy.beeceptor.com/getProductVariants";
	static String userAgentChrome = "Chrome/84.0.4147.89";
	static String variant;
	
	//get request
	public static void happyReturnsSendGet() throws IOException {
		
		URL sendGet = new URL(getURL); //new url object
		HttpURLConnection huc = (HttpURLConnection) sendGet.openConnection();
		huc.setRequestMethod("GET");
		huc.setRequestProperty("USER_AGENT", userAgentChrome);
		
		int responseCode = huc.getResponseCode();
		if(responseCode == HttpURLConnection.HTTP_OK) { //if 200, 201 is returned. open I.S and read
			BufferedReader inpStr = new BufferedReader(new InputStreamReader(huc.getInputStream()));
			
			StringBuffer hrResponse = new StringBuffer();
			String il = inpStr.readLine();
			
			while(il != null) {   //continue reading and append till null
				hrResponse.append(il);
			}
			//finish reading, close I.S
			inpStr.close();
			
			//use https://code.google.com/archive/p/json-simple/
			JSONParser parse = new JSONParse(); //attempting to complete step 2 to pass to post request below...
			
		} else {
			System.out.println("Failed to perform GET request.");
		}
	}
	
	//post request
	public static void happyReturnsSendPost() throws IOException {
		URL sendGet = new URL(getURL); //new url object
		HttpURLConnection huc = (HttpURLConnection) sendGet.openConnection();
		huc.setRequestMethod("POST");
		huc.setRequestProperty("USER_AGENT", userAgentChrome);
		
		huc.setDoOutput(true); //set to true since we want to output
		OutputStream output = huc.getOutputStream();
	
		output.write(/*object from variants array*/);
		output.flush(); //write to dest
		output.close();
		
		//response code check as above
		int responseCode = huc.getResponseCode();
		if(responseCode == HttpURLConnection.HTTP_OK) { //if 200, 201 is returned. open I.S and read
			BufferedReader inpStr = new BufferedReader(new InputStreamReader(huc.getInputStream()));
			
			StringBuffer hrResponse = new StringBuffer();
			String il = inpStr.readLine();
			
			while(il != null) {   //continue reading and append till null
				hrResponse.append(il);
			}
			//finish reading, close I.S
			inpStr.close();
			
		} else {
			System.out.println("Failed to perform POST request.");
		}
	}
	
}
