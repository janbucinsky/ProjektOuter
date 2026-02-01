package Prikazy;

import Hra.Hrac;
import Hra.Lokace;
import Hra.Predmet;

public class PrikazProzkoumej implements IPrikaz {
    private Hrac hrac;

    public PrikazProzkoumej(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 2) {
            Lokace aktualniLokace = hrac.getAktualniLokace();
            return "Jsi v lokaci " + aktualniLokace.getName() + ".\n"
                    + aktualniLokace.getDescription() + "\n"
                    + "Předměty: " + aktualniLokace.getSeznamPredmetu();
        }

        String nazev = parametry[1].trim();
        Lokace aktualniLokace = hrac.getAktualniLokace();

        if (aktualniLokace.obsahujePredmet(nazev)) {
            return "Vidíš " + nazev + ".";
        }

        return "To tu nevidím.";
    }

    @Override
    public String getJmeno() {
        return "prozkoumej";
    }
}
