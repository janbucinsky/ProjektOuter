package test.Hra;

import Hra.*;
import Prikazy.*;

/**
 * Testovaci trida.
 * 
 * @author janbucinsky
 */
public class HraTest {

    public static void main(String[] args) {
        HraTest testy = new HraTest();

        testy.testPohyb();
        testy.testSebrani();
        testy.testBatoh();
        testy.testPrikaz();
    }

    // Test, jestli se hráč umí pohnout z místnosti do místnosti
    public void testPohyb() {
        Lokace l1 = new Lokace("start", "Start", "Popis");
        Lokace l2 = new Lokace("cil", "Cíl", "Popis");
        l1.pridejSouseda(l2);

        Hrac hrac = new Hrac(l1);

        PrikazJdi jdi = new PrikazJdi(hrac);

        jdi.proved(new String[] { "jdi", "cil" });

        if (hrac.getAktualniLokace() == l2) {
            System.out.println("Test pohyb: OK");

        } else {
            System.out.println("Test pohyb: CHYBA");
        }
    }

    // Test, jestli jde sebrat věc ze země
    public void testSebrani() {
        Lokace mistnost = new Lokace("m", "M", "D");
        Predmet vec = new Predmet("vec", "Věc", "D", true);
        mistnost.vlozPredmet(vec);

        Hrac hrac = new Hrac(mistnost);
        PrikazSeber seber = new PrikazSeber(hrac);

        seber.proved(new String[] { "seber", "vec" });

        if (hrac.getInventar().obsahujePredmet("vec")) {
            System.out.println("Test sebrání: OK");
        }
        else {
            System.out.println("Test sebrání: CHYBA");
        }
    }

    // Test, jestli se do batohu nevejde víc věcí, než je kapacita
    public void testBatoh() {
        Inventar batoh = new Inventar(1);
        Predmet p1 = new Predmet("p1", "v1", "d", true);
        Predmet p2 = new Predmet("p2", "v2", "d", true);

        batoh.vlozPredmet(p1);
        boolean sloTo = batoh.vlozPredmet(p2);

        if (sloTo == false) {
            System.out.println("Test batoh: OK");
        } else {
            System.out.println("Test batoh: CHYBA");
        }
    }

    // Test, jestli hra pozná špatný příkaz
    public void testPrikaz() {
        Hra hra = new Hra();
        hra.inicialization();

        String text = hra.zpracujPrikaz("bla blalala");

        if (text.contains("Neznámý příkaz")) {
            System.out.println("Test příkaz: OK");
        } else {
            System.out.println("Test příkaz: CHYBA");
        }
    }
}
