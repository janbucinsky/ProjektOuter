package Hra;

/**
 * Třída Predmet reprezentuje věc, se kterou lze v rámci hry interagovat.
 * Předměty mají ID, název, popis a příznak, zda jsou užitečné.
 */
public class Predmet {
    private String id;
    private String name;
    private String description;
    private boolean isUseful;

    /**
     * @return unikátní ID předmětu
     */
    public String getId() {
        return id;
    }

    /**
     * @return název předmětu
     */
    public String getName() {
        return name;
    }

    /**
     * @return popis předmětu
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return true, pokud je předmět užitečný/klíčový
     */
    public boolean isUseful() {
        return isUseful;
    }

    /**
     * Konstruktor předmětu.
     * 
     * @param id          unikátní identifikátor předmětu
     * @param name        zobrazovaný název
     * @param description popis předmětu
     * @param isUseful    příznak užitečnosti
     */
    public Predmet(String id, String name, String description, boolean isUseful) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isUseful = isUseful;
    }

    /**
     * Bezparametrický konstruktor pro potřeby GSONu.
     */
    public Predmet() {
    }
}