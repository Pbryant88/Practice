package page.objects;

import framework.ParentPage;
import org.apache.http.HttpResponse;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class API_transformer_endpoints extends ParentPage {
    public API_transformer_endpoints(WebDriver driver) {
        super(driver);
    }

    public HttpResponse GetTransformerResponse(String env, String type) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        String url = "";

        //Page
        if (env.equals("dev2_preview") && type.equals("page")) {
            url =
                    "http://fldcvdsla13707.wdw.disney.com:8002/transformer/api/v1/transform/preview/Page/tcm:pubId-pageId-64";
        }
        if (env.equals("dev2_live") && type.equals("page")) {
            url =
                    "http://fldcvdsla13707.wdw.disney.com:8002/transformer/api/v1/transform/live/Page/tcm:pubId-pageId-64";
        }
        //Component
        if (env.equals("dev2_preview") && type.equals("component")) {
            url =
                    "http://fldcvdsla13707.wdw.disney.com:8002/transformer/api/v1/transform/preview/Component/tcm:pubId-componentId/tcm:pubId-templateId-32";
        }
        if (env.equals("dev2_live") && type.equals("component")) {
            url =
                    "http://fldcvdsla13707.wdw.disney.com:8002/transformer/api/v1/transform/live/Component/tcm:pubId-componentId/tcm:pubId-templateId-32";
        }
        //Entity
        if (env.equals("dev2_preview") && type.equals("entity")) {
            url =
                    "http://fldcvdsla13707.wdw.disney.com:8002/transformer/api/v1/transform/preview/Entity/tcm:pubId-pageId-64";
        }
        if (env.equals("dev2_live") && type.equals("entity")) {
            url =
                    "http://fldcvdsla13707.wdw.disney.com:8002/transformer/api/v1/transform/live/Entity/tcm:pubId-pageId-64";
        }

        //Analytics
        if (env.equals("dev2_preview") && type.equals("analytics")) {
            url =
                    "http://fldcvdsla13707.wdw.disney.com:8002/transformer/api/v1/transform/preview/Analytics/tcm:pubId-pageId-64";
        }
        if (env.equals("dev2_live") && type.equals("analytics")) {
            url =
                    "http://fldcvdsla13707.wdw.disney.com:8002/transformer/api/v1/transform/live/Analytics/tcm:pubId-pageId-64";
        }

        System.out.println(url);
        HttpGet httpGETTransformer = new HttpGet(url);
        HttpResponse response = client.execute(httpGETTransformer);
        return response;
    }

    public void VerifyTransformerResponse(String env, String type) throws Exception {
        HttpResponse response = GetTransformerResponse(env, type);
        Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine().toString());
    }

    public JSONObject BrokerResponseTo_JSON(String env, String type) throws Exception {
        JSONObject responseJSON = new JSONObject(GetTransformerResponse(env, type));
        System.out.println(responseJSON);
        return responseJSON;
    }

    public HttpResponse TransformerGetHealthCheck(String env) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        String url = "";
        if (env.equals("dev2")) {
            url = "http://fldcvdsla13707.wdw.disney.com:8002/health-check";
       }
        System.out.println(url);
        HttpGet httpGETTransformer = new HttpGet(url);
        HttpResponse response = client.execute(httpGETTransformer);
        return response;
    }

    public void VerifyTransformerHealthCheck(String env) throws Exception {
        HttpResponse response = TransformerGetHealthCheck(env);
        Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine().toString());
    }

}




