package Prikazy;

public class PrikazOdpovez implements IPrikaz {
//todo odpoved
    @Override
    public String proved(String[] parametry) {
        return "dodelat";
    }

    @Override
    public String getJmeno() {
        return "odpovez";
    }
}
