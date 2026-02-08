package Prikazy;

import Hra.Hrac;
import Hra.Lokace;
import Hra.Postava;
import Hra.Predmet;

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

        if (postava == null) {
            return "Nikdo takový tu není.";
        }

        String proslov = postava.getProslov();


        if (postava.getId() != null) {
            String charId = postava.getId().toLowerCase();
            if (charId.equals("heyward") && !hrac.getInventar().obsahujePredmet("listek")
                    && !aktualniLokace.obsahujePredmet("listek")) {



                Predmet listek = new Predmet("listek", "Lístek na přívoz",
                        "Propustka do bohaté čtvrti Figure Eight.", true);
                aktualniLokace.vlozPredmet(listek);
                proslov += "\n(Heyward ti položil Lístek na přívoz na stůl. Můžeš ho sebrat.)";
            }

            if (charId.equals("kiara") && !hrac.getInventar().obsahujePredmet("baterka")
                    && !aktualniLokace.obsahujePredmet("baterka")) {



                Predmet baterka = new Predmet("baterka", "Baterka", "Robustní svítilna.", true);
                aktualniLokace.vlozPredmet(baterka);
                proslov += "\n(Kiara ti podala Baterku. Leží teď vedle tebe.)";
            }
        }

        return postava.getJmeno() + ": " + proslov;
    }

    @Override
    public String getJmeno() {
        return "mluv";
    }
}
