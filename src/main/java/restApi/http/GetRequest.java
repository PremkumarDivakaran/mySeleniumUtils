package restApi.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import restApi.request.Request;
import restApi.response.Response;

import java.io.IOException;

public class GetRequest extends HttpClientManager {
    HttpGet httpGet;

    @Override
    public Response execute(Request request) {
        try {
            httpGet = new HttpGet(request.getUri());
            closeableHttpResponse = closeableHttpClient.execute(httpGet);

            response.setStatusCode(closeableHttpResponse.getStatusLine().getStatusCode());
            response.setResponseBody(EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
