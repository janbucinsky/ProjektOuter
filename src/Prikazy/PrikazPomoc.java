package Prikazy;

/**
 * Příkaz pro zobrazení obecné nápovědy a seznamu všech platných příkazů.
 * 
 * @author janbucinsky
 */
public class PrikazPomoc implements IPrikaz {

    private SeznamPrikazu seznamPrikazu;

    /**
     * Konstruktor příkazu.
     * 
     * @param seznamPrikazu seznam všech dostupných příkazů
     */
    public PrikazPomoc(SeznamPrikazu seznamPrikazu) {
        this.seznamPrikazu = seznamPrikazu;
    }

    /**
     * Provede vypsání obecné pomoci a seznamu všech příkazů.
     * 
     * @param parametry parametry příkazu (nepoužito)
     * @return základní nápověda a seznam příkazů
     */
    @Override
    public String proved(String[] parametry) {
        return "Tvým úkolem je... neco neco neco\n" +
                "Můžeš zadávat tyto příkazy:\n" +
                seznamPrikazu.vratNazvyPrikazu();
    }

    /**
     * @return klíčové slovo "pomoc"
     */
    @Override
    public String getJmeno() {
        return "pomoc";
    }
}
