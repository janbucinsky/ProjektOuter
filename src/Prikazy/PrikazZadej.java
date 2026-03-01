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

    /**
     * Provede zadání hesla u finálního objektu (studny).
     * Kontroluje lokaci (Old Well), porážku Warda a přítomnost baterky (světla).
     * 
     * @param parametry parametry[1] je zadané heslo
     * @return zpráva o úspěchu (výhra) nebo nesprávném hesle
     */
    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 2) {
            return "Co mám zadat?";
        }

        Lokace aktualni = hrac.getAktualniLokace();
        if (!aktualni.getId().equals("well")) {
            return "Tady není kam co zadávat.";
        }

        if (!hrac.isWardPorazen()) {
            return "Ward ti stojí v cestě! Musíš se s ním nejdřív vypořádat (použij 'mluv').";
        }

        if (!hrac.getInventar().obsahujePredmet("baterka")) {
            return "K zadání hesla potřebuješ světlo! Bez baterky tu nic neuvidíš.";
        }

        String heslo = parametry[1].trim();
        if (heslo.equalsIgnoreCase("MERCHANT")) {
            hra.vyhra();
            return "Zadal jsi správné heslo! Poklad je tvůj!";
        } else {
            return "Špatné heslo! Zkus to znovu";
        }
    }

    /**
     * @return klíčové slovo "zadej"
     */
    @Override
    public String getJmeno() {
        return "zadej";
    }
}
