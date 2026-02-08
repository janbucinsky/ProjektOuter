package Prikazy;

import Hra.Hrac;
import Hra.Lokace;

public class PrikazJdi implements IPrikaz {
    private Hrac hrac;

    public PrikazJdi(Hrac hrac) {

        this.hrac = hrac;
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 2) {
            return "Musíš napsat, kam chceš jít.";
        }

        String kam = parametry[1];

        Lokace aktualni = hrac.getAktualniLokace();
        Lokace cilova = null;

        // je cilova lokace soused?
        for (Lokace soused : aktualni.getSousede()) {
            if (soused.getName().equalsIgnoreCase(kam) || soused.getId().equalsIgnoreCase(kam)) {
                cilova = soused;
                break;
            }
        }

        if (cilova != null) {
            if (cilova.getId().equals("figure_eight")) {
                if (hrac.getInventar().getPredmet("listek_na_privoz") == null) {
                    return "Prevoznik te nechce pustit, potrebujes listek";
                }
            }

            hrac.setAktualniLokace(cilova);
            return "Jsi v: " + cilova.getName() + ".\n" + cilova.getDescription() + "\n" + "Předměty: "
                    + cilova.getSeznamPredmetu();
        } else {
            return "Tudy se odsud nedostaneš. Pořád jsi v: " + aktualni.getName();
        }
    }

    @Override
    public String getJmeno() {
        return "jdi";
    }
}