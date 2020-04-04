package page.objects;

import framework.ParentPage;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

public class MB_API_endpoints extends ParentPage{
    public MB_API_endpoints(WebDriver driver) {super(driver);}

    public static HttpResponse MBQuickSearchResponse (String query) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();

        //Static API String
        String API_Key = "8AF60BE5-6232-4404-BEDB-393C67468802";


        //build URI For Quick search
        URIBuilder builder = new URIBuilder();
//        builder.setScheme("http").setHost("fldcvsswa0792.wdw.disney.com").setPort(55555)
//                .setPath("/wf/quickSearch?src=" + query +"&apikey=" + API_Key);

        builder.setScheme("http").setHost("fldcvsswa0792.wdw.disney.com").setPort(55555)
                .setPath("/wf/quickSearch?src="+ query  +"&apikey=" + API_Key);

        StringBuilder sb = null;
        sb = new StringBuilder("http://fldcvsswa0792.wdw.disney.com");
        sb.append(":55555");
        sb.append("/wf/quickSearch?src=");
        sb.append(query);
        sb.append("&apikey=");
        sb.append(API_Key);
        String url = sb.toString();

        System.out.println(url);

        // SET URI to GET Command
       // HttpGet httpGET_MB_Search = new HttpGet(builder.build());

        //Perform GET
        HttpGet httpGET_MB_Search = new HttpGet(url);
        httpGET_MB_Search.addHeader("Content-Type", "application/json");
        HttpResponse response = client.execute(httpGET_MB_Search);
       // Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine().toString());
        ResponseHandler<String> handler = new BasicResponseHandler();
        String body = handler.handleResponse(response);
        System.out.println(body);
        return response;
    }

    public static boolean ValidateResponseCode( String query) throws Exception{
        HttpResponse response = MBQuickSearchResponse(query);
       return(response.getStatusLine().toString().equals("HTTP/1.1 200 OK"));
    }

    public static boolean ValidateResponseFormatQuickSearch (String query) throws Exception{
        HttpResponse response = MBQuickSearchResponse(query);
        JSONObject jsonResponse = new JSONObject((response));
       System.out.println(jsonResponse);
       return true;
    }

    public static HttpResponse MB_Folder_SRC_Response (String query) throws Exception {

   return MBQuickSearchResponse(query);  }

}
