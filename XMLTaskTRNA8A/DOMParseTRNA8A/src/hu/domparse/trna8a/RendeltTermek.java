package hu.domparse.trna8a;

public class RendeltTermek extends Termek{

    private int rendeltMennyiseg;

    public RendeltTermek(String tid, String elnevezes, String leiras, int ar) {
        super(tid, elnevezes, leiras, ar);
    }
    public RendeltTermek(Termek termek, int rendeltMennyiseg) {
        super(termek.getTid(), termek.getElnevezes(), termek.getLeiras(), termek.getAr());
        this.rendeltMennyiseg = rendeltMennyiseg;
    }

    public int getRendeltMennyiseg() {
        return rendeltMennyiseg;
    }

    public void setRendeltMennyiseg(int rendeltMennyiseg) {
        this.rendeltMennyiseg = rendeltMennyiseg;
    }

    @Override
    public String toString() {
        return super.toString() + "RendeltTermek{" +
                "rendeltMennyiseg=" + rendeltMennyiseg +
                '}';
    }
}
