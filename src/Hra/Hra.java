package Hra;

import Prikazy.*;
import java.util.Scanner;

public class Hra {

    private GameData world;
    private Hrac hrac;
    private SeznamPrikazu platnePrikazy;
    private boolean konecHry = false;

    public void inicialization() {
        world = GameData.loadGameDataFromResources("/GameData.json");
        Lokace startovniLokace = world.najdiLokaci("chateau");
        hrac = new Hrac(startovniLokace);
        platnePrikazy = new SeznamPrikazu();

        platnePrikazy.vlozPrikaz(new PrikazSeber(hrac));
        platnePrikazy.vlozPrikaz(new PrikazJdi(hrac));
        platnePrikazy.vlozPrikaz(new PrikazPomoc(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
        platnePrikazy.vlozPrikaz(new PrikazZahod(hrac));
        platnePrikazy.vlozPrikaz(new PrikazInventar(hrac));
        platnePrikazy.vlozPrikaz(new PrikazMluv(hrac));
        platnePrikazy.vlozPrikaz(new PrikazProzkoumej(hrac));
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(hrac));
        platnePrikazy.vlozPrikaz(new PrikazPouzij(hrac));
        platnePrikazy.vlozPrikaz(new PrikazOdpovez(hrac));
        platnePrikazy.vlozPrikaz(new PrikazZadej(this, hrac));
        platnePrikazy.vlozPrikaz(new PrikazZapis(hrac));
    }

    public void doPlay() {
        System.out.println("Vítejte ve hře!");
        System.out.println("Jste v: " + hrac.getAktualniLokace().getName());
        System.out.println(hrac.getAktualniLokace().getDescription());

        Scanner scanner = new Scanner(System.in);
        while (!konecHry) {
            System.out.print("> ");
            if (scanner.hasNextLine()) {
                String radek = scanner.nextLine();
                String vystup = zpracujPrikaz(radek);
                System.out.println(vystup);
            } else {
                konecHry = true;
            }
        }
        System.out.println("Hra skončila.");
    }

    public String zpracujPrikaz(String radek) {
        // mezera mezi dvema slovama
        String[] slova = radek.trim().split(" ");
        if (slova.length == 0) {
            return "Prázdný příkaz.";
        }

        String nazevPrikazu = slova[0].toLowerCase();
        if (platnePrikazy.jePlatnyPrikaz(nazevPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(nazevPrikazu);
            return prikaz.proved(slova);
        } else {
            return "Neznámý příkaz: " + nazevPrikazu;
        }
    }

    public void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }

    public boolean isKonecHry() {
        return konecHry;
    }

    public void vyhra() {
        this.konecHry = true;
        System.out.println("konec hry");
    }
}
