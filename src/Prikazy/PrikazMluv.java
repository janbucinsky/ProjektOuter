package Prikazy;

import Hra.Hrac;
import Hra.Lokace;
import Hra.Postava;

public class PrikazMluv implements IPrikaz {
    private Hrac hrac;

    public PrikazMluv(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 2) {
            return "S kým mám mluvit?";
        }

        String jmenoPostavy = parametry[1];
        Lokace aktualniLokace = hrac.getAktualniLokace();
        Postava postava = aktualniLokace.getPostava(jmenoPostavy);

        if (postava != null) {
            return postava.getJmeno() + ": \"" + postava.getProslov() + "\"";
        } else {
            return "Nikdo takový tu není.";
        }
    }

    @Override
    public String getJmeno() {
        return "mluv";
    }
}
