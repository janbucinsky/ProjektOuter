package Hra;

public class Postava {
    private String jmeno;
    private String proslov;
    
    public Postava(String jmeno, String proslov) {
        this.jmeno = jmeno;
        this.proslov = proslov;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getProslov() {
        return proslov;
    }

    public void setProslov(String proslov) {
        this.proslov = proslov;
    }
}
