import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import restApi.HttpClient;

public class BaseTest {

    HttpClient httpClient = new HttpClient();

    protected JsonNode getJsonObj(String responseString) {
        JsonNode jsonNode = null;
        ObjectMapper objMapper = new ObjectMapper();
        try {
            jsonNode = objMapper.readTree(responseString);
        } catch (Exception e) {
            
        }
        return jsonNode;
    }


}
