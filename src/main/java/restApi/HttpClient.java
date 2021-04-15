package restApi;

import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import restApi.request.HttpMethod;
import restApi.request.Request;
import restApi.response.Response;
import java.io.IOException;
import java.util.Map;

public class HttpClient {

    CloseableHttpClient closeableHttpClient;
    HttpGet httpGet;
    HttpPost httpPost;
    HttpPut httpPut;
    HttpDelete httpDelete;
    CloseableHttpResponse closeableHttpResponse;
    Response response = new Response();

    public HttpClient(){
        closeableHttpClient = HttpClients.createDefault();
    }

    public Response execute(Request request){
        if(request.getHttpMethod().equals(HttpMethod.GET)) {
            try {
                httpGet = new HttpGet(request.getUri());
                closeableHttpResponse = closeableHttpClient.execute(httpGet);

                response.setStatusCode(closeableHttpResponse.getStatusLine().getStatusCode());
                response.setResponseBody(EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(request.getHttpMethod().equals(HttpMethod.POST)){
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
        } else if(request.getHttpMethod().equals(HttpMethod.PUT)){
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
        } else if(request.getHttpMethod().equals(HttpMethod.DELETE)){
            try {
                httpDelete = new HttpDelete(request.getUri());
                closeableHttpResponse = closeableHttpClient.execute(httpDelete);

                response.setStatusCode(closeableHttpResponse.getStatusLine().getStatusCode());
                //response.setResponseBody(EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return response;
    }




}
