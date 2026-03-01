package Prikazy;

/**
 * Rozhraní IPrikaz definuje metodu pro provádění herních příkazů.
 * 
 * @author janbucinsky
 */
public interface IPrikaz {
    /**
     * Provede příkaz s danými parametry.
     * 
     * @param parametry pole parametrů příkazu (včetně názvu příkazu na indexu 0)
     * @return textová odpověď, která se vypíše hráči
     */
    String proved(String[] parametry);

    /**
     * Vrátí název příkazu (klíčové slovo), na které se reaguje.
     * 
     * @return název příkazu
     */
    String getJmeno();
}
