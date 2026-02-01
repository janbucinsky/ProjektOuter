package Prikazy;

import java.util.HashMap;
import java.util.Map;


public class SeznamPrikazu {

    private Map<String, IPrikaz> mapaPrikazu;

    public SeznamPrikazu() {
        mapaPrikazu = new HashMap<>();
    }

    public void vlozPrikaz(IPrikaz prikaz) {
        mapaPrikazu.put(prikaz.getJmeno(), prikaz);
    }

    public IPrikaz vratPrikaz(String retezec) {
        if (mapaPrikazu.containsKey(retezec)) {
            return mapaPrikazu.get(retezec);
        }
        return null;
    }

    public boolean jePlatnyPrikaz(String retezec) {
        return mapaPrikazu.containsKey(retezec);
    }


    public String vratNazvyPrikazu() {
        String seznam = "";
        for (String slovoPrikazu : mapaPrikazu.keySet()) {
            seznam += slovoPrikazu + " ";
        }
        return seznam;
    }
}
