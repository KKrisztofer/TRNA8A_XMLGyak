package trna8a;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONWriteTRNA8A {
    public static void main() {
        JSONObject root = new JSONObject();

        root.put("_id", "TRNA8A");
        root.put("name", "vizsgak");

        JSONObject vizsgak = new JSONObject();
        JSONArray vizsga = new JSONArray();

        JSONObject vizsga1 = new JSONObject();
        vizsga1.put("kurzus", "Analízis");
        vizsga1.put("helyszin", "E12");

        JSONObject idopont1 = new JSONObject();
        idopont1.put("nap", "2022.06.06");
        idopont1.put("tol", "10");
        idopont1.put("ig", "14");

        vizsga1.put("idopont", idopont1);
        vizsga1.put("oktato", "Szilágyi Szilvia");
        vizsga1.put("jegy", "2");

        vizsga.add(vizsga1);

        JSONObject vizsga2 = new JSONObject();
        vizsga2.put("kurzus", "Biztonság és védelem a számítástechnikában");
        vizsga2.put("helyszin", "L103");

        JSONObject idopont2 = new JSONObject();
        idopont2.put("nap", "2022.06.16");
        idopont2.put("tol", "11");
        idopont2.put("ig", "13");

        vizsga2.put("idopont", idopont2);
        vizsga2.put("oktato", "Wagner György");
        vizsga2.put("jegy", "4");

        vizsga.add(vizsga2);

        vizsgak.put("vizsga", vizsga);
        root.put("vizsgak", vizsgak);

        String jsonText = root.toString();
        System.out.println(jsonText);

        try {

            FileWriter file = new FileWriter("vizsgakTRNA8A_out.json");
            file.write(jsonText);
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
