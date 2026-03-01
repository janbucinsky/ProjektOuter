package Prikazy;

import java.util.HashMap;
import java.util.Map;

/**
 * Třída SeznamPrikazu udržuje mapu všech platných příkazů ve hře.
 */
public class SeznamPrikazu {

    private Map<String, IPrikaz> mapaPrikazu;

    /**
     * Konstruktor seznamu příkazů.
     */
    public SeznamPrikazu() {
        mapaPrikazu = new HashMap<>();
    }

    public void vlozPrikaz(IPrikaz prikaz) {
        mapaPrikazu.put(prikaz.getJmeno(), prikaz);
    }

    /**
     * Vrátí instanci příkazu podle jeho názvu.
     * 
     * @param retezec název příkazu
     * @return nalezený příkaz nebo null
     */
    public IPrikaz vratPrikaz(String retezec) {
        if (mapaPrikazu.containsKey(retezec)) {
            return mapaPrikazu.get(retezec);
        }
        return null;
    }

    /**
     * Zkontroluje, zda je zadaný řetězec platným názvem příkazu.
     * 
     * @param retezec název příkazu k ověření
     * @return true, pokud příkaz existuje
     */
    public boolean jePlatnyPrikaz(String retezec) {
        return mapaPrikazu.containsKey(retezec);
    }

    /**
     * Vrátí řetězec obsahující názvy všech platných příkazů oddělené mezerou.
     * 
     * @return seznam názvů příkazů
     */
    public String vratNazvyPrikazu() {
        String seznam = "";
        for (String slovoPrikazu : mapaPrikazu.keySet()) {
            seznam += slovoPrikazu + " ";
        }
        return seznam;
    }
}
