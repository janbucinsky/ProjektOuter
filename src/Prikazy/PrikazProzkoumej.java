package Prikazy;

import Hra.Hrac;
import Hra.Lokace;
import Hra.Predmet;

/**
 * Příkaz pro prozkoumání okolí nebo konkrétního předmětu v lokaci.
 */
public class PrikazProzkoumej implements IPrikaz {
    private Hrac hrac;

    /**
     * Konstruktor příkazu.
     * 
     * @param hrac aktuální hráč
     */
    public PrikazProzkoumej(Hrac hrac) {
        this.hrac = hrac;
    }

    /**
     * Prozkoumá buď celou lokaci (pokud není parametr) nebo konkrétní předmět v ní.
     * 
     * @param parametry volitelný parametr[1] je název předmětu
     * @return popis lokace s předměty nebo potvrzení viditelnosti předmětu
     */
    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 2) {
            Lokace aktualniLokace = hrac.getAktualniLokace();
            return "Jsi v " + aktualniLokace.getName() + ".\n"
                    + "Předměty: " + aktualniLokace.getSeznamPredmetu();
        }

        String nazev = parametry[1].trim();
        Lokace aktualniLokace = hrac.getAktualniLokace();

        if (aktualniLokace.obsahujePredmet(nazev)) {
            return "Vidíš " + nazev + ".";
        }

        return "To tu nevidím.";
    }

    /**
     * @return klíčové slovo "prozkoumej"
     */
    @Override
    public String getJmeno() {
        return "prozkoumej";
    }
}
