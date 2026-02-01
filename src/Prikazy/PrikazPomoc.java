package Prikazy;

public class PrikazPomoc implements IPrikaz {

    private SeznamPrikazu seznamPrikazu;

    public PrikazPomoc(SeznamPrikazu seznamPrikazu) {
        this.seznamPrikazu = seznamPrikazu;
    }

    @Override
    public String proved(String[] parametry) {
        return "Tvým úkolem je... neco neco neco\n" +
                "Můžeš zadávat tyto příkazy:\n" +
                seznamPrikazu.vratNazvyPrikazu();
    }

    @Override
    public String getJmeno() {
        return "pomoc";
    }
}
