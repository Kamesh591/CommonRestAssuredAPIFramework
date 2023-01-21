package application.payloads;

import java.util.HashMap;
import java.util.Map;

public class Payload {


    public static String createAirlinePayload(int id, String airlineName, String country, String logo, String slogan, String headQuarters, String website, int established) {



       /*String sample= "   \"name\":"+airlineName+ ",\n";


        String samplePayload="{" +
                "\"james\":";
*/

        return "{\n" +
                "    \"id\":" + id + ",\n" +
                "    \"name\":\"" + airlineName + "\",\n" +
                "    \"country\":\"" + country + "\",\n" +
                "    \"logo\":\"" + logo + "\",\n" +
                "    \"slogan\":\"" + slogan + "\",\n" +
                "    \"head_quaters\":\"" + headQuarters + "\",\n" +
                "    \"website\":\"" + website + "\",\n" +
                "    \"established\":" + established + "\n" +
                "}";


    }


    public static Map<String, Object> createAirlinePayload(String id, String airlineName, String country, String logo, String slogan, String headQuarters, String website, String established) {



       /*String sample= "   \"name\":"+airlineName+ ",\n";


        String samplePayload="{" +
                "\"james\":";

*/
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", id);
        payload.put("name", airlineName);
        payload.put("name", airlineName);
        payload.put("country", country);
        payload.put("logo", logo);
        payload.put("slogan", slogan);
        payload.put("head_quaters", headQuarters);
        payload.put("website", website);
        payload.put("established", established);

        return payload;


    }
}
