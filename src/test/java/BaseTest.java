import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTest {

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
