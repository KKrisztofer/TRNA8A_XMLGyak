package hu.domparse.trna8a;

public class Futarceg {
    private String fid;
    private String nev;
    private String cim;
    private String szallitasiIdo;
    private int ar;

    private static Futarceg[] futarcegek;

    public Futarceg(String fid, String nev, String cim, String szallitasiIdo, int ar) {
        this.fid = fid;
        this.nev = nev;
        this.cim = cim;
        this.szallitasiIdo = szallitasiIdo;
        this.ar = ar;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getSzallitasiIdo() {
        return szallitasiIdo;
    }

    public void setSzallitasiIdo(String szallitasiIdo) {
        this.szallitasiIdo = szallitasiIdo;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public static Futarceg[] getFutarcegek() {
        return futarcegek;
    }

    public static void setFutarcegek(Futarceg[] futarcegek) {
        Futarceg.futarcegek = futarcegek;
    }

    public static void CreateArray(int size){
        Futarceg.futarcegek = new Futarceg[size];
    }

    public static void AddToArray(Futarceg futarceg, int i){
        Futarceg.futarcegek[i] = futarceg;
    }

    @Override
    public String toString() {
        return "Futarceg{" +
                "fid='" + fid + '\'' +
                ", nev='" + nev + '\'' +
                ", cim='" + cim + '\'' +
                ", szallitasiIdo='" + szallitasiIdo + '\'' +
                ", ar=" + ar +
                '}';
    }
}
