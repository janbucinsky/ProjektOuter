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
                if (hrac.getInventar().getPredmet("listek") == null) {
                    return "Prevoznik te nechce pustit, potrebujes listek (ten se nachází skoro na začatku, v cut_harbor";
                }
            }

            hrac.setAktualniLokace(cilova);

            String vychody = "Východy: ";

            if (cilova.getNeighborIds() != null) {
                for (int i = 0; i < cilova.getNeighborIds().size(); i++) {
                    vychody += cilova.getNeighborIds().get(i);
                    if (i < cilova.getNeighborIds().size() - 1) {
                        vychody += ", ";
                    }
                }

            }

            return "Jsi v: " + cilova.getName() + ".\n" + cilova.getDescription() + "\n"
                    + "Předměty: " + cilova.getSeznamPredmetu() + "\n"
                    + "Postavy: " + cilova.getSeznamPostav() + "\n"
                    + vychody;
        } else {
            return "Tudy se odsud nedostaneš. Pořád jsi v:" + aktualni.getName();
        }
    }

    @Override
    public String getJmeno() {
        return "jdi";
    }
}