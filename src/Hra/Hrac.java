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

    private boolean prevozPouzit = false;

    public boolean isPrevozPouzit() {
        return prevozPouzit;
    }

    public void setPrevozPouzit(boolean pouzit) {
        this.prevozPouzit = pouzit;
    }

    private int wardDialogueStage = 0;
    private boolean wardPorazen = false;

    public int getWardDialogueStage() {
        return wardDialogueStage;
    }

    public void setWardDialogueStage(int stage) {
        this.wardDialogueStage = stage;
    }

    public boolean isWardPorazen() {
        return wardPorazen;
    }

    public void setWardPorazen(boolean porazen) {
        this.wardPorazen = porazen;
    }

    private java.util.List<String> nalezenaPismena = new java.util.ArrayList<>();

    public void pridejPismeno(String pismeno) {
        if (!nalezenaPismena.contains(pismeno)) {
            nalezenaPismena.add(pismeno);
        }
    }

    public String getNalezenaPismena() {
        if (nalezenaPismena.isEmpty()) {
            return "Zatím jsi neobjevil žádná písmena.";
        }
        return String.join(", ", nalezenaPismena);
    }
}