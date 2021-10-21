package restApi.http;

import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import restApi.request.Request;
import restApi.response.Response;

import java.io.IOException;
import java.util.Map;

public class PutRequest extends HttpClientManager{
    HttpPut httpPut;

    @Override
    public Response execute(Request request) {
        try {
            httpPut = new HttpPut(request.getUri());
            if(!request.getHeader().isEmpty()){
                for(Map.Entry<String,String> eachEntry : request.getHeader().entries()) {
                    httpPut.addHeader(eachEntry.getKey(), eachEntry.getValue());
                }
            }
            httpPut.setEntity(new StringEntity(request.getRequestBody()));
            closeableHttpResponse = closeableHttpClient.execute(httpPut);

            response.setStatusCode(closeableHttpResponse.getStatusLine().getStatusCode());
            response.setResponseBody(EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
