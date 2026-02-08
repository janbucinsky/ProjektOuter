package Hra;

public class Predmet {
    private String id;
    private String name;
    private String description;
    private boolean isUseful;

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isUseful() { return isUseful; }


    public Predmet(String id, String name, String description, boolean isUseful) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isUseful = isUseful;
    }

    public Predmet() {
    }
}