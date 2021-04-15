import com.fasterxml.jackson.databind.JsonNode;
import org.testng.Assert;
import org.testng.annotations.Test;
import restApi.request.HttpMethod;
import restApi.request.Request;
import restApi.response.Response;

public class MyTest extends BaseTest {

    @Test
    public void testGet(){

        Request request =  new Request.Builder()
                .withUri("https://reqres.in/api/users?page=1")
                .withHttpMethod(HttpMethod.GET)
                .build();

        Response response = httpClient.execute(request);

        Assert.assertEquals(response.getStatusCode(),200);
        JsonNode jsonNode = this.getJsonObj(response.getResponseBody());
        Assert.assertEquals(jsonNode.path("data").path(3).path("id").asInt(),
                4);
        Assert.assertEquals(jsonNode.path("data").path(3).path("email").asText(),
                "eve.holt@reqres.in");
        Assert.assertEquals(jsonNode.path("data").path(3).path("first_name").asText(),
                "Eve");
        Assert.assertEquals(jsonNode.path("data").path(3).path("last_name").asText(),
                "Holt");

    }

    @Test
    public void testPost(){
        Request request =  new Request.Builder()
                .withUri("https://reqres.in/api/users")
                .withHttpMethod(HttpMethod.POST)
                .withHeader("Content-Type", "application/json")
                .withRequestBody("{\r\n    \"name\": \"Shaehb\",\r\n    \"job\": \"Qa Director\"\r\n}")
                .build();

        Response response = httpClient.execute(request);
        Assert.assertEquals(response.getStatusCode(),201);
        JsonNode jsonNode = this.getJsonObj(response.getResponseBody());
        Assert.assertEquals(jsonNode.path("name").asText(), "Shaehb");
        Assert.assertEquals(jsonNode.path("job").asText(), "Qa Director");
        System.out.println(jsonNode.path("id").asInt());

    }

    @Test
    public void testPut(){
        Request request =  new Request.Builder()
                .withUri("https://reqres.in/api/users/303")
                .withHeader("Content-Type", "application/json")
                .withHttpMethod(HttpMethod.PUT)
                .withRequestBody("{\r\n    \"name\": \"Shaehb\",\r\n    \"job\": \"QA Lead 1\"\r\n}")
                .build();

        Response response = httpClient.execute(request);

        Assert.assertEquals(response.getStatusCode(),200);
        JsonNode jsonNode = this.getJsonObj(response.getResponseBody());
        Assert.assertEquals(jsonNode.path("name").asText(), "Shaehb");
        Assert.assertEquals(jsonNode.path("job").asText(), "QA Lead 1");

    }

    @Test
    public void testDelete(){
        Request request =  new Request.Builder()
                .withUri("https://reqres.in/api/users/7")
                .withHttpMethod(HttpMethod.DELETE)
                .build();

        Response response = httpClient.execute(request);

        Assert.assertEquals(response.getStatusCode(),204);

    }




}
