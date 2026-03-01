package Prikazy;

import Hra.Hrac;

public class PrikazZapis implements IPrikaz {
    private Hrac hrac;

    public PrikazZapis(Hrac hrac) {
        this.hrac = hrac;
    }

    /**
     * Vypíše všechna nalezená písmena hesla, která si hráč "zapsal" během
     * rozhovorů.
     * 
     * @param parametry parametry příkazu (nepoužito)
     * @return seznam nalezených písmen
     */
    @Override
    public String proved(String[] parametry) {
        return "Nalezená písmena hesla: " + hrac.getNalezenaPismena();
    }

    /**
     * @return klíčové slovo "sifra"
     */
    @Override
    public String getJmeno() {
        return "sifra";
    }
}
