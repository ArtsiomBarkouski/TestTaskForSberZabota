import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class JsonParser {

    static JSONParser parser = new JSONParser();
    static boolean success;
    static JSONArray detectives;
    static String detectivesInformation;

    public static void getSuccess() {
        try {
            Object obj = parser.parse(new FileReader("result.json"));
            JSONObject rootObject = (JSONObject) obj;
            success = (boolean) rootObject.get("success");
        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }
    }

    public static void getDetectivesArray () {
        try {
            Object obj = parser.parse(new FileReader("result.json"));
            JSONObject rootObject = (JSONObject) obj;
            detectives = (JSONArray) rootObject.get("detectives");
            detectivesInformation =  rootObject.get("detectives").toString();
        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }
    }
}