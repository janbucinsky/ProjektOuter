package Hra;

public class Postava {
    private String id;
    private String name;
    private String role;
    private String description;
    private String homeLocationId;
    private String proslov;

    // Constructor for manual creation
    public Postava(String name, String proslov) {
        this.name = name;
        this.proslov = proslov;
    }

    public String getId() {
        return id;
    }

    public String getJmeno() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }

    public String getHomeLocationId() {
        return homeLocationId;
    }

    public String getProslov() {
        return proslov;
    }

    public void setProslov(String proslov) {
        this.proslov = proslov;
    }
}