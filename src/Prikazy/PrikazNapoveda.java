package Prikazy;

import Hra.Hrac;

/**
 * Příkaz pro zobrazení nápovědy specifické pro danou lokaci.
 * Rady se mění podle toho, co má hráč v inventáři.
 * 
 * @author janbucinsky
 */
public class PrikazNapoveda implements IPrikaz {

    private Hrac hrac;

    /**
     * Konstruktor příkazu.
     * 
     * @param hrac aktuální hráč
     */
    public PrikazNapoveda(Hrac hrac) {
        this.hrac = hrac;
    }

    /**
     * Provede vypsání nápovědy pro hráče.
     * Obsah nápovědy se mění podle aktuální lokace a stavu inventáře.
     * 
     * @param parametry pole parametrů (nepoužito)
     * @return textová nápověda pro hráče
     */
    @Override
    public String proved(String[] parametry) {
        String aktualniLokace = hrac.getAktualniLokace().getId();

        switch (aktualniLokace) {
            case "chateau":
                if (!hrac.getInventar().obsahujePredmet("kompas")) {
                    return "Měl bys tu pořádně prohledat okolí. Tvůj táta tu nechal starý kompas, který ti pomůže najít poklad.";
                }
                return "Teď když máš kompas, měl by ses vydat do harboru za Heywardem.";

            case "harbor":
                if (!hrac.getInventar().obsahujePredmet("listek")) {
                    return "Heyward by mohl vědět, jak se dostat do bohaté čtvrti Figure Eight. Zkus si s ním promluvit.";
                }
                return "Máš lístek na přívoz. Karta se obrací, ale cesta do Figure Eight vede přes maják (lighthouse).";

            case "wreck":
                if (!hrac.getInventar().obsahujePredmet("baterka")) {
                    return "V kryptě kostela bude tma. Kiara má určitě baterku, zkus si s ní promluvit tady v The Wreck.";
                }
                return "Baterku už máš. Můžeš pokračovat v cestě přes vrakoviště (junkyard).";

            case "junkyard":
                if (!hrac.getInventar().obsahujePredmet("nuget")) {
                    return "Kromě JJho by tu mohl být i zlatý nuget, který budeš potřebovat pro Sarah. Pořádně se tu porozhlédni.";
                }
                return "Máš nuget i radu od JJho. Pokračuj k majáku (lighthouse).";

            case "lighthouse":
                return "Pope na majáku ti pomůže pochopit logiku tátovy šifry. Promluv si s ním.";

            case "ferry":
                if (!hrac.getInventar().obsahujePredmet("listek") && !hrac.isPrevozPouzit()) {
                    return "Bez lístku tě převozník nepustí. Lístek by mohl mít Heyward v harboru.";
                }
                return "Můžeš pokračovat do Figure Eight (eight).";

            case "eight":
                if (hrac.getInventar().obsahujePredmet("nuget")) {
                    return "Sarah Cameron ti dá chybějící písmena šifry, pokud jí ukážeš ten zlatý nuget.";
                }
                return "Bez nugetu z vrakoviště ti Sarah asi nepomůže. Pokud už písmena od ní máš, jdi ke kostelu (church).";

            case "church":
                return "Topper ti stojí v cestě. Musíš ho přesvědčit (mluv) a pak sestoupit do krypty, která vede ke studně (well). Nezapomeň na baterku!";

            case "well":
                if (!hrac.isWardPorazen()) {
                    return "Ward Cameron tě nenechá jen tak odejít. Musíš ho konfrontovat (mluv).";
                }
                return "Ward je pryč! Teď už stačí jen zadat správné heslo příkazem 'zadej <HESLO>'. Pokud nevíš, podívej se na svá písmena pomocí 'sifra'.";

            default:
                return "Zkus prozkoumat okolí, mluvit s lidmi nebo se podívat, co máš v inventáři.";
        }
    }

    /**
     * @return klíčové slovo "napoveda"
     */
    @Override
    public String getJmeno() {
        return "napoveda";
    }
}
