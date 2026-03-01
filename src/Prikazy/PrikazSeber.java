package Prikazy;

import Hra.Hrac;
import Hra.Predmet;
import Hra.Lokace;

/**
 * Příkaz pro sebrání předmětu z lokace.
 * 
 * @author janbucinsky
 */
public class PrikazSeber implements IPrikaz {
    private Hrac hrac;

    public PrikazSeber(Hrac hrac) {
        this.hrac = hrac;
    }

    /**
     * Provede sebrání předmětu z aktuální lokace a jeho vložení do inventáře.
     * Kontroluje, zda předmět v lokaci existuje a zda má hráč volné místo v
     * inventáři.
     * 
     * @param parametry parametry[1] je název nebo ID předmětu k sebrání
     * @return výsledek akce (potvrzení sebrání nebo chybová zpráva)
     */
    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 2) {
            return "Co mám sebrat?";
        }

        String jmenoPredmetu = parametry[1].trim();
        Lokace aktualniLokace = hrac.getAktualniLokace();

        Predmet predmet = aktualniLokace.seberPredmet(jmenoPredmetu);
        if (predmet != null) {
            if (hrac.seberPredmet(predmet)) {
                return "Sebral jsi " + predmet.getName();
            } else {
                aktualniLokace.vlozPredmet(predmet); // vratime zpatky
                return "Tvůj batoh je plný!";
            }
        } else {
            return "To tu není.";
        }
    }

    /**
     * @return klíčové slovo "seber"
     */
    @Override
    public String getJmeno() {
        return "seber";
    }
}