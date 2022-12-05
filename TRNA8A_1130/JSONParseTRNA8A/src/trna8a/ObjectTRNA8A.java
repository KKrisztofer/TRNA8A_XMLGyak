package trna8a;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ObjectTRNA8A {
    public static void main() {
        JSONObject obj = new JSONObject();

		JSONParser parser = new JSONParser();

		try (Reader reader = new FileReader("JSONTRNA8A.json")) {

	        JSONObject jsonObject = (JSONObject) parser.parse(reader);

	        obj.put("student", jsonObject.get("student"));

	        String jsonText = obj.toString();
	        System.out.println(jsonText);

	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

        Jobj.put("neptunkod", "kkklll");
        Jobj.put("hallgato", "hallgato neve");
        Jobj.put("szak", "PTI");
        System.out.println(Jobj);

    }
}
