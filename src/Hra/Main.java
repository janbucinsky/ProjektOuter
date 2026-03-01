package Hra;

/**
 * Hlavní třída pro spuštění hry ProjektOuter.
 * 
 * @author janbucinsky
 */
public class Main {
    /**
     * Spouštěcí metoda aplikace.
     */
    public static void main(String[] args) {
        Hra hra = new Hra();
        hra.inicialization();
        hra.doPlay();
    }
}