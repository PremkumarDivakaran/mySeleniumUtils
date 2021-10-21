package restApi.http;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import restApi.request.Request;
import restApi.response.Response;

import java.io.IOException;

public class DeleteRequest extends HttpClientManager {
    HttpDelete httpDelete;

    @Override
    public Response execute(Request request) {
        try {
            httpDelete = new HttpDelete(request.getUri());
            closeableHttpResponse = closeableHttpClient.execute(httpDelete);

            response.setStatusCode(closeableHttpResponse.getStatusLine().getStatusCode());
            //response.setResponseBody(EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
