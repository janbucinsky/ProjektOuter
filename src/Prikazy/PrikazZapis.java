package Prikazy;

import Hra.Hrac;

public class PrikazZapis implements IPrikaz {
    private Hrac hrac;

    public PrikazZapis(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public String proved(String[] parametry) {
        return "Nalezená písmena hesla: " + hrac.getNalezenaPismena();
    }

    @Override
    public String getJmeno() {
        return "sifra";
    }
}
