package hu.domparse.trna8a;

public class Vasarlo {
    private String vid;
    private String vezeteknev;
    private String keresztnev;
    private String varos;
    private String utca;
    private String hazszam;
    private String telefonszam;

    private static Vasarlo[] vasarlok;

    public Vasarlo(String vid, String vezeteknev, String keresztnev, String varos, String utca, String hazszam, String telefonszam) {
        this.vid = vid;
        this.vezeteknev = vezeteknev;
        this.keresztnev = keresztnev;
        this.varos = varos;
        this.utca = utca;
        this.hazszam = hazszam;
        this.telefonszam = telefonszam;
    }

    public static Vasarlo[] getVasarlok() {
        return vasarlok;
    }

    public static void setVasarlok(Vasarlo[] vasarlok) {
        Vasarlo.vasarlok = vasarlok;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public void setKeresztnev(String keresztnev) {
        this.keresztnev = keresztnev;
    }

    public String getVaros() {
        return varos;
    }

    public void setVaros(String varos) {
        this.varos = varos;
    }

    public String getUtca() {
        return utca;
    }

    public void setUtca(String utca) {
        this.utca = utca;
    }

    public String getHazszam() {
        return hazszam;
    }

    public void setHazszam(String hazszam) {
        this.hazszam = hazszam;
    }

    public String getTelefonszam() {
        return telefonszam;
    }

    public void setTelefonszam(String telefonszam) {
        this.telefonszam = telefonszam;
    }

    public static void CreateArray(int size){
        Vasarlo.setVasarlok(new Vasarlo[size]);
    }
    public static void AddToArray(Vasarlo vasarlo, int i){
        Vasarlo.vasarlok[i] = vasarlo;
    }

    @Override
    public String toString() {
        return "Vasarlo{" +
                "vid=" + vid +
                ", vezeteknev='" + vezeteknev + '\'' +
                ", keresztnev='" + keresztnev + '\'' +
                ", varos='" + varos + '\'' +
                ", utca='" + utca + '\'' +
                ", hazszam='" + hazszam + '\'' +
                ", telefonszam='" + telefonszam + '\'' +
                '}';
    }
}
