package Prikazy;

import Hra.Hra;
import Hra.Hrac;
import Hra.Lokace;

public class PrikazOdpovez implements IPrikaz {
    private Hrac hrac;

    public PrikazOdpovez(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 3) {
            return "Komu a co mám odpovědět? (Např. 'odpovez Heyward A')";
        }

        String jmenoPostavy = parametry[1];
        String odpoved = parametry[2].toUpperCase();
        Lokace aktualni = hrac.getAktualniLokace();

        if (!aktualni.obsahujePostavu(jmenoPostavy)) {
            return "Postava " + jmenoPostavy + " tu není.";
        }

        switch (jmenoPostavy.toLowerCase()) {
            case "heyward":
                if (odpoved.equals("A")) {
                    hrac.pridejPismeno("M");
                    return "Heyward: 'Správná volba. První písmenko hesla je M.' (Písmeno M bylo zapsáno)";
                }
                return "Heyward: 'Tak si trhni. Nic ti neřeknu.'";

            case "kiara":
                if (odpoved.equals("B")) {
                    hrac.pridejPismeno("E");
                    return "Kiara: 'Správně! Tma je to, co nás v kryptě čeká. Tady máš tu baterku a tvoje písmeno je E.' (Písmeno E bylo zapsáno)";
                }
                return "Kiara: 'Těsně vedle, zkus to znovu. Bez tý baterky se dál nepohneš.'";

            case "jj":
                if (odpoved.equals("A")) {
                    hrac.pridejPismeno("R");
                    return "JJ: 'Jasně, kámo! Klíčem k úspěchu je tohle písmeno R. Zapiš si ho!' (Písmeno R bylo zapsáno)";
                }
                return "JJ: 'Kdepak, s hřebenem si tuhle loď nenastartuješ. Zkus to znova.'";

            case "pope":
                if (odpoved.equals("B")) {
                    hrac.pridejPismeno("C");
                    hrac.pridejPismeno("H");
                    return "Pope: 'Přesně tak, ticho... Skvělý, tak si zapiš písmena C a H.' (Písmena C, H byla zapsána)";
                }
                return "Pope: 'Tímhle jsi to akorát rozbil. Přemýšlej víc logicky.'";

            case "sarah":
            case "sarah_cameron":
                if (odpoved.equals("B")) {
                    if (hrac.getInventar().obsahujePredmet("zlaty_nuget")) {
                        hrac.getInventar().vyberPredmet("zlaty_nuget");
                        hrac.pridejPismeno("A");
                        hrac.pridejPismeno("N");
                        return "Sarah: 'Díky za ten nuget, tohle dokazuje, že jsi měl pravdu. Tady jsou písmena A a N.' (Zlatý nuget byl předán a písmena A, N byla zapsána)";
                    } else {
                        return "Sarah: 'Žádný nuget u sebe nemáš. Nelži mi!'";
                    }
                }
                return "Sarah: 'Bez důkazu ti nemůžu věřit.'";

            case "topper":
                if (odpoved.equals("A")) {
                    hrac.pridejPismeno("T");
                    return "Topper: 'Správně... v kostele všechno začíná i končí. Ber si T a zmiz.' (Písmeno T bylo zapsáno)";
                }
                return "Topper: 'Ztrať se, než zavolám šerifa!'";

            case "ward":
            case "ward_cameron":
                if (hrac.isWardPorazen()) {
                    return "Ward: ... (Ward leží v bezvědomí na zemi. Cesta ke studni je volná.)";
                }
                int stage = hrac.getWardDialogueStage();
                switch (stage) {
                    case 0:
                        if (odpoved.equals("A")) {
                            hrac.setWardDialogueStage(1);
                            return "Ward: 'Povídačky... Jsi sám. Tvoji přátelé tě opustili. Proč ještě bojuješ?' (Odpověz A: Jsem sám / B: Bojuju za pravdu)";
                        }
                        break;
                    case 1:
                        if (odpoved.equals("B")) {
                            hrac.setWardDialogueStage(2);
                            return "Ward: 'Pravda? Pravda je taková, že zlato patří těm, co ho udrží. Třeba mně.' (Odpověz A: Patří Pogues! / B: Možná máš pravdu)";
                        }
                        break;
                    case 2:
                        if (odpoved.equals("A")) {
                            hrac.setWardDialogueStage(3);
                            return "Ward vytahuje zbraň! Míří ti přímo na hruď. Co uděláš? (Odpověz A: Úskok doleva / B: Skočit za studnu)";
                        }
                        break;
                    case 3:
                        if (odpoved.equals("B")) {
                            hrac.setWardDialogueStage(4);
                            return "Ward vystřelil, ale trefil jen studnu. Teď musí přebít! Máš šanci. (Odpověz A: Skočit na něj / B: Zkusit mu domluvit)";
                        }
                        break;
                    case 4:
                        if (odpoved.equals("A")) {
                            hrac.setWardPorazen(true);
                            return "Srazil jsi Warda k zemi a vyrazil mu zbraň. Je v bezvědomí. Teď můžeš konečně ZADAT heslo do studny!";
                        }
                        break;
                }
                hrac.setWardDialogueStage(0);
                return "Ward: 'Chyba, Johne B. Tady tvá cesta končí.' (Musíš začít mluvit s Wardem odznova)";

            default:
                return "Postava " + jmenoPostavy + " nemá co říct nebo jsi zadal špatný formát.";
        }
    }

    @Override
    public String getJmeno() {
        return "odpovez";
    }
}