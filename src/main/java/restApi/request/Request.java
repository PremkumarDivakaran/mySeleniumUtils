package restApi.request;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class Request {

    private final String uri;
    private final HttpMethod httpMethod;
    private final Multimap<String, String> header;
    private final String requestBody;

    private Request(Builder builder){
        this.uri = builder.uri;
        this.httpMethod = builder.httpMethod;
        this.header = builder.header;
        this.requestBody = builder.requestBody;
    }

    public String getUri() {
        return this.uri;
    }

    public HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public Multimap<String, String> getHeader() {
        return this.header;
    }

    public String getRequestBody() {
        return this.requestBody;
    }


    public static class Builder{

        private String uri;
        private HttpMethod httpMethod;
        private Multimap<String, String> header;
        private String requestBody;

        public Builder withUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder withHttpMethod(HttpMethod httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }

        public Builder withHeader(String key, String value) {
            this.header = HashMultimap.create();
            this.header.put(key,value);
            return this;
        }

        public Builder withRequestBody(String requestBody) {
            this.requestBody = requestBody;
            return this;
        }

        public Request build(){
            Request request = new Request(this);
            return request;
        }

    }

}
