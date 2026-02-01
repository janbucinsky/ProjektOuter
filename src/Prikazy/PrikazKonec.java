package Prikazy;

import Hra.Hra;

public class PrikazKonec implements IPrikaz {

    private Hra hra;

    public PrikazKonec(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length > 1) {
            return "Příkaz konec nemá parametry.";
        }
        hra.setKonecHry(true);
        return "Hra ukončena.";
    }

    @Override
    public String getJmeno() {
        return "konec";
    }
}
