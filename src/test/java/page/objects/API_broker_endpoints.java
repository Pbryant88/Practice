package page.objects;

import framework.ParentPage;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.*;


public class API_broker_endpoints extends ParentPage {

    public API_broker_endpoints(WebDriver driver) {super(driver);}
    public void ValidateBrokerResponse() throws Exception {

        CloseableHttpClient client = HttpClients.createDefault();
        //Dev2 Live URL
        HttpGet httpGETBroker = new HttpGet(
                "http://fldcvdsla13707.wdw.disney.com:8010/query/Entity/tcm:286-124687");

        HttpResponse response = client.execute(httpGETBroker );
        Assert.assertEquals("HTTP/1.1 404 Not Found", response.getStatusLine().toString());
    }
    

    public CloseableHttpResponse getBrokerResponse() throws Exception{

        CloseableHttpClient client = HttpClients.createDefault();
        //Dev2 Live URL
            HttpGet httpGETBroker = new HttpGet(
                    "http://fldcvdsla13707.wdw.disney.com:8010/broker/query/Entity/tcm:286-124687");
        httpGETBroker.addHeader("X-Conversation-Id", "auto");
        httpGETBroker.addHeader("Accept-Language", "en-US");

        CloseableHttpResponse response = client.execute(httpGETBroker);
        int responseCode = response.getStatusLine().getStatusCode();
    return response;
    }

    public String getBrokerResponseString() throws Exception{

        CloseableHttpClient client = HttpClients.createDefault();
        //Dev2 Live URL
        HttpGet httpGETBroker = new HttpGet(
                "http://fldcvdsla13707.wdw.disney.com:8010/broker/query/Entity/tcm:286-124687");
        CloseableHttpResponse response = client.execute(httpGETBroker);

        HttpEntity eResponse = response.getEntity() ;
        String responseBody = EntityUtils.toString(eResponse);
        System.out.println(responseBody);
        return responseBody;
    }

    public JSONObject BrokerResponseString_To_JSON(String response){
        JSONObject responseJSON = new JSONObject(response);
        System.out.println(responseJSON.keys());
        return responseJSON;
    }

    public JSONObject BrokerResponseTo_JSON(CloseableHttpResponse response){
        JSONObject responseJSON = new JSONObject(response);
        System.out.println(responseJSON);
        return responseJSON;
    }

    public void verifyBrokerResponsesString(String response){
       //System.out.println(response);
       String[] ary = response.split("");
       System.out.println(ary);
    }

    public void verifyBrokerResponsesJSON(JSONObject responseJSON){
        System.out.println(responseJSON);
    }

    public void verifyBrokerResponse(CloseableHttpResponse response) {
        Assert.assertEquals("HTTP/1.1 404 Not Found", response.getStatusLine().toString());
    }

    public void verifyBrokerItemArrayFormat(CloseableHttpResponse response) {
        Assert.assertEquals("HTTP/1.1 404 Not Found", response.getStatusLine().toString());
    }
}
