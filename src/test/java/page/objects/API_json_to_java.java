package page.objects;

import framework.ParentScenario;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class API_json_to_java extends ParentScenario {

    //Covert Json Object to Java Object
    @Test
    public void Json_To_Java() throws Exception {
        try {
            URL url = new URL
                    ("http://fldcvdsla6345.wdw.disney.com:8003/ics-content-api/appid/wdd/page/madhav-test.ics.wdw.akl-room?segmentId=102");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException(" HTTP error code : "
                + conn.getResponseCode());
            }

            Scanner scan = new Scanner(url.openStream());
            String entireResponse = "";
            while (scan.hasNext())
                entireResponse += scan.nextLine();

            System.out.println("Response : "+entireResponse);

            scan.close();

            JSONObject obj = new JSONObject(entireResponse );
            String responseCode = obj.getString("status");
            System.out.println("status : " + responseCode);

            JSONArray arr = obj.getJSONArray("results");
            for (int i = 0; i < arr.length(); i++) {
                String placeid = arr.getJSONObject(i).getString("place_id");
                System.out.println("Place id : " + placeid);
                String formatAddress = arr.getJSONObject(i).getString(
                        "formatted_address");
                System.out.println("Address : " + formatAddress);

//validating Address as per the requirement
                if(formatAddress.equalsIgnoreCase("Lake Buena Vista, FL USA"))
                {
                    System.out.println("Address is as Expected");
                }
                else
                {
                    System.out.println("Address is not as Expected");
                }
            }

            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
