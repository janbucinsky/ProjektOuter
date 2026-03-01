package Hra;

import java.util.ArrayList;

/**
 * Třída Lokace představuje jeden prostor (místnost, oblast) v herním světě.
 * Každá lokace má svůj název, popis, sousedy, předměty a postavy.
 * 
 * @author janbucinsky
 */
public class Lokace {
    private String id;
    private String name;
    private String description;
    private ArrayList<String> neighbors;
    private ArrayList<Lokace> sousede = new ArrayList<>();
    private ArrayList<Predmet> predmety = new ArrayList<>();
    private ArrayList<Postava> postavy = new ArrayList<>();

    /**
     * Konstruktor vytvoření lokace (na testování).
     * 
     * @param id          unikátní ID lokace
     * @param name        zobrazitelný název
     * @param description detailní popis
     */
    public Lokace(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Bezparametrický konstruktor pro potřeby GSONu.
     */
    public Lokace() {
    }

    /**
     * @return unikátní ID lokace
     */
    public String getId() {
        return id;
    }

    /**
     * @return zobrazitelný název lokace
     */
    public String getName() {
        return name;
    }

    /**
     * @return dlouhý popis lokace
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return seznam ID sousedních lokací (z JSONu)
     */
    public ArrayList<String> getNeighborIds() {
        return neighbors;
    }

    /**
     * Přidá sousední lokaci k této lokaci.
     * 
     * @param soused sousední lokace
     */
    public void pridejSouseda(Lokace soused) {
        sousede.add(soused);
    }

    /**
     * @return seznam instancí sousedních lokací
     */
    public ArrayList<Lokace> getSousede() {
        return sousede;
    }

    /**
     * Vloží předmět do této lokace.
     * 
     * @param predmet předmět k vložení
     */
    public void vlozPredmet(Predmet predmet) {
        predmety.add(predmet);
    }

    /**
     * Vyjme (sebere) předmět z lokace.
     * 
     * @param nazevPredmetu název nebo ID předmětu
     * @return vyjmutý předmět nebo null
     */
    public Predmet seberPredmet(String nazevPredmetu) {
        for (Predmet p : predmety) {
            if (p.getName().equalsIgnoreCase(nazevPredmetu) || p.getId().equalsIgnoreCase(nazevPredmetu)) {
                predmety.remove(p);
                return p;
            }
        }
        return null;
    }

    /**
     * Zjistí, zda se v lokaci nachází daný předmět.
     * 
     * @param nazevPredmetu název nebo ID předmětu
     * @return true, pokud tu je
     */
    public boolean obsahujePredmet(String nazevPredmetu) {
        for (Predmet p : predmety) {
            if (p.getName().equalsIgnoreCase(nazevPredmetu) || p.getId().equalsIgnoreCase(nazevPredmetu)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return textový seznam předmětů v lokaci
     */
    public String getSeznamPredmetu() {
        if (predmety.isEmpty()) {
            return "nic";
        }
        StringBuilder seznam = new StringBuilder();
        for (int i = 0; i < predmety.size(); i++) {
            seznam.append(predmety.get(i).getName());
            if (i < predmety.size() - 1) {
                seznam.append(", ");
            }
        }
        return seznam.toString();
    }

    /**
     * @return textový seznam postav v lokaci
     */
    public String getSeznamPostav() {
        if (postavy.isEmpty()) {
            return "nikdo";
        }
        StringBuilder seznam = new StringBuilder();
        for (int i = 0; i < postavy.size(); i++) {
            seznam.append(postavy.get(i).getName());
            if (i < postavy.size() - 1) {
                seznam.append(", ");
            }
        }
        return seznam.toString();
    }

    /**
     * Vloží postavu do lokace.
     * 
     * @param postava postava k přidání
     */
    public void vlozPostavu(Postava postava) {
        postavy.add(postava);
    }

    /**
     * Vrátí postavu podle jména nebo ID.
     * 
     * @param jmeno jméno nebo ID hledané postavy
     * @return nalezená postava nebo null
     */
    public Postava getPostava(String jmeno) {
        for (Postava p : postavy) {
            if (p.getJmeno().equalsIgnoreCase(jmeno) || (p.getId() != null && p.getId().equalsIgnoreCase(jmeno))) {
                return p;
            }
        }
        return null;
    }

    /**
     * Zjistí, zda je postava v lokaci.
     * 
     * @param jmeno jméno nebo ID postavy
     * @return true, pokud tu je
     */
    public boolean obsahujePostavu(String jmeno) {
        return getPostava(jmeno) != null;
    }
}