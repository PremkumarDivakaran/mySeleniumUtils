package restApi.http;

import restApi.request.HttpMethod;

public class HttpClientFactory {

    public static HttpClientManager executeRequest(HttpMethod httpMethod){
        switch (httpMethod){
            case GET:
                return new GetRequest();
            case POST:
                return new PostRequest();
            case DELETE:
                return new DeleteRequest();
            case PUT:
                return new PutRequest();
            default:
                throw new IllegalStateException("not valid");
        }

    }


}
