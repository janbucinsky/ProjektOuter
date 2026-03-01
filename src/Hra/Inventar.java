package Hra;

import java.util.HashMap;
import java.util.Map;

/**
 * Třída Inventar reprezentuje úložný prostor pro předměty (např. batoh hráče).
 * Má omezenou kapacitu a umožňuje vkládání, vybírání a prohledávání předmětů.
 * 
 * @author janbucinsky
 */
public class Inventar {

    private Map<String, Predmet> veci;
    private int kapacita;

    /**
     * @return aktuální počet věcí v inventáři
     */

    public int getPocetVeci() {
        return veci.size();
    }

    /**
     * @return maximální kapacita inventáře
     */
    public int getKapacita() {
        return kapacita;
    }

    /**
     * Konstruktor inventáře.
     * 
     * @param kapacita maximální počet předmětů, které lze uložit
     */
    public Inventar(int kapacita) {
        this.kapacita = kapacita;
        veci = new HashMap<>();
    }

    /**
     * Vloží předmět do inventáře, pokud je v něm místo.
     * 
     * @param predmet předmět k vložení
     * @return true, pokud se předmět podařilo uložit, false pokud je plno
     */
    public boolean vlozPredmet(Predmet predmet) {
        if (veci.size() < kapacita) {
            veci.put(predmet.getId().toLowerCase(), predmet); // Changed key to ID
            return true;
        }
        return false;
    }

    /**
     * Vyjme předmět z inventáře podle jeho názvu nebo ID a vrátí ho.
     * 
     * @param nazev název nebo ID hledaného předmětu
     * @return vyjmutý předmět nebo null, pokud se v inventáři nenachází
     */
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

    /**
     * Zjistí, zda se předmět nachází v inventáři.
     * 
     * @param nazev název nebo ID předmětu
     * @return true, pokud jej hráč má
     */
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
}
