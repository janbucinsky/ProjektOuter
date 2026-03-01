package Hra;

/**
 * Třída Hrac reprezentuje hráče v herním světě.
 * Uchovává informace o aktuální lokaci, inventáři, postupu v dialozích a
 * nalezených písmenech.
 */
public class Hrac {
    private Lokace aktualniLokace;
    private Inventar inventar;

    /**
     * Konstruktor hráče.
     * 
     * @param startovniLokace lokace, ve které hráč začíná.
     */

    public Hrac(Lokace startovniLokace) {
        this.aktualniLokace = startovniLokace;
        this.inventar = new Inventar(2);
    }

    /**
     * Pokusí se sebrat předmět a vložit ho do inventáře.
     * 
     * @param predmet předmět k sebrání
     * @return true, pokud byl předmět úspěšně vložen, false pokud je inventář plný
     */
    public boolean seberPredmet(Predmet predmet) {
        return inventar.vlozPredmet(predmet);
    }

    /**
     * @return inventář hráče
     */
    public Inventar getInventar() {
        return inventar;
    }

    /**
     * @return aktuální lokace, kde se hráč nachází
     */
    public Lokace getAktualniLokace() {
        return aktualniLokace;
    }

    /**
     * @param lokace nová lokace pro hráče
     */
    public void setAktualniLokace(Lokace lokace) {
        this.aktualniLokace = lokace;
    }

    private boolean prevozPouzit = false;

    /**
     * @return true, pokud hráč již využil přívoz
     */
    public boolean isPrevozPouzit() {
        return prevozPouzit;
    }

    /**
     * @param pouzit nastaví, zda byl přívoz využit
     */
    public void setPrevozPouzit(boolean pouzit) {
        this.prevozPouzit = pouzit;
    }

    private int wardDialogueStage = 0;
    private boolean wardPorazen = false;

    /**
     * @return aktuální fáze dialogu s Wardem (0-5)
     */
    public int getWardDialogueStage() {
        return wardDialogueStage;
    }

    /**
     * @param stage nastaví fázi dialogu s Wardem
     */
    public void setWardDialogueStage(int stage) {
        this.wardDialogueStage = stage;
    }

    /**
     * @return true, pokud je Ward poražen
     */
    public boolean isWardPorazen() {
        return wardPorazen;
    }

    /**
     * @param porazen nastaví stav porážky Warda
     */
    public void setWardPorazen(boolean porazen) {
        this.wardPorazen = porazen;
    }

    private java.util.List<String> nalezenaPismena = new java.util.ArrayList<>();

    /**
     * Přidá nalezené písmeno do seznamu hráče.
     * 
     * @param pismeno písmeno, které hráč získal
     */
    public void pridejPismeno(String pismeno) {
        if (!nalezenaPismena.contains(pismeno)) {
            nalezenaPismena.add(pismeno);
        }
    }

    /**
     * Vrátí seznam všech nalezených písmen jako řetězec.
     * 
     * @return seznam písmen nebo zpráva, že žádná nenalezl
     */
    public String getNalezenaPismena() {
        if (nalezenaPismena.isEmpty()) {
            return "Zatím jsi neobjevil žádná písmena.";
        }
        return String.join(", ", nalezenaPismena);
    }
}