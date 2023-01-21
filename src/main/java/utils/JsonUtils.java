package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class JsonUtils {

    public static Map<String,String> getJsonDataAsMap(String filepath) throws IOException {

         ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(new File(filepath),new TypeReference<>(){});

    }

}
