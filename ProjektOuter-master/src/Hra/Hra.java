package Hra;

import Prikazy.*;

import java.util.HashMap;

public class Hra {

    private GameData world;
    private Hrac hrac;
    private HashMap<String, Prikazy> prikazy;

    public void inicialization() {
        prikazy = new HashMap<>();
        world = GameData.loadGameDataFromResources("/gamedata.json");
        Lokace startovniLokace = world.najdiLokaci("chateau");
        hrac = new Hrac(startovniLokace);

        // TODO pridat prikazy
        prikazy.put("seber", new PrikazSeber(hrac));

    }

}
