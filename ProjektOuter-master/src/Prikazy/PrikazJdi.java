package Prikazy;

import Hra.Hrac;
import Hra.Lokace;

public class PrikazJdi extends Prikazy {
    private Hrac hrac;

    public PrikazJdi(Hrac hrac) {
        this.hrac = hrac;
    }

    public String proved(String kam) {
        if (kam.isEmpty()) {
            return "Musíš napsat, kam chceš jít.";
        }

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
            hrac.setAktualniLokace(cilova);
            return "Jsi v: " + cilova.getName() + "\n" + cilova.getDescription();
        } else {
            return "Tudy se odsud nedostaneš. Pořád jsi v: " + aktualni.getName();
        }
    }
}