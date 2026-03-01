package Prikazy;

import Hra.Hrac;

/**
 * Příkaz pro zobrazení obsahu inventáře hráče.
 */
public class PrikazInventar implements IPrikaz {
    private Hrac hrac;

    /**
     * Konstruktor příkazu.
     * @param hrac aktuální hráč
     */
    public PrikazInventar(Hrac hrac) {
        this.hrac = hrac;
    }

    /**
     * Provede vypsání obsahu inventáře.
     * @return seznam věcí v inventáři
     */
    @Override
    public String proved(String[] parametry) {
        return hrac.getInventar().getSeznamVeci();
    }

    /**
     * @return klíčové slovo "inventar"
     */
    @Override
    public String getJmeno() {
        return "inventar";
    }
}
