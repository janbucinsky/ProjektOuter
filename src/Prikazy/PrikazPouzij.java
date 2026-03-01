package Prikazy;

import Hra.Hrac;
import Hra.Lokace;
import Hra.Predmet;

/**
 * Příkaz pro použití předmětu z inventáře.
 * Umožňuje interakci s vybranými předměty v konkrétních lokacích.
 * 
 * @author janbucinsky
 */
public class PrikazPouzij implements IPrikaz {
    private Hrac hrac;

    /**
     * Konstruktor příkazu.
     * 
     * @param hrac aktuální hráč
     */
    public PrikazPouzij(Hrac hrac) {
        this.hrac = hrac;
    }

    /**
     * Provede použití předmětu z inventáře.
     * 
     * @param parametry parametry[1] je název/ID předmětu
     * @return výsledek použití předmětu
     */
    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 2) {
            return "Co chces pouzit?";
        }

        String nazevPredmetu = parametry[1];
        Lokace aktualniLokace = hrac.getAktualniLokace();

        Predmet predmet = hrac.getInventar().getPredmet(nazevPredmetu);
        if (predmet == null) {
            if (aktualniLokace.obsahujePredmet(nazevPredmetu)) {
                return "predmet se ve tve lokaci nachazi, ale jeste si ho nesebral";
            }
            return "tento predmet nemas";
        }

        switch (predmet.getId().toLowerCase()) {
            case "kompas":
                return "dopsat";
            case "baterka":
                if (aktualniLokace.getId().equals("tannyhill_church")) {
                    return "dopsat";
                }
                return "dopsat";
            case "listek":
                if (aktualniLokace.getId().equals("ferry_crossing")) {
                    return "Ukázal jsi lístek. Převozník kývnul: 'Můžeš nastoupit na loď do Figure Eight.'";
                }
                return "Tady lístek nikomu neukazuj. (bude se ti hodit až v ferry_crossing)";
            case "nuget":
                if (aktualniLokace.getId().equals("figure_eight")) {
                    return "dopsat";
                }
                return "Tohle je cenné, ale tady ti to k ničemu není.";
            default:
                return "Nic se nestalo.";
        }
    }

    /**
     * @return klíčové slovo "pouzij"
     */
    @Override
    public String getJmeno() {
        return "pouzij";
    }
}
