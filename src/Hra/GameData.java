package Hra;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Třída GameData slouží jako kontejner pro data načtená z JSON souboru.
 * Obsahuje seznamy předmětů, lokací a postav a metodu pro jejich načtení a
 * propojení.
 */

public class GameData {
    /** Seznam všech předmětů ve hře. */
    public ArrayList<Predmet> items;
    /** Seznam všech lokací ve hře. */
    public ArrayList<Lokace> locations;
    /** Seznam všech postav ve hře. */

    public ArrayList<Postava> characters;

    /**
     * Načte herní data ze zdroje (resource).
     * 
     * @param resourcePath cesta k JSON souboru v rámci resources
     * @return instanci GameData s načtenými daty
     */
    public static GameData loadGameDataFromResources(String resourcePath) {
        Gson gson = new Gson();
        try (InputStream is = GameData.class.getResourceAsStream(resourcePath)) {
            if (is == null)
                throw new IllegalStateException("Nenalezen: " + resourcePath);
            GameData data = gson.fromJson(new InputStreamReader(is, StandardCharsets.UTF_8), GameData.class);
            data.propojLokace();
            return data;
        } catch (Exception e) {
            throw new RuntimeException("Chyba JSON: " + e.getMessage());
        }
    }

    /**
     * Interní metoda pro propojení ID lokací se skutečnými instancemi Lokace.
     * Také rozmístí postavy do jejich domovských lokací.
     */
    private void propojLokace() {
        if (locations == null)
            return;
        for (Lokace loc : locations) {
            ArrayList<String> nIds = loc.getNeighborIds();
            if (nIds != null) {
                for (String id : nIds) {
                    Lokace soused = najdiLokaci(id);
                    if (soused != null)
                        loc.pridejSouseda(soused);
                }
            }
        }

        // Place characters
        if (characters != null) {
            for (Postava p : characters) {
                if ("PLAYER".equalsIgnoreCase(p.getRole()))
                    continue; // Skip player character in room list
                Lokace loc = najdiLokaci(p.getHomeLocationId());
                if (loc != null) {
                    loc.vlozPostavu(p);
                }
            }
        }
    }

    /**
     * Vyhledá lokaci podle jejího ID.
     * 
     * @param id identifikátor lokace
     * @return nalezená lokace nebo null
     */
    public Lokace najdiLokaci(String id) {
        for (Lokace l : locations) {
            if (l.getId().equals(id))
                return l;
        }
        return null;
    }
}