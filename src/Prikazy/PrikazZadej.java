package Prikazy;

import Hra.Hra;
import Hra.Hrac;
import Hra.Lokace;

public class PrikazZadej implements IPrikaz {
    private Hra hra;
    private Hrac hrac;

    public PrikazZadej(Hra hra, Hrac hrac) {
        this.hra = hra;
        this.hrac = hrac;
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 2) {
            return "Co mám zadat?";
        }

        Lokace aktualni = hrac.getAktualniLokace();
        if (!aktualni.getId().equals("old_well")) {
            return "Tady není kam co zadávat.";
        }

        String heslo = parametry[1].trim();
        if (heslo.equalsIgnoreCase("MERCHANT")) {
            hra.vyhra();
            return "Zadal jsi správné heslo! Poklad je tvůj!";
        } else {
            return "Špatné heslo! Zkus to znovu";
        }
    }

    @Override
    public String getJmeno() {
        return "zadej";
    }
}
