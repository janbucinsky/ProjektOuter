package Hra;

import java.util.HashMap;
import java.util.Map;

public class Inventar {

    private Map<String, Predmet> veci;
    private int kapacita;

    public Inventar(int kapacita) {
        this.kapacita = kapacita;
        veci = new HashMap<>();
    }

    public boolean vlozPredmet(Predmet predmet) {
        if (veci.size() < kapacita) {
            veci.put(predmet.getName().toLowerCase(), predmet);
            return true;
        }
        return false;
    }

    public Predmet vyberPredmet(String nazev) {
        String klic = nazev.toLowerCase().trim();
        if (veci.containsKey(klic)) {
            return veci.remove(klic);
        }
        return null; // Predmet neni v inventari
    }

    public Predmet getPredmet(String nazev) {
        return veci.get(nazev.toLowerCase().trim());
    }

    public boolean obsahujePredmet(String nazev) {
        return veci.containsKey(nazev.toLowerCase().trim());
    }

    public String getSeznamVeci() {
        if (veci.isEmpty()) {
            return "Inventář je prázdný.";
        }
        String seznam = "V inventáři máš: ";
        for (String jmeno : veci.keySet()) {
            seznam += jmeno + " ";
        }
        return seznam;
    }

    public boolean jePlny() {
        return veci.size() >= kapacita;
    }

    public int getPocetVeci() {
        return veci.size();
    }

    public int getKapacita() {
        return kapacita;
    }
}
