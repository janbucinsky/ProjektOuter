package Prikazy;

import Hra.Hra;
import Hra.Hrac;
import Hra.Lokace;

public class PrikazOdpovez implements IPrikaz {
    private Hrac hrac;

    public PrikazOdpovez(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 3) {
            return "Komu a co mám odpovědět? (Např. 'odpovez Heyward A')";
        }

        String jmenoPostavy = parametry[1];
        String odpoved = parametry[2].toUpperCase();
        Lokace aktualni = hrac.getAktualniLokace();

        if (!aktualni.obsahujePostavu(jmenoPostavy)) {
            return "Postava " + jmenoPostavy + " tu není.";
        }


        switch (jmenoPostavy.toLowerCase()) {
            case "heyward":
                if (odpoved.equals("A")) {
                    hrac.pridejPismeno("M");
                    return "Heyward: 'Správná volba. První písmenko hesla je M.' (Písmeno M bylo zapsáno)";
                }
                return "Heyward: 'Tak si trhni. Nic ti neřeknu.'";

            // TODO: dodelat dialogy pro dalsi osoby

            default:
                return "jeste neni dodelany dialog";
        }
    }

    @Override
    public String getJmeno() {
        return "odpovez";
    }
}