package page.objects;

import framework.ParentPage;
import org.apache.http.HttpResponse;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.WebDriver;
import org.testng.*;


public class API_ics_content extends ParentPage {

    public API_ics_content(WebDriver driver) {
        super(driver);
    }

    public void Validate_ICS_health_check(String env) throws Exception {

        CloseableHttpClient client = HttpClients.createDefault();
        //Dev URL
        if (env.equals("qa")) {
            HttpGet httpGETBroker = new HttpGet(
                    "http://fldcvdsla6345.wdw.disney.com:8003/health-check");

            HttpResponse response = client.execute(httpGETBroker);

            Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine().toString());
        }
        if (env.equals("dev")) {
            HttpGet httpGETBroker = new HttpGet(
                    "http://fldcvdsla6345.wdw.disney.com:8003/health-check");

            HttpResponse response = client.execute(httpGETBroker);

            Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine().toString());
        }
        }


    public CloseableHttpResponse get_ics_response_content() throws Exception {

        CloseableHttpClient client = HttpClients.createDefault();
        //Dev URL
        HttpGet httpGETBroker = new HttpGet(
                "http://fldcvdsla6345.wdw.disney.com:8003" +
                        "/ics-content-api/appid/wdd/page/madhav-test.ics.wdw.splash-mountain?segmentId=102?language=es-AR");
        // httpGETBroker.addHeader("X-Conversation-Id", "auto");

        CloseableHttpResponse response = client.execute(httpGETBroker);
        int responseCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals("HTTP/1.1 404 Not Found", response.getStatusLine().toString());
        return response;
    }

    public CloseableHttpResponse get_ics_response_structure() throws Exception {

        CloseableHttpClient client = HttpClients.createDefault();
        //Dev URL
        HttpGet httpGETBroker = new HttpGet(
                "http://fldcvdsla6345.wdw.disney.com:8003/ics-content-api/structure/dcc1?segmentId=101&segmentId=118");
        // httpGETBroker.addHeader("X-Conversation-Id", "auto");

        CloseableHttpResponse response = client.execute(httpGETBroker);
        int responseCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals("HTTP/1.1 404 Not Found", response.getStatusLine().toString());
        return response;
    }

    public CloseableHttpResponse get_ics_contact_info() throws Exception {

        CloseableHttpClient client = HttpClients.createDefault();
        //Dev URL
        HttpGet httpGETBroker = new HttpGet(
                "http://fldcvdsla6345.wdw.disney.com:8003/information");
        // httpGETBroker.addHeader("X-Conversation-Id", "auto");

        CloseableHttpResponse response = client.execute(httpGETBroker);
        int responseCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine().toString());
        return response;
    }


}