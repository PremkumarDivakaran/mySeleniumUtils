package restApi.http;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import restApi.request.Request;
import restApi.response.Response;

import java.io.IOException;
import java.util.Map;

public class PostRequest extends HttpClientManager {
    HttpPost httpPost;

    @Override
    public Response execute(Request request) {
        try {
            httpPost = new HttpPost(request.getUri());
            if(!request.getHeader().isEmpty()){
                for(Map.Entry<String,String> eachEntry : request.getHeader().entries()) {
                    httpPost.addHeader(eachEntry.getKey(), eachEntry.getValue());
                }
            }
            httpPost.setEntity(new StringEntity(request.getRequestBody()));
            closeableHttpResponse = closeableHttpClient.execute(httpPost);

            response.setStatusCode(closeableHttpResponse.getStatusLine().getStatusCode());
            response.setResponseBody(EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
