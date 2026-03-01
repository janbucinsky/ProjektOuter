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
            return "Musíš napsat, kam chceš jít. např: jdi cut_harbor";
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
            String zpravaOListku = "";

            if (cilova.getId().equals("figure_eight")) {
                if (!hrac.isPrevozPouzit()) {
                    if (hrac.getInventar().getPredmet("listek") == null) {
                        return "Prevoznik te nechce pustit na druhou stranu, potrebujes listek (ten se nachází skoro na začatku, v cut_harbor).";
                    } else {
                        hrac.getInventar().vyberPredmet("listek");
                        hrac.setPrevozPouzit(true);
                        zpravaOListku = "(Využil jsi lístek na přívoz k přejezdu do Figure Eight. Byl odebrán z tvého inventáře. Teď už můžeš cestovat volně.)\n";
                    }
                }
            }

            if (cilova.getId().equals("old_well")) {
                if (hrac.getInventar().getPredmet("baterka") == null) {
                    return "V kryptě je úplná tma! Bez baterky (kterou má Kiara) se dál nedostaneš.";
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

            return zpravaOListku + "Jsi v: " + cilova.getName() + ".\n" + cilova.getDescription() + "\n"
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