package Prikazy;

import Hra.Hrac;
import Hra.Predmet;

/**
 * Příkaz pro vyhození předmětu z inventáře do aktuální lokace.
 * 
 * @author janbucinsky
 */
public class PrikazZahod implements IPrikaz {
    private Hrac hrac;

    public PrikazZahod(Hrac hrac) {
        this.hrac = hrac;
    }

    /**
     * Vyhodí předmět z inventáře do aktuální lokace.
     * 
     * @param parametry parametry[1] je název předmětu k zahození
     * @return potvrzení o zahození nebo chybová zpráva
     */
    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 2) {
            return "Co mám zahodit?";
        }

        String jmenoPredmetu = parametry[1];
        Predmet predmet = hrac.getInventar().vyberPredmet(jmenoPredmetu);

        if (predmet != null) {
            hrac.getAktualniLokace().vlozPredmet(predmet);
            return "Zahodil jsi " + jmenoPredmetu;
        } else {
            return "To nemáš v inventáři.";
        }
    }

    /**
     * @return klíčové slovo "zahod"
     */
    @Override
    public String getJmeno() {
        return "zahod";
    }
}
