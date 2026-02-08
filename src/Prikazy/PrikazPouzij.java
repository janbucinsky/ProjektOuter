package Prikazy;

import Hra.Hrac;
import Hra.Lokace;
import Hra.Predmet;

public class PrikazPouzij implements IPrikaz {
    private Hrac hrac;

    public PrikazPouzij(Hrac hrac) {
        this.hrac = hrac;
    }

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
            case "listek_na_privoz":
                if (aktualniLokace.getId().equals("ferry_crossing")) {
                    return "dopsat";
                }
                return "dopsat";
            case "zlaty_nuget":
                if (aktualniLokace.getId().equals("figure_eight")) {
                    return "dopsat";
                }
                return "dopsat";
            default:
                return "dopsat";
        }
    }

    @Override
    public String getJmeno() {
        return "pouzij";
    }
}
