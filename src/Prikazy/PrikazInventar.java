package Prikazy;

import Hra.Hrac;

public class PrikazInventar implements IPrikaz {
    private Hrac hrac;

    public PrikazInventar(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public String proved(String[] parametry) {
        return hrac.getInventar().getSeznamVeci();
    }

    @Override
    public String getJmeno() {
        return "inventar";
    }
}
