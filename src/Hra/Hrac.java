package Hra;

import java.util.ArrayList;

public class Hrac {
    private Lokace aktualniLokace;
    private ArrayList<Predmet> inventar = new ArrayList<>();
    private final int KAPACITA = 2;

    public Hrac(Lokace startovniLokace) {
        this.aktualniLokace = startovniLokace;
    }

    public boolean seberPredmet(Predmet predmet) {
        if (inventar.size() < KAPACITA) {
            inventar.add(predmet);
            return true;
        }
        return false;
    }

    public void vyhodPredmet(Predmet predmet) {
        inventar.remove(predmet);
    }

    public Lokace getAktualniLokace() { return aktualniLokace; }
    public void setAktualniLokace(Lokace lokace) { this.aktualniLokace = lokace; }
    public ArrayList<Predmet> getInventar() { return inventar; }
}