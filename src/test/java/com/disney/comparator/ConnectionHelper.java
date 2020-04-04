package com.disney.comparator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Helper for http requests
 * @author AGUIL084
 *
 */
public class ConnectionHelper {
	
	    private static ConnectionHelper connectionHelper;
	
	    // HTTP GET request
		public String sendGet(String url) throws Exception {

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			return response.toString();

		}

		public static ConnectionHelper getInstance() {
			if (connectionHelper == null) {
				connectionHelper = new ConnectionHelper();
			}
			return connectionHelper;
		}


}
