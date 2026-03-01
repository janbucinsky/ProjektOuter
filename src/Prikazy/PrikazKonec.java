package Prikazy;

import Hra.Hra;

/**
 * Příkaz pro ukončení hry.
 * 
 * @author janbucinsky
 */
public class PrikazKonec implements IPrikaz {

    private Hra hra;

    /**
     * Konstruktor příkazu.
     * 
     * @param hra instance probíhající hry
     */
    public PrikazKonec(Hra hra) {
        this.hra = hra;
    }

    /**
     * Ukončí hru nastavením příznaku v hlavní třídě.
     * 
     * @param parametry pole parametrů (nemělo by obsahovat nic kromě názvu příkazu)
     * @return zpráva o ukončení hry
     */
    @Override
    public String proved(String[] parametry) {
        if (parametry.length > 1) {
            return "Příkaz konec nemá parametry.";
        }
        hra.setKonecHry(true);
        return "Hra ukončena.";
    }

    /**
     * @return klíčové slovo "konec"
     */
    @Override
    public String getJmeno() {
        return "konec";
    }
}
