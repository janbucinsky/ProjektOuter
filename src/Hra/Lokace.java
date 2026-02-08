package Hra;

import java.util.ArrayList;

public class Lokace {
    private String id;
    private String name;
    private String description;
    private ArrayList<String> neighbors;
    private ArrayList<Lokace> sousede = new ArrayList<>();
    private ArrayList<Predmet> predmety = new ArrayList<>();
    private ArrayList<Postava> postavy = new ArrayList<>();

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public ArrayList<String> getNeighborIds() {
        return neighbors;
    }
    public void pridejSouseda(Lokace soused) {
        sousede.add(soused);
    }
    public ArrayList<Lokace> getSousede() {
        return sousede;
    }
    public void vlozPredmet(Predmet predmet) {
        predmety.add(predmet);
    }

    public Predmet seberPredmet(String nazevPredmetu) {
        for (Predmet p : predmety) {
            if (p.getName().equalsIgnoreCase(nazevPredmetu) || p.getId().equalsIgnoreCase(nazevPredmetu)) {
                predmety.remove(p);
                return p;
            }
        }
        return null;
    }

    public boolean obsahujePredmet(String nazevPredmetu) {
        for (Predmet p : predmety) {
            if (p.getName().equalsIgnoreCase(nazevPredmetu) || p.getId().equalsIgnoreCase(nazevPredmetu)) {
                return true;
            }
        }
        return false;
    }

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

    public void vlozPostavu(Postava postava) {
        postavy.add(postava);
    }

    public Postava getPostava(String jmeno) {
        for (Postava p : postavy) {
            if (p.getJmeno().equalsIgnoreCase(jmeno) || (p.getId() != null && p.getId().equalsIgnoreCase(jmeno))) {
                return p;
            }
        }
        return null;
    }

    public boolean obsahujePostavu(String jmeno) {
        return getPostava(jmeno) != null;
    }
}