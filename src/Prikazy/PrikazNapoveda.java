package Prikazy;

import Hra.Hrac;

public class PrikazNapoveda implements IPrikaz {

    private Hrac hrac;

    public PrikazNapoveda(Hrac hrac) {
        this.hrac = hrac;
    }



    @Override
    public String proved(String[] parametry) {
        String aktualniLokace = hrac.getAktualniLokace().getId();

        switch (aktualniLokace) {
            case "chateau":
                if (!hrac.getInventar().obsahujePredmet("kompas")) {
                    return "doplnit";
                }
                return "doplnit";


            case "cut_harbor":
                if (!hrac.getInventar().obsahujePredmet("listek")) {
                    return "doplnit";
                }
                return "doplnit";

            case "the_wreck":
                if (!hrac.getInventar().obsahujePredmet("baterka")) {
                    return "doplnit";
                }
                return "doplnit";

            case "junkyard":
                return "doplnit";

            case "lighthouse":
                return "doplnit";

            case "figure_eight":
                return "doplnit";

            case "tannyhill_church":
                return "doplnit";

            default:
                return "doplnit";
        }
    }


    @Override
    public String getJmeno() {
        return "napoveda";
    }
}
