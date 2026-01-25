package Hra;

import java.util.ArrayList;

public class Lokace {
    private String id;
    private String name;
    private String description;
    private ArrayList<String> neighbors;
    private ArrayList<Lokace> sousede = new ArrayList<>();
    private ArrayList<Predmet> predmety = new ArrayList<>();

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public ArrayList<String> getNeighborIds() { return neighbors; }

    public void pridejSouseda(Lokace soused) {
        sousede.add(soused);
    }

    public ArrayList<Lokace> getSousede() {
        return sousede;
    }
}