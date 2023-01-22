package airlines;

import utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class Base {

    static {
        String env=System.getProperty("env")==null ? "qa" : System.getProperty("env");
        String path="src/test/resources/airlines.dev/airlinesApiData.json";
        Map<String,String> configs= null;
        try {
            configs = JsonUtils.getJsonDataAsMap(System.getProperty("user.dir")+"/"+path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(configs.get("createAirlineEndpoint"));
    }
}
