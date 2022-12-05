package trna8a;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ListTRNA8A {
    public static void main() {

        JSONObject obj = new JSONObject();

        Jobj.put("neptunkod", "kkklll");
        Jobj.put("hallgato", "hallgato neve");

        JSONArray list = new JSONArray();
        list.add("PTI");
        list.add("Mérnökinformatika");
        list.add("-");

        obj.put("szak", list);

        String jsonText = obj.toString();
        System.out.println(jsonText);
    }
}
