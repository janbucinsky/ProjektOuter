package Prikazy;

import Hra.Hrac;
import Hra.Predmet;
import Hra.Lokace;

public class PrikazSeber implements IPrikaz {
    private Hrac hrac;

    public PrikazSeber(Hrac hrac) {
        this.hrac = hrac;
    }

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

    @Override
    public String getJmeno() {
        return "seber";
    }
}