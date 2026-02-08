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
            veci.put(predmet.getId().toLowerCase(), predmet); // Changed key to ID
            return true;
        }
        return false;
    }

    public Predmet vyberPredmet(String nazev) {
        // Try ID first
        if (veci.containsKey(nazev.toLowerCase())) {
            return veci.remove(nazev.toLowerCase());
        }

        // Try searching by name
        for (Predmet p : veci.values()) {
            if (p.getName().equalsIgnoreCase(nazev)) {
                veci.remove(p.getId().toLowerCase());
                return p;
            }
        }
        return null;
    }

    public Predmet getPredmet(String nazev) {
        // Try ID first
        if (veci.containsKey(nazev.toLowerCase())) {
            return veci.get(nazev.toLowerCase());
        }

        // Try searching by name
        for (Predmet p : veci.values()) {
            if (p.getName().equalsIgnoreCase(nazev)) {
                return p;
            }
        }
        return null;
    }

    public boolean obsahujePredmet(String nazev) {
        return getPredmet(nazev) != null;
    }

    public String getSeznamVeci() {
        if (veci.isEmpty()) {
            return "Inventář je prázdný.";
        }
        String seznam = "V inventáři máš: ";
        int count = 0;
        for (Predmet p : veci.values()) {
            seznam += p.getName();
            if (count < veci.size() - 1) {
                seznam += ", ";
            }
            count++;
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
