package airlines;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import application.payloads.Payload;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AirlinesTest {

    @Test
    public void createAirline(){
       Response response= RestAssured.given().log().all()
                .baseUri("https://api.instantwebtools.net/v1/airlines")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\": 4235423,\n" +
                        "    \"name\": \"Sri Lankan Airways\",\n" +
                        "    \"country\": \"Sri Lanka\",\n" +
                        "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                        "    \"slogan\": \"From Sri Lanka\",\n" +
                        "    \"head_quaters\": \"Katunayake, Sri Lanka\",\n" +
                        "    \"website\": \"www.srilankaairways.com\",\n" +
                        "    \"established\": \"1990\"\n" +
                        "}")
                .post()
                .then().log().all().extract().response();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void createAirlineWithOptimizeCode(){
        String baseURI="https://api.instantwebtools.net/v1/airlines";
        String requestBody="{\n" +
                "    \"id\": 423403,\n" +
                "    \"name\": \"Sri Lankan Airways\",\n" +
                "    \"country\": \"Sri Lanka\",\n" +
                "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                "    \"slogan\": \"From Sri Lanka\",\n" +
                "    \"head_quaters\": \"Katunayake, Sri Lanka\",\n" +
                "    \"website\": \"www.srilankaairways.com\",\n" +
                "    \"established\": \"1990\"\n" +
                "}";
        Response response= RestUtils.postPayload(baseURI,requestBody,new HashMap<>());
        Assert.assertEquals(response.getStatusCode(),200);
    }


    @Test
    public void createAirlineWithOutsidePayload(){
        String baseURI="https://api.instantwebtools.net/v1/airlines";
        String requestBody= Payload.createAirlinePayload(2329133,"Sri Lankan Airways","Sri Lanka",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                "From Sri Lanka","Katunayake, Sri Lanka","www.srilankaairways.com",
        1990);
        Response response=RestUtils.postPayload(baseURI,requestBody,null);
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test
    public void createAirlineWithMapPayload(){
        String baseURI="https://api.instantwebtools.net/v1/airlines";
        Map<String,Object> requestBody=Payload.createAirlinePayload("2329233","Sri Lankan Airways","Sri Lanka",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                "From Sri Lanka","Katunayake, Sri Lanka","www.srilankaairways.com",
                "1990");

        Response response= RestUtils.postPayload(baseURI,requestBody,null);
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test
    public void createAirlineWithEnvJson() throws IOException {
        String path="src/test/resources/airlines/dev/airlinesApiData.json";
        Map<String,String> configs= JsonUtils.getJsonDataAsMap(System.getProperty("user.dir")+"/"+path);
        System.out.println(configs.get("createAirlineEndpoint"));
        String baseURI="https://api.instantwebtools.net/v1/airlines";
        Map<String,Object> requestBody=Payload.createAirlinePayload("2329233","Sri Lankan Airways","Sri Lanka",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                "From Sri Lanka","Katunayake, Sri Lanka","www.srilankaairways.com",
                "1990");

        Response response= RestUtils.postPayload(baseURI,requestBody,null);
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
