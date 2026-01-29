package Hra;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class GameData {
    public ArrayList<Predmet> items;
    public ArrayList<Lokace> locations;
    public ArrayList<Hrac> characters;

    public static GameData loadGameDataFromResources(String resourcePath) {
        Gson gson = new Gson();
        try (InputStream is = GameData.class.getResourceAsStream(resourcePath)) {
            if (is == null) throw new IllegalStateException("Nenalezen: " + resourcePath);
            GameData data = gson.fromJson(new InputStreamReader(is, StandardCharsets.UTF_8), GameData.class);
            data.propojLokace();
            return data;
        } catch (Exception e) {
            throw new RuntimeException("Chyba JSON: " + e.getMessage());
        }
    }

    private void propojLokace() {
        if (locations == null) return;
        for (Lokace loc : locations) {
            ArrayList<String> nIds = loc.getNeighborIds();
            if (nIds == null) continue;
            for (String id : nIds) {
                Lokace soused = najdiLokaci(id);
                if (soused != null) loc.pridejSouseda(soused);
            }
        }
    }

    public Lokace najdiLokaci(String id) {
        for (Lokace l : locations) {
            if (l.getId().equals(id)) return l;
        }
        return null;
    }
}