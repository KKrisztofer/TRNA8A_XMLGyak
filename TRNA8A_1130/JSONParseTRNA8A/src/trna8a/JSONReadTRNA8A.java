package trna8a;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReadTRNA8A {
    public static void main() {
        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("vizsgakTRNA8A.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            obj.put("root", jsonObject.get("root"));

            String jsonText = obj.toString();
            System.out.println(jsonText);


        } catch (IOException |  ParseException e) {
            e.printStackTrace();
        }
    }
}
