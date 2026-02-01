package Hra;

public class Hrac {
    private Lokace aktualniLokace;
    private Inventar inventar;

    public Hrac(Lokace startovniLokace) {
        this.aktualniLokace = startovniLokace;
        this.inventar = new Inventar(2);
    }



    public boolean seberPredmet(Predmet predmet) {
        return inventar.vlozPredmet(predmet);
    }


    public Inventar getInventar() {
        return inventar;
    }

    public Lokace getAktualniLokace() {
        return aktualniLokace;
    }



    public void setAktualniLokace(Lokace lokace) {
        this.aktualniLokace = lokace;
    }
}