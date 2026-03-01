package Hra;

/**
 * Třída Postava reprezentuje NPC v herním světě.
 * Každá postava má své jméno, roli, popis a úvodní proslov.
 */
public class Postava {
    private String id;
    private String name;
    private String role;
    private String description;
    private String homeLocationId;
    private String proslov;

    /**
     * Konstruktor pro ruční vytvoření postavy.
     * 
     * @param name    jméno postavy
     * @param proslov úvodní řeč postavy
     */
    public Postava(String name, String proslov) {
        this.name = name;
        this.proslov = proslov;
    }

    /**
     * @return unikátní ID postavy
     */
    public String getId() {
        return id;
    }

    /**
     * @return jméno postavy
     */
    public String getJmeno() {
        return name;
    }

    /**
     * @return zobrazitelný název postavy
     */
    public String getName() {
        return name;
    }

    /**
     * @return role postavy (např. PLAYER)
     */
    public String getRole() {
        return role;
    }

    /**
     * @return detailní popis postavy
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return ID domovské lokace postavy
     */
    public String getHomeLocationId() {
        return homeLocationId;
    }

    /**
     * @return úvodní řeč postavy
     */
    public String getProslov() {
        return proslov;
    }

    /**
     * @param proslov nastaví novou úvodní řeč postavy
     */
    public void setProslov(String proslov) {
        this.proslov = proslov;
    }
}