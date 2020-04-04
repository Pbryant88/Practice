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

import java.util.HashMap;


public class API_content_endpoints extends ParentPage {

    public API_content_endpoints(WebDriver driver) {
        super(driver);
    }

    public void ValidateContentResponse(String type) throws Exception {

        CloseableHttpClient client = HttpClients.createDefault();
        //Dev2 Live URL

        System.out.println(type);
        if (type.equals("<Entity>")) {
            HttpGet httpGETBroker = new HttpGet(
                    "http://fldcvdsla13707.wdw.disney.com:8005/content-service/environments/live/entities/tcm:286-124687;type=canonicalHandle");
            HttpResponse response = client.execute(httpGETBroker);
            System.out.println("***Entity Response***");
            System.out.println(response);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            System.out.println("***Entity Body***");
            System.out.println(responseString);
            Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine().toString());
            String body = entity.getContent().toString();
            System.out.println(body);

        } else if (type.equals("<Component>")) {
            HttpGet httpGETBroker = new HttpGet(
                    "http://fldcvdsla13707.wdw.disney.com:8005/content-api/bolt.weddings.default.landing");
            HttpResponse response = client.execute(httpGETBroker);
            System.out.println("***Component Response***");
            System.out.println(response);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            System.out.println(responseString);
            String body = entity.getContent().toString();
            System.out.println("***Component Body***");
            System.out.println(body);
            Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine().toString());

        } else if (type.equals("<Component_URL>")) {
            HttpGet httpGETBroker = new HttpGet(
                    "http://fldcvdsla13707.wdw.disney.com:8005/content-service/environments/live/pages");
            HttpResponse response = client.execute(httpGETBroker);
            System.out.println("***Component URL Response***");
            System.out.println(response);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            System.out.println(responseString);
            String body = entity.getContent().toString();
            System.out.println("***Component_URL Body***");
            System.out.println(body);
            Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine().toString());


        } else if (type.equals("<Resource_Bundle>")) {
            HttpGet httpGETBroker = new HttpGet(
                    "http://fldcvdsla13707.wdw.disney.com:8005/content-service/environments/live/resource-bundles/vb.site.resorts.resorts.recreation.facility.vero-beach-resort");
            HttpResponse response = client.execute(httpGETBroker);
            System.out.println("***Resource Bundle Response***");
            System.out.println(response);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            System.out.println(responseString);
            String body = entity.getContent().toString();
            System.out.println("***Response Bundle Body***");
            System.out.println(body);
            Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine().toString());

        } else {
            System.out.println("Type Not Identified");
        }


    }
}
