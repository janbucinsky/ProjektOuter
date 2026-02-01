package Prikazy;

public class PrikazNapoveda implements IPrikaz {

    private PrikazPomoc prikazPomoc;

    public PrikazNapoveda(SeznamPrikazu seznamPrikazu) {
        this.prikazPomoc = new PrikazPomoc(seznamPrikazu);
    }

    @Override
    public String proved(String[] parametry) {
        return prikazPomoc.proved(parametry);
    }

    @Override
    public String getJmeno() {
        return "napoveda";
    }
}
