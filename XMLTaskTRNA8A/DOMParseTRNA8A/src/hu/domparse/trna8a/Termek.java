package hu.domparse.trna8a;

public class Termek {
    private String tid;
    private String elnevezes;
    private String leiras;
    private int ar;

    private int raktarMennyiseg;

    private static Termek[] termekek;

    public Termek(String tid, String elnevezes, String leiras, int ar) {
        this.tid = tid;
        this.elnevezes = elnevezes;
        this.leiras = leiras;
        this.ar = ar;
    }
    public Termek(){}

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getElnevezes() {
        return elnevezes;
    }

    public void setElnevezes(String elnevezes) {
        this.elnevezes = elnevezes;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public static Termek[] getTermekek() {
        return termekek;
    }

    public static void setAr(Termek[] termekek) {
        Termek.termekek = termekek;
    }

    public static void CreateArray(int size){
        Termek.termekek = new Termek[size];
    }
    public static void AddToArray(Termek termek, int i){
        Termek.termekek[i] = termek;
    }

    public static Termek getTermekById(String tid){
        for (int i = 0;i<Termek.termekek.length;i++){
            if (Termek.termekek[i].tid.equals(tid)){
                return Termek.termekek[i];
            }
        }
        return new Termek();
    }

    @Override
    public String toString() {
        return "Termek{" +
                "tid='" + tid + '\'' +
                ", elnevezes='" + elnevezes + '\'' +
                ", leiras='" + leiras + '\'' +
                ", ar=" + ar +
                ", mennyiseg=" + raktarMennyiseg +
                '}';
    }

    public int getRaktarMennyiseg() {
        return raktarMennyiseg;
    }

    public void setRaktarMennyiseg(int mennyiseg) {
        this.raktarMennyiseg = mennyiseg;
    }

    public static void SetRaktarMennyiseg(int mennyiseg, String tid) {
        for (int i=0;i<Termek.termekek.length;i++){
            if (Termek.termekek[i].tid.equals(tid)){
                Termek.termekek[i].raktarMennyiseg = mennyiseg;
            }
        }
    }
}
