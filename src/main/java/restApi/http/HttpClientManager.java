package restApi.http;

import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import restApi.request.Request;
import restApi.response.Response;

public abstract class HttpClientManager {
    CloseableHttpClient closeableHttpClient;
    CloseableHttpResponse closeableHttpResponse;
    Response response = new Response();

    public HttpClientManager(){
        closeableHttpClient = HttpClients.createDefault();
    }

    public abstract Response execute(Request request);
}
