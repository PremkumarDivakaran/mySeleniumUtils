package restApi.response;

import com.google.common.collect.Multimap;

public class Response {

    private int statusCode;
    private String responseBody;
    private Multimap<String, String> responseHeader;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public Multimap<String, String> getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(Multimap<String, String> responseHeader) {
        this.responseHeader = responseHeader;
    }
}
